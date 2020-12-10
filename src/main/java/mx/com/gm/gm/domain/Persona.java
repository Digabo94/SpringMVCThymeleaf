package mx.com.gm.gm.domain;

import lombok.Data;

//Teniendo la libreria de Lombok y con la anotacion de Data, podemos agregar automaticamente los metodos get
//set, toString, hashCode e equals, pero solo es visible en la pestania Navigator. Asi convertimos una clase en Java Bean
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
