package com.ps2.ps2.dao;

import com.ps2.ps2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
