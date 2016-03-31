package momentous.resto.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.activejpa.entity.Model;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractEntity extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}