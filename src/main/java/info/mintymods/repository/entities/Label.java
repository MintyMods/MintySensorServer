package info.mintymods.repository.entities;

import javax.persistence.Table;

import info.mintymods.msm.MsmSensorType;
import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.repository.entities.enums.ViewType;

@Table(name = "minty_label")
public class Label {

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

	public Label(MsmSensorType type) {
		name = type.getName();
		desc = type.getDesc();
		icon = type.getIcon();
	}

	public Label(ProviderType type) {
		name = type.getDesc();
		desc = type.getProtocol().getDesc() + type.getUrl();
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

	public Label(String name, String desc, String icon) {
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		desc = description;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setName(String name) {
		this.name = name;
	}
}
