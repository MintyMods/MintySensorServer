package info.mintymods.repository.entities;

// @Entity
// @Table(name = "minty_module_dependency")
public class ModuleDependency {

	public static final String ICON = "fab fa-git-alt";
	private String name;
	private String desc;

	// private List<String> script;
	// private List<String> css;
	public ModuleDependency() {
	}

	public ModuleDependency(Long recordId) {
		// this.script = script;
		// this.css = css;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
