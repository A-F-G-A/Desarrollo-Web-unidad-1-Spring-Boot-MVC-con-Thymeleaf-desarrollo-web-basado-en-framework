package cel1.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDCelular {

    public static void agregarCelular(Celular celular) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;

        try {
            if (celular.getId() == null || celular.getId().isEmpty()) {
                throw new SQLException("El ID del celular no puede estar vacío");
            }

            baseDatos.conectar();
            String sql = "INSERT INTO celulares (id, marca, imei, pulgadas, megapixeles, ram, " +
                        "almacenamientoPrincipal, almacenamientoSecundario, sistemaOperativo, operador, " +
                        "tecnologiaBanda, wifi, bluetooth, camaras, marcaCpu, velocidadCpu, " +
                        "nfc, huella, ir, resisteAgua, cantidadSim) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, celular.getId());
            sentenciaSQL.setString(2, celular.getMarca());
            sentenciaSQL.setString(3, celular.getImei());
            sentenciaSQL.setString(4, celular.getPulgadas());
            sentenciaSQL.setString(5, celular.getMegapixeles());
            sentenciaSQL.setString(6, celular.getRam());
            sentenciaSQL.setString(7, celular.getAlmacenamientoPrincipal());
            sentenciaSQL.setString(8, celular.getAlmacenamientoSecundario());
            sentenciaSQL.setString(9, celular.getSistemaOperativo());
            sentenciaSQL.setString(10, celular.getOperador());
            sentenciaSQL.setString(11, celular.getTecnologiaBanda());
            sentenciaSQL.setString(12, celular.getWifi());
            sentenciaSQL.setString(13, celular.getBluetooth());
            sentenciaSQL.setString(14, celular.getCamaras());
            sentenciaSQL.setString(15, celular.getMarcaCpu());
            sentenciaSQL.setString(16, celular.getVelocidadCpu());
            sentenciaSQL.setString(17, celular.getNfc());
            sentenciaSQL.setString(18, celular.getHuella());
            sentenciaSQL.setString(19, celular.getIr());
            sentenciaSQL.setString(20, celular.getResisteAgua());
            sentenciaSQL.setString(21, celular.getCantidadSim());

            baseDatos.actualizar(sentenciaSQL);

        } catch (SQLException e) {
            throw new SQLException("Error al agregar celular: " + e.getMessage());
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

    public static void modificarCelular(Celular celular) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;

        try {
            baseDatos.conectar();
            String sql = "UPDATE celulares SET marca = ?, imei = ?, pulgadas = ?, megapixeles = ?, " +
                        "ram = ?, almacenamientoPrincipal = ?, almacenamientoSecundario = ?, " +
                        "sistemaOperativo = ?, operador = ?, tecnologiaBanda = ?, wifi = ?, " +
                        "bluetooth = ?, camaras = ?, marcaCpu = ?, velocidadCpu = ?, " +
                        "nfc = ?, huella = ?, ir = ?, resisteAgua = ?, cantidadSim = ? WHERE id = ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, celular.getMarca());
            sentenciaSQL.setString(2, celular.getImei());
            sentenciaSQL.setString(3, celular.getPulgadas());
            sentenciaSQL.setString(4, celular.getMegapixeles());
            sentenciaSQL.setString(5, celular.getRam());
            sentenciaSQL.setString(6, celular.getAlmacenamientoPrincipal());
            sentenciaSQL.setString(7, celular.getAlmacenamientoSecundario());
            sentenciaSQL.setString(8, celular.getSistemaOperativo());
            sentenciaSQL.setString(9, celular.getOperador());
            sentenciaSQL.setString(10, celular.getTecnologiaBanda());
            sentenciaSQL.setString(11, celular.getWifi());
            sentenciaSQL.setString(12, celular.getBluetooth());
            sentenciaSQL.setString(13, celular.getCamaras());
            sentenciaSQL.setString(14, celular.getMarcaCpu());
            sentenciaSQL.setString(15, celular.getVelocidadCpu());
            sentenciaSQL.setString(16, celular.getNfc());
            sentenciaSQL.setString(17, celular.getHuella());
            sentenciaSQL.setString(18, celular.getIr());
            sentenciaSQL.setString(19, celular.getResisteAgua());
            sentenciaSQL.setString(20, celular.getCantidadSim());
            sentenciaSQL.setString(21, celular.getId());

            baseDatos.actualizar(sentenciaSQL);

        } catch (SQLException e) {
            throw new SQLException("Error al modificar celular: " + e.getMessage());
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

    public static void eliminarCelular(String id) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;

        try {
            baseDatos.conectar();
            String sql = "DELETE FROM celulares WHERE id = ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, id);

            baseDatos.actualizar(sentenciaSQL);

        } catch (SQLException e) {
            throw new SQLException("Error al eliminar celular: " + e.getMessage());
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

    public static Celular consultarCelular(String id) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM celulares WHERE id = ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, id);

            resultado = baseDatos.consultar(sentenciaSQL);

            if (resultado.next()) {
                Celular celular = new Celular();
                celular.setId(resultado.getString("id"));
                celular.setMarca(resultado.getString("marca"));
                celular.setImei(resultado.getString("imei"));
                celular.setPulgadas(resultado.getString("pulgadas"));
                celular.setMegapixeles(resultado.getString("megapixeles"));
                celular.setRam(resultado.getString("ram"));
                celular.setAlmacenamientoPrincipal(resultado.getString("almacenamientoPrincipal"));
                celular.setAlmacenamientoSecundario(resultado.getString("almacenamientoSecundario"));
                celular.setSistemaOperativo(resultado.getString("sistemaOperativo"));
                celular.setOperador(resultado.getString("operador"));
                celular.setTecnologiaBanda(resultado.getString("tecnologiaBanda"));
                celular.setWifi(resultado.getString("wifi"));
                celular.setBluetooth(resultado.getString("bluetooth"));
                celular.setCamaras(resultado.getString("camaras"));
                celular.setMarcaCpu(resultado.getString("marcaCpu"));
                celular.setVelocidadCpu(resultado.getString("velocidadCpu"));
                celular.setNfc(resultado.getString("nfc"));
                celular.setHuella(resultado.getString("huella"));
                celular.setIr(resultado.getString("ir"));
                celular.setResisteAgua(resultado.getString("resisteAgua"));
                celular.setCantidadSim(resultado.getString("cantidadSim"));
                return celular;
            } else {
                throw new SQLException("No se encontró celular con ID: " + id);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al consultar celular: " + e.getMessage());
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

    public static Celular[] listarTodosLosCelulares() throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM celulares";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            resultado = baseDatos.consultar(sentenciaSQL);

            List<Celular> lista = new ArrayList<>();
            while (resultado.next()) {
                Celular celular = new Celular();
                celular.setId(resultado.getString("id"));
                celular.setMarca(resultado.getString("marca"));
                celular.setImei(resultado.getString("imei"));
                celular.setPulgadas(resultado.getString("pulgadas"));
                celular.setMegapixeles(resultado.getString("megapixeles"));
                celular.setRam(resultado.getString("ram"));
                celular.setAlmacenamientoPrincipal(resultado.getString("almacenamientoPrincipal"));
                celular.setAlmacenamientoSecundario(resultado.getString("almacenamientoSecundario"));
                celular.setSistemaOperativo(resultado.getString("sistemaOperativo"));
                celular.setOperador(resultado.getString("operador"));
                celular.setTecnologiaBanda(resultado.getString("tecnologiaBanda"));
                celular.setWifi(resultado.getString("wifi"));
                celular.setBluetooth(resultado.getString("bluetooth"));
                celular.setCamaras(resultado.getString("camaras"));
                celular.setMarcaCpu(resultado.getString("marcaCpu"));
                celular.setVelocidadCpu(resultado.getString("velocidadCpu"));
                celular.setNfc(resultado.getString("nfc"));
                celular.setHuella(resultado.getString("huella"));
                celular.setIr(resultado.getString("ir"));
                celular.setResisteAgua(resultado.getString("resisteAgua"));
                celular.setCantidadSim(resultado.getString("cantidadSim"));
                lista.add(celular);
            }

            if (lista.isEmpty()) {
                throw new SQLException("No hay celulares registrados en la base de datos");
            }

            return lista.toArray(new Celular[0]);

        } catch (SQLException e) {
            throw new SQLException("Error al listar celulares: " + e.getMessage());
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

    public static Celular[] buscarPorMarca(String marca) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM celulares WHERE marca LIKE ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, "%" + marca + "%");

            resultado = baseDatos.consultar(sentenciaSQL);

            List<Celular> lista = new ArrayList<>();
            while (resultado.next()) {
                Celular celular = new Celular();
                celular.setId(resultado.getString("id"));
                celular.setMarca(resultado.getString("marca"));
                celular.setImei(resultado.getString("imei"));
                celular.setPulgadas(resultado.getString("pulgadas"));
                celular.setMegapixeles(resultado.getString("megapixeles"));
                celular.setRam(resultado.getString("ram"));
                celular.setAlmacenamientoPrincipal(resultado.getString("almacenamientoPrincipal"));
                celular.setAlmacenamientoSecundario(resultado.getString("almacenamientoSecundario"));
                celular.setSistemaOperativo(resultado.getString("sistemaOperativo"));
                celular.setOperador(resultado.getString("operador"));
                celular.setTecnologiaBanda(resultado.getString("tecnologiaBanda"));
                celular.setWifi(resultado.getString("wifi"));
                celular.setBluetooth(resultado.getString("bluetooth"));
                celular.setCamaras(resultado.getString("camaras"));
                celular.setMarcaCpu(resultado.getString("marcaCpu"));
                celular.setVelocidadCpu(resultado.getString("velocidadCpu"));
                celular.setNfc(resultado.getString("nfc"));
                celular.setHuella(resultado.getString("huella"));
                celular.setIr(resultado.getString("ir"));
                celular.setResisteAgua(resultado.getString("resisteAgua"));
                celular.setCantidadSim(resultado.getString("cantidadSim"));
                lista.add(celular);
            }

            if (lista.isEmpty()) {
                throw new SQLException("No se encontraron celulares con marca: " + marca);
            }

            return lista.toArray(new Celular[0]);

        } catch (SQLException e) {
            throw new SQLException("Error al buscar por marca: " + e.getMessage());
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

    public static Celular[] buscarPorSistemaOperativo(String sistemaOperativo) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM celulares WHERE sistemaOperativo LIKE ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, "%" + sistemaOperativo + "%");

            resultado = baseDatos.consultar(sentenciaSQL);

            List<Celular> lista = new ArrayList<>();
            while (resultado.next()) {
                Celular celular = new Celular();
                celular.setId(resultado.getString("id"));
                celular.setMarca(resultado.getString("marca"));
                celular.setImei(resultado.getString("imei"));
                celular.setPulgadas(resultado.getString("pulgadas"));
                celular.setMegapixeles(resultado.getString("megapixeles"));
                celular.setRam(resultado.getString("ram"));
                celular.setAlmacenamientoPrincipal(resultado.getString("almacenamientoPrincipal"));
                celular.setAlmacenamientoSecundario(resultado.getString("almacenamientoSecundario"));
                celular.setSistemaOperativo(resultado.getString("sistemaOperativo"));
                celular.setOperador(resultado.getString("operador"));
                celular.setTecnologiaBanda(resultado.getString("tecnologiaBanda"));
                celular.setWifi(resultado.getString("wifi"));
                celular.setBluetooth(resultado.getString("bluetooth"));
                celular.setCamaras(resultado.getString("camaras"));
                celular.setMarcaCpu(resultado.getString("marcaCpu"));
                celular.setVelocidadCpu(resultado.getString("velocidadCpu"));
                celular.setNfc(resultado.getString("nfc"));
                celular.setHuella(resultado.getString("huella"));
                celular.setIr(resultado.getString("ir"));
                celular.setResisteAgua(resultado.getString("resisteAgua"));
                celular.setCantidadSim(resultado.getString("cantidadSim"));
                lista.add(celular);
            }

            if (lista.isEmpty()) {
                throw new SQLException("No se encontraron celulares con sistema operativo: " + sistemaOperativo);
            }

            return lista.toArray(new Celular[0]);

        } catch (SQLException e) {
            throw new SQLException("Error al buscar por sistema operativo: " + e.getMessage());
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

    public static Celular[] buscarPorOperador(String operador) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos baseDatos = new ConexionBaseDatos();
        PreparedStatement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            baseDatos.conectar();
            String sql = "SELECT * FROM celulares WHERE operador LIKE ?";
            sentenciaSQL = baseDatos.crearSentencia(sql);

            sentenciaSQL.setString(1, "%" + operador + "%");

            resultado = baseDatos.consultar(sentenciaSQL);

            List<Celular> lista = new ArrayList<>();
            while (resultado.next()) {
                Celular celular = new Celular();
                celular.setId(resultado.getString("id"));
                celular.setMarca(resultado.getString("marca"));
                celular.setImei(resultado.getString("imei"));
                celular.setPulgadas(resultado.getString("pulgadas"));
                celular.setMegapixeles(resultado.getString("megapixeles"));
                celular.setRam(resultado.getString("ram"));
                celular.setAlmacenamientoPrincipal(resultado.getString("almacenamientoPrincipal"));
                celular.setAlmacenamientoSecundario(resultado.getString("almacenamientoSecundario"));
                celular.setSistemaOperativo(resultado.getString("sistemaOperativo"));
                celular.setOperador(resultado.getString("operador"));
                celular.setTecnologiaBanda(resultado.getString("tecnologiaBanda"));
                celular.setWifi(resultado.getString("wifi"));
                celular.setBluetooth(resultado.getString("bluetooth"));
                celular.setCamaras(resultado.getString("camaras"));
                celular.setMarcaCpu(resultado.getString("marcaCpu"));
                celular.setVelocidadCpu(resultado.getString("velocidadCpu"));
                celular.setNfc(resultado.getString("nfc"));
                celular.setHuella(resultado.getString("huella"));
                celular.setIr(resultado.getString("ir"));
                celular.setResisteAgua(resultado.getString("resisteAgua"));
                celular.setCantidadSim(resultado.getString("cantidadSim"));
                lista.add(celular);
            }

            if (lista.isEmpty()) {
                throw new SQLException("No se encontraron celulares con operador: " + operador);
            }

            return lista.toArray(new Celular[0]);

        } catch (SQLException e) {
            throw new SQLException("Error al buscar por operador: " + e.getMessage());
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
