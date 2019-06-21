package info.mintymods.repository.entities;

import info.mintymods.msm.MsmSensorType;
import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.repository.entities.enums.ViewType;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final Label other = (Label) obj;
		if (desc == null) {
			if (other.desc != null) { return false; }
		} else
			if (!desc.equals(other.desc)) { return false; }
		if (icon == null) {
			if (other.icon != null) { return false; }
		} else
			if (!icon.equals(other.icon)) { return false; }
		if (name == null) {
			if (other.name != null) { return false; }
		} else
			if (!name.equals(other.name)) { return false; }
		return true;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((desc == null) ? 0 : desc.hashCode());
		result = (prime * result) + ((icon == null) ? 0 : icon.hashCode());
		result = (prime * result) + ((name == null) ? 0 : name.hashCode());
		return result;
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
