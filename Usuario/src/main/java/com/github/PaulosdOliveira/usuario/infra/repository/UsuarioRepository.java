package com.github.PaulosdOliveira.usuario.infra.repository;

import com.github.PaulosdOliveira.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Usuario findByEmail(String email);

    @Query("Select u.enderecoEntrega from Usuario u where id = :id")
    String getEnderecoEntrega(@Param("id") Long id);
}
