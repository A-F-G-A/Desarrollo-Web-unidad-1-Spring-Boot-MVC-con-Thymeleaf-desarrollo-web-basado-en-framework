package cel1.controladores;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import cel1.modelo.CRUDUsuario;
import cel1.modelo.Usuario;

@WebServlet(name = "ServletRecuperarClave", urlPatterns = {"/recuperar"})
public class ServletRecuperarClave extends HttpServlet {

    private String SMTP_HOST;
    private String SMTP_PORT;
    private String SMTP_USER;
    private String SMTP_PASSWORD;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        cargarConfiguracion();

        String acción = request.getParameter("acción");

        try {
            if (acción != null && acción.equals("enviar")) {
                String id = request.getParameter("id");

                Usuario usuario = CRUDUsuario.consultarUsuario(id);

                if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
                    response.sendRedirect("mensaje.jsp?mensaje=El usuario no tiene correo electrónico registrado");
                    return;
                }

                enviarCorreoRecuperacion(usuario.getEmail(), usuario.getClave());

                response.sendRedirect("mensaje.jsp?mensaje=Se ha enviado un correo con su clave");
            } else {
                response.sendRedirect("mensaje.jsp?mensaje=No se especificó acción");
            }
        } catch (Exception e) {
            response.sendRedirect("mensaje.jsp?mensaje=" + e.getMessage());
        }
    }

    private void cargarConfiguracion() {
        Properties configuracion = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                configuracion.load(input);
                this.SMTP_HOST = configuracion.getProperty("mail.smtp.host", "smtp.gmail.com");
                this.SMTP_PORT = configuracion.getProperty("mail.smtp.port", "587");
                this.SMTP_USER = configuracion.getProperty("mail.smtp.user", "tu_correo@gmail.com");
                this.SMTP_PASSWORD = configuracion.getProperty("mail.smtp.password", "tu_app_password");
            } else {
                // Valores por defecto
                this.SMTP_HOST = "smtp.gmail.com";
                this.SMTP_PORT = "587";
                this.SMTP_USER = "tu_correo@gmail.com";
                this.SMTP_PASSWORD = "tu_app_password";
            }
        } catch (IOException ex) {
            // Valores por defecto en caso de error
            this.SMTP_HOST = "smtp.gmail.com";
            this.SMTP_PORT = "587";
            this.SMTP_USER = "tu_correo@gmail.com";
            this.SMTP_PASSWORD = "tu_app_password";
        }
    }

    private void enviarCorreoRecuperacion(String destinatario, String clave) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, null);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(SMTP_USER));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject("Recuperación de Clave");
        message.setText("Su clave es: " + clave);

        Transport transport = session.getTransport("smtp");
        transport.connect(SMTP_HOST, SMTP_USER, SMTP_PASSWORD);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
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
        return "Servlet para recuperación de clave";
    }
}
