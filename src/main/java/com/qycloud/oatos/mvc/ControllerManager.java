package com.qycloud.oatos.mvc;

import com.qycloud.oatos.mvc.controller.LogonController;
import com.qycloud.oatos.mvc.controller.MainController;

/**
 * 控制管理器
 * @author yang
 *
 */
public final class ControllerManager implements DispatcherListener {

	private Dispatcher dispatcher = Dispatcher.get();
	
	private LogonController logonController;
	private MainController mainController;

	private ControllerManager() {
	}

	@Override
	public synchronized void before(AppEvent event) {
		System.out.println("before dispatch:" + event.getEvent());

		if (Event.ShowLogonView.equals(event.getEvent())) {
			if (logonController == null) {
				logonController = new LogonController();
				dispatcher.register(logonController);
			}
		}

		if (Event.ShowMainView.equals(event.getEvent())) {
			if (mainController == null) {
				mainController = new MainController();
				dispatcher.register(mainController);
			}
		}

	}

	@Override
	public void after(AppEvent event) {
		System.out.println("after dispatch:" + event.getEvent());
	}

	public static ControllerManager get() {
		return ControllerManagerHolder.instance;
	}

	private static class ControllerManagerHolder {
		private static ControllerManager instance = new ControllerManager();
	}

}
