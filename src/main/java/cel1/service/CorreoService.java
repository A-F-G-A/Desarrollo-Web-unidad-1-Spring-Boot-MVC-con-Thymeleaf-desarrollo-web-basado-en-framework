package cel1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username:noreply@ejemplo.com}")
    private String remitente;

    @Autowired(required = false)
    public CorreoService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCorreoRecuperacion(String destinatario, String clave) {
        if (mailSender == null) {
            System.out.println("JavaMailSender no está disponible/configurado.");
            return;
        }
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom(remitente);
        mensaje.setTo(destinatario);
        mensaje.setSubject("Recuperación de Clave - Sistema de Celulares");
        mensaje.setText("Hola,\n\nSu clave de acceso registrada en el sistema es: " + clave + "\n\nSaludos.");

        mailSender.send(mensaje);
    }
}
