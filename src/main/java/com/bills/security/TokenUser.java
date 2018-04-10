package com.bills.security;

import com.bills.entidades.Usuario;
import org.springframework.security.core.authority.AuthorityUtils;

public class TokenUser extends org.springframework.security.core.userdetails.User {

    private Usuario user;

    public TokenUser(Usuario user) {
        super(user.getUserId(), user.getClave(), AuthorityUtils.createAuthorityList("ADMIN"));
        this.user = user;
    }

    public Usuario getUsuario() {
        return user;
    }

}
