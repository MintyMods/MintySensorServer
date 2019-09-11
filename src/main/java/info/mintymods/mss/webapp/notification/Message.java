package info.mintymods.mss.webapp.notification;

public class Message {

	public enum Type {
		SIMPLE(""), NOTICE("fas fa-question-circle"), INFO("fas fa-info-circle "), SUCCESS("fad fa-check-circle"), ERROR("far fa-exclamation-circle");

		private final String icon;

		private Type(final String icon) {
			this.icon = icon;
		}

		public String getIcon() {
			return icon;
		}
	}

	private Modules modules = new Modules();
	private String icon;
	private Type type = Type.SIMPLE;
	private String title;
	private String text;
	private String addClass;
	private String width;
	private String minHeight;
	private String animateSpeed = "none";
	private boolean textTrusted = true;
	private boolean titleTrusted = true;
	private boolean hide = true;
	private boolean shadow = false;
	private boolean mouseReset = true;

	public String getIcon() {
		return icon;
	}

	public void setIcon(final String icon) {
		this.icon = icon;
	}

	public Type getType() {
		return type;
	}

	public void setType(final Type type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public String getAddClass() {
		return addClass;
	}

	public void setAddClass(final String addClass) {
		this.addClass = addClass;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(final String width) {
		this.width = width;
	}

	public String getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(final String minHeight) {
		this.minHeight = minHeight;
	}

	public String getAnimateSpeed() {
		return animateSpeed;
	}

	public void setAnimateSpeed(final String animateSpeed) {
		this.animateSpeed = animateSpeed;
	}

	public boolean isTextTrusted() {
		return textTrusted;
	}

	public void setTextTrusted(final boolean textTrusted) {
		this.textTrusted = textTrusted;
	}

	public boolean isTitleTrusted() {
		return titleTrusted;
	}

	public void setTitleTrusted(final boolean titleTrusted) {
		this.titleTrusted = titleTrusted;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(final boolean hide) {
		this.hide = hide;
	}

	public boolean isShadow() {
		return shadow;
	}

	public void setShadow(final boolean shadow) {
		this.shadow = shadow;
	}

	public boolean isMouseReset() {
		return mouseReset;
	}

	public void setMouseReset(final boolean mouseReset) {
		this.mouseReset = mouseReset;
	}

	public Modules getModules() {
		return modules;
	}

	public void setModules(final Modules modules) {
		this.modules = modules;
	}
}
