package info.mintymods.repository.entities.enums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "minty_host_type")
public enum HostType {
	LOCALHOST("Local Host", "fal fa-home"), REMOTEHOST("Remote Host", "fal fa-project-diagram");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_host_type_gen")
	@SequenceGenerator(name = "minty_host_type_gen", sequenceName = "MINTY_HOST_TYPE_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String desc;
	private String icon;

	HostType(String desc, String icon) {
		setDesc(desc);
		setIcon(icon);
	}

	public String getDesc() {
		return desc;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return toString();
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
