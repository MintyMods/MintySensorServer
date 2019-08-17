package info.mintymods.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "minty_view")
public class View { // extends Auditable<String>

	public static final String ICON = "fal fa-eye";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "minty_view_gen")
	@SequenceGenerator(name = "minty_view_gen", sequenceName = "MINTY_VIEW_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String name;
	private String desc;

	public View() {
	}

	public View(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
