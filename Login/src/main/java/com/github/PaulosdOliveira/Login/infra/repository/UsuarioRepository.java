package com.github.PaulosdOliveira.Login.infra.repository;

import com.github.PaulosdOliveira.Login.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Boolean existsByEmail(String email);
    Usuario findByEmail(String email);

}
