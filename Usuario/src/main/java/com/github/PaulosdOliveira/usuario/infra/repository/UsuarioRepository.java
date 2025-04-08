package com.github.PaulosdOliveira.usuario.infra.repository;

import com.github.PaulosdOliveira.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);
    Usuario findByEmail(String email);

}
