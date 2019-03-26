package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Roles extends BaseDomain {

    @Column(name = "name_e")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
