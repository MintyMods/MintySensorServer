package info.mintymods.repository.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minty_module_dependency")
public class ModuleDependency extends Audit {

	private final static String ICON = "fab fa-git-alt";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Label dependency;

	// private List<String> script;
	// private List<String> css;
	public ModuleDependency() {
	}

	public ModuleDependency(Long id, Label dependency, List<String> script, List<String> css) {
		this.id = id;
		this.dependency = dependency;
		// this.script = script;
		// this.css = css;
	}

	public String getIcon() {
		return ICON;
	}

	public Label getDependency() {
		return dependency;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setDependency(Label dependency) {
		this.dependency = dependency;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
