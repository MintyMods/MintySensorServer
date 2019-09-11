package info.mintymods.mss.webapp.notification;

import info.mintymods.mss.webapp.notification.modules.Buttons;
import info.mintymods.mss.webapp.notification.modules.Callbacks;
import info.mintymods.mss.webapp.notification.modules.Stack;

public class Modules {

	private Stack stack = new Stack();
	private Callbacks callbacks = new Callbacks();
	private Buttons buttons = new Buttons();

	public Stack getStack() {
		return stack;
	}

	public void setStack(final Stack stack) {
		this.stack = stack;
	}

	public Callbacks getCallbacks() {
		return callbacks;
	}

	public void setCallbacks(final Callbacks callbacks) {
		this.callbacks = callbacks;
	}

	public Buttons getButtons() {
		return buttons;
	}

	public void setButtons(final Buttons buttons) {
		this.buttons = buttons;
	}
}
