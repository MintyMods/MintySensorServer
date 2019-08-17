package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "minty_module")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_module_gen")
	@SequenceGenerator(name = "minty_module_gen", sequenceName = "MINTY_MODULE_SEQ")
	@Column(name = "recordId", updatable = false, nullable = false)
	private Long recordId;
	public static final String ICON = "fal fa-solar-panel";
	private ModuleDependency[] dependencies;
	private String name;
	private String desc;

	public Module() {
	}

	public Module(ModuleDependency[] dependencies) {
		this.dependencies = dependencies;
	}

	public ModuleDependency[] getDependencies() {
		return dependencies;
	}

	public void setDependencies(ModuleDependency[] dependencies) {
		this.dependencies = dependencies;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
