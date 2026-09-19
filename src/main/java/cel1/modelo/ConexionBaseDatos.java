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
        // 1. Prioridad: Variables de Entorno del sistema (Producción / Nube / Docker / Render / Railway)
        String envUrl = System.getenv("DB_URL");
        if (envUrl == null || envUrl.trim().isEmpty()) {
            envUrl = System.getenv("JDBC_DATABASE_URL");
        }
        String envUser = System.getenv("DB_USER");
        if (envUser == null || envUser.trim().isEmpty()) {
            envUser = System.getenv("MYSQLUSER");
        }
        String envPassword = System.getenv("DB_PASSWORD");
        if (envPassword == null) {
            envPassword = System.getenv("MYSQLPASSWORD");
        }

        // Si existen variables de entorno completas en producción
        if (envUrl != null && !envUrl.trim().isEmpty()) {
            this.url = envUrl.trim();
            this.usuario = (envUser != null) ? envUser.trim() : "root";
            this.password = (envPassword != null) ? envPassword : "";
            System.out.println("Configuración de BD cargada desde variables de entorno (Producción)");
            return;
        }

        // Si se especifican variables separadas de host/puerto/db de MySQL (ej. Railway/Docker)
        String mysqlHost = System.getenv("MYSQLHOST");
        String mysqlPort = System.getenv("MYSQLPORT");
        String mysqlDb = System.getenv("MYSQLDATABASE");
        if (mysqlHost != null && !mysqlHost.trim().isEmpty()) {
            String port = (mysqlPort != null && !mysqlPort.trim().isEmpty()) ? mysqlPort.trim() : "3306";
            String db = (mysqlDb != null && !mysqlDb.trim().isEmpty()) ? mysqlDb.trim() : "desarrollo_web";
            this.url = "jdbc:mysql://" + mysqlHost.trim() + ":" + port + "/" + db + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            this.usuario = (envUser != null) ? envUser.trim() : "root";
            this.password = (envPassword != null) ? envPassword : "";
            System.out.println("Configuración de BD cargada desde variables MYSQLHOST (Producción)");
            return;
        }

        // 2. Segunda Prioridad: Propiedades del sistema (-Ddb.url, -Ddb.usuario, -Ddb.password)
        String sysUrl = System.getProperty("db.url");
        if (sysUrl != null && !sysUrl.trim().isEmpty()) {
            this.url = sysUrl.trim();
            this.usuario = System.getProperty("db.usuario", "root");
            this.password = System.getProperty("db.password", "");
            System.out.println("Configuración de BD cargada desde System properties");
            return;
        }

        // 3. Tercera Prioridad: Archivo config.properties (Desarrollo Local)
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                configuracion.load(input);
                this.url = configuracion.getProperty("db.url", "jdbc:mysql://localhost:3306/desarrollo_web?useSSL=false&serverTimezone=UTC");
                this.usuario = configuracion.getProperty("db.usuario", "root");
                this.password = configuracion.getProperty("db.password", "");
                System.out.println("Configuración de BD cargada desde config.properties");
            } else {
                usarValoresPorDefecto();
            }
        } catch (IOException ex) {
            System.out.println("ERROR al cargar config.properties: " + ex.getMessage());
            usarValoresPorDefecto();
        }
    }

    private void usarValoresPorDefecto() {
        this.url = "jdbc:mysql://localhost:3306/desarrollo_web?useSSL=false&serverTimezone=UTC";
        this.usuario = "root";
        this.password = "";
        System.out.println("WARNING: Usando valores de BD por defecto para desarrollo local");
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
