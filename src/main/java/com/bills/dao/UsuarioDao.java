package com.bills.dao;

import com.bills.entidades.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByUserId(String userId);

    Optional<Usuario> findOneByUserIdAndPassword(String userId, String password);
}
