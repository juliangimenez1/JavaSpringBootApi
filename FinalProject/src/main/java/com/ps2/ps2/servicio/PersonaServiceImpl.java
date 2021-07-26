package com.ps2.ps2.servicio;

import com.ps2.ps2.dao.IPersonaDao;
import com.ps2.ps2.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements IPersonaService{
    
    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona p) {
        personaDao.save(p);
    }

    @Override
    @Transactional
    public void eliminar(Persona p) {
        personaDao.delete(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona p) {
        return personaDao.findById(p.getIdPersona()).orElse(null);
    }
    
}
