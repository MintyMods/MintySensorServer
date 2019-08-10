package info.mintymods.repository.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_base_gen")
	@SequenceGenerator(name = "minty_base_gen", sequenceName = "MINTY_BASE_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	protected Long id;
	@OneToOne(cascade = {CascadeType.ALL})
	protected Label label;
	protected boolean active = true;
	protected String icon;

	public Long getId() {
		return id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (final JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
