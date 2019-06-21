package info.mintymods.repository.entities;

import info.mintymods.msm.MsmSensorType;
import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.repository.entities.enums.ViewType;

public class Label {

	private String label;
	private String desc;
	private String icon;

	public Label() { }

	public Label(String label, String icon) {
		this.desc = label;
		this.icon = icon;
	}

	public Label(HostType type) {
		this.label = type.getName();
		this.desc = type.getDesc();
		this.icon = type.getIcon();
	}

	public Label(ViewType type) {
		this.label = type.getName();
		this.desc = type.getDesc();
		this.icon = type.getIcon();
	}

	public Label(ProviderType type) {
		this.label = type.getDesc();
		this.desc = type.getProtocol() + type.getUrl();
		this.icon = type.getIcon();
	}

	public Label(MsmSensorType type) {
		this.label = type.getName();
		this.desc = type.getDesc();
		this.icon = type.getIcon();
	}

	public Label(String label, MsmSensorType type) {
		this.label = label;
		this.desc = type.getDesc();
		this.icon = type.getIcon();
	}

	public String getDescription() {
		return desc;
	}

	public void setDescription(String description) {
		this.desc = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return label;
	}

	public void setName(String name) {
		this.label = name;
	}

}
