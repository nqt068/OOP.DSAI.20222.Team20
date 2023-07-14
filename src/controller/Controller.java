package controller;

import java.awt.event.ActionListener;

import listener.ScreenListener;

public class Controller {
	private ScreenListener screenListener;

	public Controller() {
		this.screenListener = new ScreenListener();
	}
	
	public ActionListener exitProtol() {
		return this.screenListener.exitListener;
	}
	public ActionListener backProtocol() {
		return this.screenListener.backListener;
	}
}
