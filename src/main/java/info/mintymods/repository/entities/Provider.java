package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import info.mintymods.repository.entities.enums.ProviderType;

@Entity
@Table(name = "minty_provider")
public class Provider extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_provider_gen")
	@SequenceGenerator(name = "minty_provider_gen", sequenceName = "MINTY_PROVIDER_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private ProviderType type;

	public Provider() {
	}

	public Provider(Long id, ProviderType type, Label label) {
		this.id = id;
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
