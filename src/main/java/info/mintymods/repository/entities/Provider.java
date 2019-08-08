package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import info.mintymods.repository.entities.enums.ProviderType;

@Entity
@Table(name = "minty_provider")
public class Provider extends BaseEntity {

	private final static String ICON = "fab fa-cloudscale";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private ProviderType type;

	public Provider() {
	}

	public Provider(Long id, ProviderType type, Label label) {
		this.id = id;
		this.type = type;
		this.label = label;
	}

	public String getIcon() {
		return ICON;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Label getLabel() {
		return label;
	}

	public ProviderType getType() {
		return type;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setLabel(Label label) {
		this.label = label;
	}

	public void setType(ProviderType type) {
		this.type = type;
	}
}
