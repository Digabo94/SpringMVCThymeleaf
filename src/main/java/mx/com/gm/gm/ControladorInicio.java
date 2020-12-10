package mx.com.gm.gm;

//Se agrega la siguiente anotacion para que Spring pueda reconocer esta clase de java
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.gm.domain.Persona;
//Vamos a usar un controlador Spring MVC

@Controller
//La siguiente anotacion es para un login
@Slf4j
public class ControladorInicio {
    
    //Con la anotacion Value, podemos acceder a las variables de application.properties y asi inyectara el valor 
    //de applicacion.properties a la variable saludo
    @Value("${index.saludo}")
    private String saludo;

    //Para indicarle al navegador que este metodo es el que se debe de ejecutar hay que mapearlo de la siguiente manera
    @GetMapping("/")
    //Con el objeto Model vamos a agregar la informacion que se quiere compartir con la vista
    public String inicio(Model model) {
        String mensaje = "Mensaje con thymeleaf";
        
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperes@mail.com");
        persona.setTelefono("1234512");
        
        
        Persona persona2 = new Persona();
        persona2.setNombre("Karla");
        persona2.setApellido("GOmez");
        persona2.setEmail("kagomez@mail.com");
        persona2.setTelefono("5432154");
        
//        List<Persona> personas = new ArrayList<>();
//        personas.add(persona);
//        personas.add(persona2);

        //Otra forma de crear la lista
//       List<Persona> personas = Arrays.asList(persona, persona2);
         List<Persona> personas = new ArrayList();
        
        //Con el siguiente comando se despliega en consola el mensaje que contiene
        log.info("Ejecutando el controlador Spring MVC");
        
        //Aqui, con el metodo addAtribute, estamos dando la llave string: "mensaje" y un valor de la variable mensaje
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
//        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        
        //En este caso se va a mandar a desplegar un archivo html llamado index, el cual esta en la ruta:
        //Other Sources -> src/main/resources -> templates -> index.html
        return "index";
    }
}
