package info.mintymods.mss.repository.entities;

import java.util.List;

public class ModuleDependency {

	private String id;
	private Label dependency;
	private List<String> script;
	private List<String> css;

	public ModuleDependency() {
	}

	public ModuleDependency(String id, Label dependency, List<String> script, List<String> css) {
		this.id = id;
		this.dependency = dependency;
		this.script = script;
		this.css = css;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Label getDependency() {
		return dependency;
	}

	public void setDependency(Label dependency) {
		this.dependency = dependency;
	}

	public List<String> getScript() {
		return script;
	}

	public void setScript(List<String> script) {
		this.script = script;
	}

	public List<String> getCss() {
		return css;
	}

	public void setCss(List<String> css) {
		this.css = css;
	}

}
