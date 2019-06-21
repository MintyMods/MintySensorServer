package info.mintymods.repository.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ModuleDependency extends Audit {

	private final static String ICON = "fab fa-git-alt";

	public static String getIcon() {
		return ICON;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean active = true;
	private Label dependency;
	private List<String> script;
	private List<String> css;

	public ModuleDependency() {
	}

	public ModuleDependency(Long id, Label dependency, List<String> script, List<String> css) {
		this.id = id;
		this.dependency = dependency;
		this.script = script;
		this.css = css;
	}

	public List<String> getCss() {
		return css;
	}

	public Label getDependency() {
		return dependency;
	}

	public Long getId() {
		return id;
	}

	public List<String> getScript() {
		return script;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setCss(List<String> css) {
		this.css = css;
	}

	public void setDependency(Label dependency) {
		this.dependency = dependency;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setScript(List<String> script) {
		this.script = script;
	}
}
