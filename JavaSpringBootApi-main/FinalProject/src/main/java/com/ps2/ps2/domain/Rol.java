package com.ps2.ps2.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable{
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Mapeo de ID autoincrementable en la base de datos
    @Column(name="idUsuario")
    private Long idRol;
    
    @NotEmpty
    private String nombre;
    
    
}
