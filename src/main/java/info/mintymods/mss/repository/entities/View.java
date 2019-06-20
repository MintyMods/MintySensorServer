package info.mintymods.mss.repository.entities;

import java.util.List;

public class View {

	private Label label;
	private boolean active;
	private List<Module> modules;

	public View() {
		this.active = true;
	}

	public View(Label label, List<Module> modules) {
		super();
		this.label = label;
		this.modules = modules;
		this.active = true;
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

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

}
