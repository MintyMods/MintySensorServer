package info.mintymods.repository.entities;

// @Entity
// @Table(name = "minty_module_dependency")
public class ModuleDependency extends BaseEntity {

	private Label dependency;

	// private List<String> script;
	// private List<String> css;
	public ModuleDependency() {
	}

	public ModuleDependency(Long recordId, Label dependency) {
		this.setRecordId(recordId);
		this.dependency = dependency;
		icon = "fab fa-git-alt";
		// this.script = script;
		// this.css = css;
	}

	public Label getDependency() {
		return dependency;
	}

	public void setDependency(Label dependency) {
		this.dependency = dependency;
	}
}
