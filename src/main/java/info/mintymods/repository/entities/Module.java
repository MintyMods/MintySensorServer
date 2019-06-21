package info.mintymods.repository.entities;

public class Module {

	private Label label;
	private ModuleDependency[] dependencies;
	private boolean active;

	public Module() { }

	public Module(Label label, ModuleDependency[] dependencies, boolean active) {
		this.label = label;
		this.dependencies = dependencies;
		this.active = active;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public ModuleDependency[] getDependencies() {
		return dependencies;
	}

	public void setDependencies(ModuleDependency[] dependencies) {
		this.dependencies = dependencies;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
