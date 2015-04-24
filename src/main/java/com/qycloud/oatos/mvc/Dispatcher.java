package com.qycloud.oatos.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 事件分发器
 * @author yang
 * 
 */
public final class Dispatcher {

	private List<Controller> controllers;
	
	private List<DispatcherListener> listeners;

	private Dispatcher() {
		controllers = Collections.synchronizedList(new ArrayList<Controller>());
		listeners = Collections.synchronizedList(new ArrayList<DispatcherListener>());
	}

	public void addListener(DispatcherListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void register(Controller con) {
		if (!controllers.contains(con)) {
			controllers.add(con);
		}
	}

	public void dispatch(Event event) {
		AppEvent e = new AppEvent(event);
		dispatch(e);
	}

	public void dispatch(Event event, Object data) {
		AppEvent e = new AppEvent(event);
		e.setData(data);
		dispatch(e);
	}

	public void dispatch(AppEvent event) {
		try {
			beforeDispatch(event);
			for (Controller c : controllers) {
				if (c.isRegistered(event.getEvent())) {
					if (!c.isInitialized()) {
						c.init();
					}
					c.handleEvent(event);
				}
			}
			afterDispatch(event);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void beforeDispatch(AppEvent event) {
		for (DispatcherListener listenner : listeners) {
			listenner.before(event);
		}
	}

	private void afterDispatch(AppEvent event) {
		for (DispatcherListener listenner : listeners) {
			listenner.after(event);
		}
	}

	public static Dispatcher get() {
		return DispatherHolder.instance;
	}

	private static class DispatherHolder {
		private static Dispatcher instance = new Dispatcher();
	}

}
