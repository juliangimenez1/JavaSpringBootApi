package com.ps2.ps2.dao;

import com.ps2.ps2.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface IPersonaDao extends CrudRepository<Persona, Long>{
    
}
