package cel1.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUsuario {

    public static void agregarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;

        try {
            if (usuario.getId() == null || usuario.getId().isEmpty()) {
                throw new SQLException("El ID del usuario no puede estar vacío");
            }

            baseDatos.conectar();
            String sql = "INSERT INTO usuarios (id, clave, nombre, rol, email) VALUES (?, ?, ?, ?, ?)";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, usuario.getId());
            sentenciaSQL.setString(2, usuario.getClave());
            sentenciaSQL.setString(3, usuario.getNombre());
            sentenciaSQL.setString(4, usuario.getRol());
            sentenciaSQL.setString(5, usuario.getEmail());

            baseDatos.actualizar(sentenciaSQL);

        } catch (SQLException e) {
            throw new SQLException("Error al agregar usuario: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al cargar driver: " + e.getMessage());
        } finally {
            try {
                if (sentenciaSQL != null) {
                    sentenciaSQL.close();
                }
                baseDatos.desconectar();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public static void modificarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;

        try {
            baseDatos.conectar();
            String sql = "UPDATE usuarios SET clave = ?, nombre = ?, rol = ?, email = ? WHERE id = ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, usuario.getClave());
            sentenciaSQL.setString(2, usuario.getNombre());
            sentenciaSQL.setString(3, usuario.getRol());
            sentenciaSQL.setString(4, usuario.getEmail());
            sentenciaSQL.setString(5, usuario.getId());

            baseDatos.actualizar(sentenciaSQL);

        } catch (SQLException e) {
            throw new SQLException("Error al modificar usuario: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al cargar driver: " + e.getMessage());
        } finally {
            try {
                if (sentenciaSQL != null) {
                    sentenciaSQL.close();
                }
                baseDatos.desconectar();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public static void eliminarUsuario(String id) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;

        try {
            baseDatos.conectar();
            String sql = "DELETE FROM usuarios WHERE id = ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, id);

            baseDatos.actualizar(sentenciaSQL);

        } catch (SQLException e) {
            throw new SQLException("Error al eliminar usuario: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al cargar driver: " + e.getMessage());
        } finally {
            try {
                if (sentenciaSQL != null) {
                    sentenciaSQL.close();
                }
                baseDatos.desconectar();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public static Usuario consultarUsuario(String id) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, id);

            resultado = baseDatos.consultar(sentenciaSQL);

            if (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getString("id"));
                usuario.setClave(resultado.getString("clave"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setRol(resultado.getString("rol"));
                usuario.setEmail(resultado.getString("email"));
                return usuario;
            } else {
                throw new SQLException("No se encontró usuario con ID: " + id);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al consultar usuario: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al cargar driver: " + e.getMessage());
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (sentenciaSQL != null) {
                    sentenciaSQL.close();
                }
                baseDatos.desconectar();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public static Usuario[] listarTodosLosUsuarios() throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM usuarios";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            resultado = baseDatos.consultar(sentenciaSQL);

            List<Usuario> lista = new ArrayList<>();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getString("id"));
                usuario.setClave(resultado.getString("clave"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setRol(resultado.getString("rol"));
                usuario.setEmail(resultado.getString("email"));
                lista.add(usuario);
            }

            if (lista.isEmpty()) {
                throw new SQLException("No hay usuarios registrados en la base de datos");
            }

            return lista.toArray(new Usuario[0]);

        } catch (SQLException e) {
            throw new SQLException("Error al listar usuarios: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al cargar driver: " + e.getMessage());
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (sentenciaSQL != null) {
                    sentenciaSQL.close();
                }
                baseDatos.desconectar();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public static Usuario iniciarSesion(String id, String clave) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM usuarios WHERE id = ? AND clave = ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, id);
            sentenciaSQL.setString(2, clave);

            resultado = baseDatos.consultar(sentenciaSQL);

            if (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getString("id"));
                usuario.setClave(resultado.getString("clave"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setRol(resultado.getString("rol"));
                usuario.setEmail(resultado.getString("email"));
                return usuario;
            } else {
                throw new SQLException("Credenciales incorrectas. ID o clave inválidos.");
            }

        } catch (SQLException e) {
            throw new SQLException("Error al iniciar sesión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al cargar driver: " + e.getMessage());
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (sentenciaSQL != null) {
                    sentenciaSQL.close();
                }
                baseDatos.desconectar();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public static Usuario[] buscarPorRol(String rol) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM usuarios WHERE rol = ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, rol);

            resultado = baseDatos.consultar(sentenciaSQL);

            List<Usuario> lista = new ArrayList<>();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getString("id"));
                usuario.setClave(resultado.getString("clave"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setRol(resultado.getString("rol"));
                usuario.setEmail(resultado.getString("email"));
                lista.add(usuario);
            }

            if (lista.isEmpty()) {
                throw new SQLException("No se encontraron usuarios con rol: " + rol);
            }

            return lista.toArray(new Usuario[0]);

        } catch (SQLException e) {
            throw new SQLException("Error al buscar por rol: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al cargar driver: " + e.getMessage());
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (sentenciaSQL != null) {
                    sentenciaSQL.close();
                }
                baseDatos.desconectar();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public static Usuario[] buscarPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM usuarios WHERE nombre LIKE ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, "%" + nombre + "%");

            resultado = baseDatos.consultar(sentenciaSQL);

            List<Usuario> lista = new ArrayList<>();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getString("id"));
                usuario.setClave(resultado.getString("clave"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setRol(resultado.getString("rol"));
                usuario.setEmail(resultado.getString("email"));
                lista.add(usuario);
            }

            if (lista.isEmpty()) {
                throw new SQLException("No se encontraron usuarios con nombre: " + nombre);
            }

            return lista.toArray(new Usuario[0]);

        } catch (SQLException e) {
            throw new SQLException("Error al buscar por nombre: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al cargar driver: " + e.getMessage());
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (sentenciaSQL != null) {
                    sentenciaSQL.close();
                }
                baseDatos.desconectar();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
