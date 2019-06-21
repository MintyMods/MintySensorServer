package info.mintymods.repository.entities;

public class MenuLine {

	private Label label;
	private String url;
	private boolean active;

	public MenuLine() { }

	public MenuLine(Label label, String url, boolean active) {
		this.label = label;
		this.url = url;
		this.active = active;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
