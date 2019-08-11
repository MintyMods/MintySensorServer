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
public class Module extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_module_gen")
	@SequenceGenerator(name = "minty_module_gen", sequenceName = "MINTY_MODULE_SEQ")
	@Column(name = "recordId", updatable = false, nullable = false)
	private Long recordId;
	private ModuleDependency[] dependencies;

	public Module() {
	}

	public Module(Label label, ModuleDependency[] dependencies) {
		this.label = label;
		this.dependencies = dependencies;
		icon = "fal fa-solar-panel";
	}

	public ModuleDependency[] getDependencies() {
		return dependencies;
	}

	public void setDependencies(ModuleDependency[] dependencies) {
		this.dependencies = dependencies;
	}
}
