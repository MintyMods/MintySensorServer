package info.mintymods.mss.webapp.notification.modules;

public class Stack {

	private String dir1;
	private String dir2;
	private String push;
	private int firstpos1;
	private int firstpos2;
	private String context;
	private boolean modal;
	private boolean overlayClose;

	public String getDir1() {
		return dir1;
	}

	public void setDir1(final String dir1) {
		this.dir1 = dir1;
	}

	public String getDir2() {
		return dir2;
	}

	public void setDir2(final String dir2) {
		this.dir2 = dir2;
	}

	public String getPush() {
		return push;
	}

	public void setPush(final String push) {
		this.push = push;
	}

	public int getFirstpos1() {
		return firstpos1;
	}

	public void setFirstpos1(final int firstpos1) {
		this.firstpos1 = firstpos1;
	}

	public int getFirstpos2() {
		return firstpos2;
	}

	public void setFirstpos2(final int firstpos2) {
		this.firstpos2 = firstpos2;
	}

	public String getContext() {
		return context;
	}

	public void setContext(final String context) {
		this.context = context;
	}

	public boolean isModal() {
		return modal;
	}

	public void setModal(final boolean modal) {
		this.modal = modal;
	}

	public boolean isOverlayClose() {
		return overlayClose;
	}

	public void setOverlayClose(final boolean overlayClose) {
		this.overlayClose = overlayClose;
	}
}
