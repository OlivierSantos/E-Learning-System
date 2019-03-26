package mum.ea.security;

import org.springframework.security.core.GrantedAuthority;

public class EaGrantedAuthority implements GrantedAuthority {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return name;
    }
}
