package info.mintymods.mss.webapp.notification.modules;

public class Buttons {

	private boolean closer = true;
	private boolean sticker = true;
	private boolean closerHover = true;
	private boolean stickerHover = true;
	private Classes classes = new Classes();

	public boolean isCloser() {
		return closer;
	}

	public void setCloser(final boolean closer) {
		this.closer = closer;
	}

	public boolean isSticker() {
		return sticker;
	}

	public void setSticker(final boolean sticker) {
		this.sticker = sticker;
	}

	public boolean isCloserHover() {
		return closerHover;
	}

	public void setCloserHover(final boolean closerHover) {
		this.closerHover = closerHover;
	}

	public boolean isStickerHover() {
		return stickerHover;
	}

	public void setStickerHover(final boolean stickerHover) {
		this.stickerHover = stickerHover;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(final Classes classes) {
		this.classes = classes;
	}
}
