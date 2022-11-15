package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG178_SECUENCIA")
public class Tbasg178Secuencia {

	@Id
	@Column(name = "ENTITY_NAME")
	private Long entityName;

	@NotNull
	@Column(name = "NEXT_ID")
	private Integer nextId;

	public Long getEntityName() {
		return this.entityName;
	}

	public void setEntityName(Long entityName) {
		this.entityName = entityName;
	}

	public Integer getNextId() {
		return this.nextId;
	}

	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}

}