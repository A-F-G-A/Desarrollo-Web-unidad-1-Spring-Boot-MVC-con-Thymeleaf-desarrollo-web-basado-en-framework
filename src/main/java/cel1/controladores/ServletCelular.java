package cel1.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import cel1.modelo.CRUDCelular;
import cel1.modelo.Celular;

@WebServlet(name = "ServletCelular", urlPatterns = {"/celular"})
public class ServletCelular extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String acción = request.getParameter("acción");

        try {
            if (acción != null) {
                switch (acción) {
                    case "agregar":
                        Celular celular = new Celular();
                        celular.setId(request.getParameter("id"));
                        celular.setMarca(request.getParameter("marca"));
                        celular.setImei(request.getParameter("imei"));
                        celular.setPulgadas(request.getParameter("pulgadas"));
                        celular.setMegapixeles(request.getParameter("megapixeles"));
                        celular.setRam(request.getParameter("ram"));
                        celular.setAlmacenamientoPrincipal(request.getParameter("almacenamientoPrincipal"));
                        celular.setAlmacenamientoSecundario(request.getParameter("almacenamientoSecundario"));
                        celular.setSistemaOperativo(request.getParameter("sistemaOperativo"));
                        celular.setOperador(request.getParameter("operador"));
                        celular.setTecnologiaBanda(request.getParameter("tecnologiaBanda"));
                        celular.setWifi(request.getParameter("wifi"));
                        celular.setBluetooth(request.getParameter("bluetooth"));
                        celular.setCamaras(request.getParameter("camaras"));
                        celular.setMarcaCpu(request.getParameter("marcaCpu"));
                        celular.setVelocidadCpu(request.getParameter("velocidadCpu"));
                        celular.setNfc(request.getParameter("nfc"));
                        celular.setHuella(request.getParameter("huella"));
                        celular.setIr(request.getParameter("ir"));
                        celular.setResisteAgua(request.getParameter("resisteAgua"));
                        celular.setCantidadSim(request.getParameter("cantidadSim"));

                        CRUDCelular.agregarCelular(celular);
                        response.sendRedirect("celular/agregar.jsp?mensaje=Celular agregado exitosamente");
                        break;

                    case "modificar":
                        Celular celularMod = new Celular();
                        celularMod.setId(request.getParameter("id"));
                        celularMod.setMarca(request.getParameter("marca"));
                        celularMod.setImei(request.getParameter("imei"));
                        celularMod.setPulgadas(request.getParameter("pulgadas"));
                        celularMod.setMegapixeles(request.getParameter("megapixeles"));
                        celularMod.setRam(request.getParameter("ram"));
                        celularMod.setAlmacenamientoPrincipal(request.getParameter("almacenamientoPrincipal"));
                        celularMod.setAlmacenamientoSecundario(request.getParameter("almacenamientoSecundario"));
                        celularMod.setSistemaOperativo(request.getParameter("sistemaOperativo"));
                        celularMod.setOperador(request.getParameter("operador"));
                        celularMod.setTecnologiaBanda(request.getParameter("tecnologiaBanda"));
                        celularMod.setWifi(request.getParameter("wifi"));
                        celularMod.setBluetooth(request.getParameter("bluetooth"));
                        celularMod.setCamaras(request.getParameter("camaras"));
                        celularMod.setMarcaCpu(request.getParameter("marcaCpu"));
                        celularMod.setVelocidadCpu(request.getParameter("velocidadCpu"));
                        celularMod.setNfc(request.getParameter("nfc"));
                        celularMod.setHuella(request.getParameter("huella"));
                        celularMod.setIr(request.getParameter("ir"));
                        celularMod.setResisteAgua(request.getParameter("resisteAgua"));
                        celularMod.setCantidadSim(request.getParameter("cantidadSim"));

                        CRUDCelular.modificarCelular(celularMod);
                        response.sendRedirect("celular/modificar.jsp?mensaje=Celular modificado exitosamente");
                        break;

                    case "eliminar":
                        String idEliminar = request.getParameter("id");
                        CRUDCelular.eliminarCelular(idEliminar);
                        response.sendRedirect("celular/eliminar.jsp?mensaje=Celular eliminado exitosamente");
                        break;

                    case "buscar":
                        String idBuscar = request.getParameter("id");
                        Celular celularEncontrado = CRUDCelular.consultarCelular(idBuscar);

                        HttpSession session = request.getSession();
                        session.setAttribute("celular.buscar", celularEncontrado);

                        String redir = request.getParameter("redir");
                        if (redir != null && redir.equals("modificar")) {
                            response.sendRedirect("celular/modificar.jsp");
                        } else if (redir != null && redir.equals("eliminar")) {
                            response.sendRedirect("celular/eliminar.jsp");
                        } else {
                            response.sendRedirect("celular/buscar.jsp");
                        }
                        break;

                    case "listartodo":
                        Celular[] listado = CRUDCelular.listarTodosLosCelulares();

                        HttpSession sessionListar = request.getSession();
                        sessionListar.setAttribute("celular.listar", listado);

                        response.sendRedirect("celular/listar.jsp");
                        break;

                    case "buscarMarca":
                        String marca = request.getParameter("marca");
                        Celular[] celularesPorMarca = CRUDCelular.buscarPorMarca(marca);

                        HttpSession sessionMarca = request.getSession();
                        sessionMarca.setAttribute("celular.listar", celularesPorMarca);

                        response.sendRedirect("celular/listar.jsp?reporte=marca&valor=" + marca);
                        break;

                    case "buscarSistema":
                        String sistemaOperativo = request.getParameter("sistemaOperativo");
                        Celular[] celularesPorSistema = CRUDCelular.buscarPorSistemaOperativo(sistemaOperativo);

                        HttpSession sessionSistema = request.getSession();
                        sessionSistema.setAttribute("celular.listar", celularesPorSistema);

                        response.sendRedirect("celular/listar.jsp?reporte=sistema&valor=" + sistemaOperativo);
                        break;

                    case "buscarOperador":
                        String operador = request.getParameter("operador");
                        Celular[] celularesPorOperador = CRUDCelular.buscarPorOperador(operador);

                        HttpSession sessionOperador = request.getSession();
                        sessionOperador.setAttribute("celular.listar", celularesPorOperador);

                        response.sendRedirect("celular/listar.jsp?reporte=operador&valor=" + operador);
                        break;

                    default:
                        response.sendRedirect("mensaje.jsp?mensaje=Acción no reconocida");
                        break;
                }
            } else {
                response.sendRedirect("mensaje.jsp?mensaje=No se especificó acción");
            }
        } catch (Exception e) {
            response.sendRedirect("mensaje.jsp?mensaje=" + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para gestión de celulares";
    }
}
