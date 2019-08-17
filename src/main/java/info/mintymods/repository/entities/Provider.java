package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import info.mintymods.repository.entities.enums.ProviderType;

@Audited
@Entity
@Table(name = "minty_provider")
public class Provider {

	public static final String ICON = "fab fa-cloudscale";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_provider_gen")
	@SequenceGenerator(name = "minty_provider_gen", sequenceName = "MINTY_PROVIDER_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private ProviderType type;
	private String name;
	private String desc;

	public Provider() {
	}

	public Provider(Long id, ProviderType type) {
		this.id = id;
		this.type = type;
	}

	public ProviderType getType() {
		return type;
	}

	public void setType(ProviderType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
