package cel1.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import cel1.modelo.CRUDUsuario;
import cel1.modelo.Usuario;

@WebServlet(name = "ServletUsuario", urlPatterns = {"/usuario"})
public class ServletUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String acción = request.getParameter("acción");

        try {
            if (acción != null) {
                switch (acción) {
                    case "agregar":
                        Usuario usuario = new Usuario();
                        usuario.setId(request.getParameter("id"));
                        usuario.setClave(request.getParameter("clave"));
                        usuario.setNombre(request.getParameter("nombre"));
                        usuario.setRol(request.getParameter("rol"));
                        usuario.setEmail(request.getParameter("email"));

                        CRUDUsuario.agregarUsuario(usuario);
                        response.sendRedirect("usuario/agregar.jsp?mensaje=Usuario agregado exitosamente");
                        break;

                    case "modificar":
                        Usuario usuarioMod = new Usuario();
                        usuarioMod.setId(request.getParameter("id"));
                        usuarioMod.setClave(request.getParameter("clave"));
                        usuarioMod.setNombre(request.getParameter("nombre"));
                        usuarioMod.setRol(request.getParameter("rol"));
                        usuarioMod.setEmail(request.getParameter("email"));

                        CRUDUsuario.modificarUsuario(usuarioMod);
                        response.sendRedirect("usuario/modificar.jsp?mensaje=Usuario modificado exitosamente");
                        break;

                    case "eliminar":
                        String idEliminar = request.getParameter("id");
                        CRUDUsuario.eliminarUsuario(idEliminar);
                        response.sendRedirect("usuario/eliminar.jsp?mensaje=Usuario eliminado exitosamente");
                        break;

                    case "buscar":
                        String idBuscar = request.getParameter("id");
                        Usuario usuarioEncontrado = CRUDUsuario.consultarUsuario(idBuscar);

                        HttpSession session = request.getSession();
                        session.setAttribute("usuario.buscar", usuarioEncontrado);

                        String redir = request.getParameter("redir");
                        if (redir != null && redir.equals("modificar")) {
                            response.sendRedirect("usuario/modificar.jsp");
                        } else if (redir != null && redir.equals("eliminar")) {
                            response.sendRedirect("usuario/eliminar.jsp");
                        } else {
                            response.sendRedirect("usuario/buscar.jsp");
                        }
                        break;

                    case "listartodo":
                        Usuario[] listado = CRUDUsuario.listarTodosLosUsuarios();

                        HttpSession sessionListar = request.getSession();
                        sessionListar.setAttribute("usuario.listar", listado);

                        response.sendRedirect("usuario/listar.jsp");
                        break;

                    case "login":
                        String idLogin = request.getParameter("id");
                        String claveLogin = request.getParameter("clave");

                        Usuario usuarioLogin = CRUDUsuario.iniciarSesion(idLogin, claveLogin);

                        HttpSession sessionLogin = request.getSession();
                        sessionLogin.setAttribute("usuario", usuarioLogin);

                        response.sendRedirect("index.jsp");
                        break;

                    case "logout":
                        HttpSession sessionLogout = request.getSession();
                        sessionLogout.invalidate();
                        response.sendRedirect("login.jsp");
                        break;

                    case "buscarRol":
                        String rol = request.getParameter("rol");
                        Usuario[] usuariosPorRol = CRUDUsuario.buscarPorRol(rol);

                        HttpSession sessionRol = request.getSession();
                        sessionRol.setAttribute("usuario.listar", usuariosPorRol);

                        response.sendRedirect("usuario/listar.jsp?reporte=rol&valor=" + rol);
                        break;

                    case "buscarNombre":
                        String nombre = request.getParameter("nombre");
                        Usuario[] usuariosPorNombre = CRUDUsuario.buscarPorNombre(nombre);

                        HttpSession sessionNombre = request.getSession();
                        sessionNombre.setAttribute("usuario.listar", usuariosPorNombre);

                        response.sendRedirect("usuario/listar.jsp?reporte=nombre&valor=" + nombre);
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
        return "Servlet para gestión de usuarios";
    }
}
