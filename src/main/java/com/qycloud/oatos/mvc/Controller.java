package com.qycloud.oatos.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器
 * @author yang
 *
 */
public abstract class Controller {

	private boolean initialized;

	private List<Event> registeredEvents = new ArrayList<Event>();

	public final void init() {
		if (!initialized) {
			initialize();
			initialized = true;
		}
	}

	public final boolean isInitialized() {
		return initialized;
	}

	public final boolean isRegistered(Event event) {
		return registeredEvents.contains(event);
	}

	protected final void registerEvent(Event... event) {
		if (event != null) {
			for (Event e : event) {
				if (!isRegistered(e)) {
					registeredEvents.add(e);
				}
			}
		}
	}

	protected void initialize() {
		
	}

	protected abstract void handleEvent(AppEvent event);
}
