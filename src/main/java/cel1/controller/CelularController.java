package cel1.controller;

import cel1.entity.Celular;
import cel1.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/celulares")
public class CelularController {

    private final CelularService celularService;

    @Autowired
    public CelularController(CelularService celularService) {
        this.celularService = celularService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("celulares", celularService.obtenerTodos());
        return "celular/list";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("celular", new Celular());
        model.addAttribute("accion", "nuevo");
        return "celular/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("celular") Celular celular, RedirectAttributes redirectAttributes) {
        celularService.guardar(celular);
        redirectAttributes.addFlashAttribute("mensaje", "Celular guardado exitosamente");
        return "redirect:/celulares";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Celular> celularOpt = celularService.obtenerPorId(id);
        if (celularOpt.isPresent()) {
            model.addAttribute("celular", celularOpt.get());
            model.addAttribute("accion", "editar");
            return "celular/form";
        }
        redirectAttributes.addFlashAttribute("error", "Celular no encontrado");
        return "redirect:/celulares";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        try {
            celularService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Celular eliminado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar celular: " + e.getMessage());
        }
        return "redirect:/celulares";
    }

    @GetMapping("/reportes")
    public String reportesForm() {
        return "celular/reportes";
    }

    @GetMapping("/reporte/marca")
    public String reportePorMarca(@RequestParam("marca") String marca, Model model) {
        List<Celular> resultados = celularService.buscarPorMarca(marca);
        model.addAttribute("celulares", resultados);
        model.addAttribute("tituloReporte", "Reporte de Celulares por Marca: " + marca);
        return "celular/list";
    }

    @GetMapping("/reporte/sistema")
    public String reportePorSistema(@RequestParam("sistemaOperativo") String sistemaOperativo, Model model) {
        List<Celular> resultados = celularService.buscarPorSistemaOperativo(sistemaOperativo);
        model.addAttribute("celulares", resultados);
        model.addAttribute("tituloReporte", "Reporte de Celulares por Sistema Operativo: " + sistemaOperativo);
        return "celular/list";
    }

    @GetMapping("/reporte/operador")
    public String reportePorOperador(@RequestParam("operador") String operador, Model model) {
        List<Celular> resultados = celularService.buscarPorOperador(operador);
        model.addAttribute("celulares", resultados);
        model.addAttribute("tituloReporte", "Reporte de Celulares por Operador: " + operador);
        return "celular/list";
    }
}
