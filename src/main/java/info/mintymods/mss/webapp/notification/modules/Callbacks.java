package info.mintymods.mss.webapp.notification.modules;

import info.mintymods.mss.webapp.notification.events.AfterClose;
import info.mintymods.mss.webapp.notification.events.AfterInit;
import info.mintymods.mss.webapp.notification.events.AfterOpen;
import info.mintymods.mss.webapp.notification.events.BeforeClose;
import info.mintymods.mss.webapp.notification.events.BeforeInit;
import info.mintymods.mss.webapp.notification.events.BeforeOpen;

public class Callbacks {

	private BeforeInit beforeInit;
	private AfterInit afterInit;
	private BeforeOpen beforeOpen;
	private AfterOpen afterOpen;
	private BeforeClose beforeClose;
	private AfterClose afterClose;

	public BeforeInit getBeforeInit() {
		return beforeInit;
	}

	public void setBeforeInit(final BeforeInit beforeInit) {
		this.beforeInit = beforeInit;
	}

	public AfterInit getAfterInit() {
		return afterInit;
	}

	public void setAfterInit(final AfterInit afterInit) {
		this.afterInit = afterInit;
	}

	public BeforeOpen getBeforeOpen() {
		return beforeOpen;
	}

	public void setBeforeOpen(final BeforeOpen beforeOpen) {
		this.beforeOpen = beforeOpen;
	}

	public AfterOpen getAfterOpen() {
		return afterOpen;
	}

	public void setAfterOpen(final AfterOpen afterOpen) {
		this.afterOpen = afterOpen;
	}

	public BeforeClose getBeforeClose() {
		return beforeClose;
	}

	public void setBeforeClose(final BeforeClose beforeClose) {
		this.beforeClose = beforeClose;
	}

	public AfterClose getAfterClose() {
		return afterClose;
	}

	public void setAfterClose(final AfterClose afterClose) {
		this.afterClose = afterClose;
	}
}
