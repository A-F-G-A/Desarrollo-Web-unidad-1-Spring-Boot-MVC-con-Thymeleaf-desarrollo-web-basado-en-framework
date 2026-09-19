package cel1.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBaseDatos {
    private String url;
    private String usuario;
    private String password;
    private Connection conexion;
    private Properties configuracion;

    public ConexionBaseDatos() {
        this.conexion = null;
        this.configuracion = new Properties();
        cargarConfiguracion();
    }

    private void cargarConfiguracion() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                // Valores por defecto si no existe el archivo de configuración
                this.url = "jdbc:mysql://localhost:3306/desarrollo_web?useSSL=false&serverTimezone=UTC";
                this.usuario = "root";
                this.password = "[REDACTED_DB_PASSWORD]";
                System.out.println("WARNING: No se encontró config.properties, usando valores por defecto");
            } else {
                configuracion.load(input);
                this.url = configuracion.getProperty("db.url");
                this.usuario = configuracion.getProperty("db.usuario");
                this.password = configuracion.getProperty("db.password");
                System.out.println("Configuración cargada exitosamente desde config.properties");
                System.out.println("Usuario: " + this.usuario);
                System.out.println("Password tiene longitud: " + (this.password != null ? this.password.length() : 0));
            }
        } catch (IOException ex) {
            // Valores por defecto en caso de error
            this.url = "jdbc:mysql://localhost:3306/desarrollo_web?useSSL=false&serverTimezone=UTC";
            this.usuario = "root";
            this.password = "[REDACTED_DB_PASSWORD]";
            System.out.println("ERROR al cargar config.properties: " + ex.getMessage());
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void conectar() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Intentando conectar con:");
            System.out.println("URL: " + url);
            System.out.println("Usuario: " + usuario);
            System.out.println("Password longitud: " + (password != null ? password.length() : 0));
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error SQL al conectar: " + e.getMessage());
            throw new SQLException("Error al conectar a la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error ClassNotFoundException: " + e.getMessage());
            throw new ClassNotFoundException("Driver MySQL no encontrado: " + e.getMessage());
        }
    }

    public void actualizar(PreparedStatement sentencia) throws SQLException {
        try {
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al ejecutar actualización: " + e.getMessage());
        }
    }

    public ResultSet consultar(PreparedStatement sentencia) throws SQLException {
        try {
            return sentencia.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error al ejecutar consulta: " + e.getMessage());
        }
    }

    public void desconectar() throws SQLException {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw new SQLException("Error al desconectar: " + e.getMessage());
        }
    }

    public PreparedStatement crearSentencia(String sql) throws SQLException {
        try {
            return conexion.prepareStatement(sql);
        } catch (SQLException e) {
            throw new SQLException("Error al crear sentencia: " + e.getMessage());
        }
    }
}
