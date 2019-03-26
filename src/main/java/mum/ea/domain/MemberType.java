package mum.ea.domain;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.Entity;

@Entity
public class MemberType extends BaseDomain {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
