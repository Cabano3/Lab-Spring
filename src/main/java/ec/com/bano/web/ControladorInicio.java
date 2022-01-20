
package ec.com.bano.web;

import ec.com.bano.domain.Persona;
import ec.com.bano.services.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//slf4j funciona para trabajar con los log
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService ;
    
    @GetMapping("/")
    public String GetAllPersons(Model model){
        
        var personas = personaService.listarPersonas();
        log.info("ejecutando el servidor SPRING MVC");
        model.addAttribute("personas",personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    } 
    
    @GetMapping("/editar/{id_personas}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id_personas}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
