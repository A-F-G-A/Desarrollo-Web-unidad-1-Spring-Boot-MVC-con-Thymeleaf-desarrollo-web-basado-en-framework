package cel1.controller;

import cel1.entity.Usuario;
import cel1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodos());
        return "usuario/list";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("accion", "nuevo");
        return "usuario/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttributes) {
        usuarioService.guardar(usuario);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario guardado exitosamente");
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerPorId(id);
        if (usuarioOpt.isPresent()) {
            model.addAttribute("usuario", usuarioOpt.get());
            model.addAttribute("accion", "editar");
            return "usuario/form";
        }
        redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Usuario eliminado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar usuario: " + e.getMessage());
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/reportes")
    public String reportesForm() {
        return "usuario/reportes";
    }

    @GetMapping("/reporte/rol")
    public String reportePorRol(@RequestParam("rol") String rol, Model model) {
        List<Usuario> resultados = usuarioService.buscarPorRol(rol);
        model.addAttribute("usuarios", resultados);
        model.addAttribute("tituloReporte", "Reporte de Usuarios por Rol: " + rol);
        return "usuario/list";
    }

    @GetMapping("/reporte/nombre")
    public String reportePorNombre(@RequestParam("nombre") String nombre, Model model) {
        List<Usuario> resultados = usuarioService.buscarPorNombre(nombre);
        model.addAttribute("usuarios", resultados);
        model.addAttribute("tituloReporte", "Reporte de Usuarios por Nombre conteniendo: " + nombre);
        return "usuario/list";
    }
}
