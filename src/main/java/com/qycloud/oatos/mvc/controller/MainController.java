package com.qycloud.oatos.mvc.controller;

import com.qycloud.oatos.mvc.AppEvent;
import com.qycloud.oatos.mvc.Controller;
import com.qycloud.oatos.mvc.Event;

public class MainController extends Controller {

	public MainController() {
		registerEvent(Event.ShowMainView);
	}

	@Override
	protected void handleEvent(AppEvent event) {
		// TODO Auto-generated method stub

	}

}
