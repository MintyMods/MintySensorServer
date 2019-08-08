package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minty_module")
public class Module extends BaseEntity {

	private final static String ICON = "fal fa-solar-panel";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private ModuleDependency[] dependencies;

	public Module() {
	}

	public Module(Label label, ModuleDependency[] dependencies) {
		this.label = label;
		this.dependencies = dependencies;
	}

	public String getIcon() {
		return ICON;
	}

	public ModuleDependency[] getDependencies() {
		return dependencies;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Label getLabel() {
		return label;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	public void setDependencies(ModuleDependency[] dependencies) {
		this.dependencies = dependencies;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setLabel(Label label) {
		this.label = label;
	}
}
