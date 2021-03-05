package pl.bendyk.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class CurrentUser extends User {
    private final pl.bendyk.model.auth.User user;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                       pl.bendyk.model.auth.User user) {
        super(username, password, authorities);
        this.user = user;
    }


    public pl.bendyk.model.auth.User getUser() {
        return user;
    }
}