package com.qycloud.oatos.mvc;

public class Test {

	public static void main(String[] args) {
		Dispatcher.get().addListener(ControllerManager.get());
		Dispatcher.get().dispatch(Event.ShowLogonView);
	}

}
