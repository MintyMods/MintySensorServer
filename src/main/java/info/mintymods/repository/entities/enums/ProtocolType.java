package info.mintymods.repository.entities.enums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "minty_protocol_type")
public enum ProtocolType {
	HTTP("http://", "fal fa-user-times"), HTTPS("https://", "fal fa-user-shield");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_protocol_type_gen")
	@SequenceGenerator(name = "minty_protocol_type_gen", sequenceName = "MINTY_PROTOCOL_TYPE_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String desc;
	private String icon;

	ProtocolType(String desc, String icon) {
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
