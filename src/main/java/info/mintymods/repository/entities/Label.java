package info.mintymods.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import info.mintymods.msm.MsmSensorType;
import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.repository.entities.enums.ViewType;

@Entity
@Table(name = "labels")
public class Label extends Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String desc;
	private String icon;

	public Label() {
	}

	public Label(HostType type) {
		name = type.getName();
		desc = type.getDesc();
		icon = type.getIcon();
	}

	public Label(Long id, String name, String desc, String icon) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.icon = icon;
	}

	public Label(MsmSensorType type) {
		name = type.getName();
		desc = type.getDesc();
		icon = type.getIcon();
	}

	public Label(ProviderType type) {
		name = type.getDesc();
		desc = type.getProtocol() + type.getUrl();
		icon = type.getIcon();
	}

	public Label(String name, MsmSensorType type) {
		this.name = name;
		desc = type.getDesc();
		icon = type.getIcon();
	}

	public Label(String desc, String icon) {
		this.desc = desc;
		this.icon = icon;
	}

	public Label(ViewType type) {
		name = type.getName();
		desc = type.getDesc();
		icon = type.getIcon();
	}

	public String getDescription() {
		return desc;
	}

	public String getIcon() {
		return icon;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		desc = description;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
