package mum.ea.domain.abstracts;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SoftDeleteDomain extends BaseDomain {

	private boolean deleted;

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
