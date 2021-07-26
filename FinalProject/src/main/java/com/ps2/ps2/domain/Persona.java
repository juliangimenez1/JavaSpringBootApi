package com.ps2.ps2.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
//import javax.validation.constraints.NotEmpty

@Data //get y set para atributos
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    
    //Con esto mapeamos a la base de datos la persona
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona")
    private Long idPersona;
    
    //El NotEmpty es para realizar las validaciones
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    
    private String telefono;
    
    @NotNull
    private Double saldo;
    
    
}
