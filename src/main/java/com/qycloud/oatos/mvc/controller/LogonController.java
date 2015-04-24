package com.qycloud.oatos.mvc.controller;

import com.qycloud.oatos.mvc.AppEvent;
import com.qycloud.oatos.mvc.Controller;
import com.qycloud.oatos.mvc.Event;

public class LogonController extends Controller {

	public LogonController() {
		registerEvent(Event.ShowLogonView);
	}

	@Override
	protected void handleEvent(AppEvent event) {
		// TODO Auto-generated method stub

	}

}
