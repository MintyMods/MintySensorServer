package info.mintymods.repository.entities;

public class Sensor {

	private int id;
	private int instance;
	private Label label;

	public Sensor() { }

	public Sensor(int id, int instance, Label label) {
		this.id = id;
		this.instance = instance;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInstance() {
		return instance;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}
