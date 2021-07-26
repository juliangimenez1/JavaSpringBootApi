package com.ps2.ps2.servicio;

import com.ps2.ps2.domain.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> listarPersonas();
    public void guardar(Persona p);
    public void eliminar(Persona p);
    public Persona encontrarPersona(Persona p);
    
    
}
