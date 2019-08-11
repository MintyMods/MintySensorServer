package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import info.mintymods.repository.entities.enums.ProviderType;

@Audited
@Entity
@Table(name = "minty_provider")
public class Provider extends BaseEntity {

	private ProviderType type;

	public Provider() {
	}

	public Provider(Long recordId, ProviderType type, Label label) {
		this.setRecordId(recordId);
		this.type = type;
		this.label = label;
		icon = "fab fa-cloudscale";
	}

	public ProviderType getType() {
		return type;
	}

	public void setType(ProviderType type) {
		this.type = type;
	}
}
