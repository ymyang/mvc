package com.qycloud.oatos.mvc;

/**
 * 事件分发监听
 * @author yang
 * 
 */
public interface DispatcherListener {

	void before(AppEvent event);

	void after(AppEvent event);
}
