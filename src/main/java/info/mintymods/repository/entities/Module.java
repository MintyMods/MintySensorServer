package info.mintymods.repository.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Module extends Audit {

	private final static String ICON = "fas fa-solar-panel";

	public static String getIcon() {
		return ICON;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean active = true;
	private Label label;
	private ModuleDependency[] dependencies;

	public Module() {
	}

	public Module(Label label, ModuleDependency[] dependencies) {
		this.label = label;
		this.dependencies = dependencies;
	}

	public ModuleDependency[] getDependencies() {
		return dependencies;
	}

	public Long getId() {
		return id;
	}

	public Label getLabel() {
		return label;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setDependencies(ModuleDependency[] dependencies) {
		this.dependencies = dependencies;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
}
