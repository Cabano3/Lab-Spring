package ec.com.bano.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

//poniendo la etiqueta Data lo que haremos 
//es crear get set y demas metodos como tostring
//y constructor
@Data
@Entity
@Table(name="personas")
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personas;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
