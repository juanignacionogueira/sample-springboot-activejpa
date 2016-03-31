package momentous.resto.api.dto;

import java.io.Serializable;

public abstract class EntityDto implements Serializable {

	private static final long serialVersionUID = 732243082068409196L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long oid) {
		this.id = oid;
	}

}
