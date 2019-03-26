package mum.ea.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import mum.ea.domain.abstracts.BaseDomain;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Test extends BaseDomain {

	@NotEmpty(message = "{NotEmpty}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
