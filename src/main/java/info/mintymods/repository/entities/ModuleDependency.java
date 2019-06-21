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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final ModuleDependency other = (ModuleDependency) obj;
		if (active != other.active) { return false; }
		if (css == null) {
			if (other.css != null) { return false; }
		} else
			if (!css.equals(other.css)) { return false; }
		if (dependency == null) {
			if (other.dependency != null) { return false; }
		} else
			if (!dependency.equals(other.dependency)) { return false; }
		if (id == null) {
			if (other.id != null) { return false; }
		} else
			if (!id.equals(other.id)) { return false; }
		if (script == null) {
			if (other.script != null) { return false; }
		} else
			if (!script.equals(other.script)) { return false; }
		return true;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (active ? 1231 : 1237);
		result = (prime * result) + ((css == null) ? 0 : css.hashCode());
		result = (prime * result) + ((dependency == null) ? 0 : dependency.hashCode());
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		result = (prime * result) + ((script == null) ? 0 : script.hashCode());
		return result;
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
