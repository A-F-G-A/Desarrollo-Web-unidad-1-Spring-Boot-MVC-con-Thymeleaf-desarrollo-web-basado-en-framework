package cel1.controller;

import cel1.entity.Usuario;
import cel1.service.CorreoService;
import cel1.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;
    private final CorreoService correoService;

    @Autowired
    public AuthController(UsuarioService usuarioService, CorreoService correoService) {
        this.usuarioService = usuarioService;
        this.correoService = correoService;
    }

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("usuario", usuario);
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "mensaje", required = false) String mensaje,
                            Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        if (mensaje != null) {
            model.addAttribute("mensaje", mensaje);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam("id") String id,
                               @RequestParam("clave") String clave,
                               HttpSession session,
                               Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.autenticar(id, clave);
        if (usuarioOpt.isPresent()) {
            session.setAttribute("usuario", usuarioOpt.get());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Credenciales incorrectas. ID o clave invalidos.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?mensaje=Sesion cerrada exitosamente";
    }

    @GetMapping("/recuperar")
    public String recuperarForm() {
        return "recuperar";
    }

    @PostMapping("/recuperar")
    public String recuperarProcess(@RequestParam("id") String id, Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerPorId(id);
        if (usuarioOpt.isPresent()) {
            Usuario u = usuarioOpt.get();
            if (u.getEmail() != null && !u.getEmail().trim().isEmpty()) {
                try {
                    correoService.enviarCorreoRecuperacion(u.getEmail(), u.getClave());
                    model.addAttribute("mensaje", "Se ha enviado un correo con la clave a " + u.getEmail());
                } catch (Exception e) {
                    model.addAttribute("error", "Error al enviar correo: " + e.getMessage());
                }
            } else {
                model.addAttribute("error", "El usuario no tiene correo electronico registrado.");
            }
        } else {
            model.addAttribute("error", "No existe usuario con el ID especificado.");
        }
        return "recuperar";
    }
}
