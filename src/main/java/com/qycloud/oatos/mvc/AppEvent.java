package com.qycloud.oatos.mvc;

/**
 * 系统事件
 * @author yang
 * 
 */
public class AppEvent {

	/**
	 * 事件类型
	 */
	private Event event;

	/**
	 * 数据
	 */
	private Object data;

	public AppEvent(Event event) {
		this.event = event;
	}

	@SuppressWarnings("unchecked")
	public <T> T getData() {
		T v = null;
		if (data != null) {
			v = (T) data;
		}
		return v;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Event getEvent() {
		return event;
	}

}
