package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

// @Entity
// @Table(name = "minty_module_dependency")
public class ModuleDependency extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_module_dependency_gen")
	@SequenceGenerator(name = "minty_module_dependency_gen", sequenceName = "MINTY_MODULE_DEPENDENCY_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private Label dependency;

	// private List<String> script;
	// private List<String> css;
	public ModuleDependency() {
	}

	public ModuleDependency(Long id, Label dependency) {
		this.id = id;
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
