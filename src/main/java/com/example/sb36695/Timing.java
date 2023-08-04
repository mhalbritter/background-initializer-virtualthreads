package com.example.sb36695;

import java.time.Duration;

/**
 * @author Moritz Halbritter
 */
public enum Timing {
	INSTANCE;

	private volatile long started;

	private volatile Duration runnable;

	private volatile Duration latch;

	private volatile Duration request;

	public long getStarted() {
		return started;
	}

	public void setStarted(long started) {
		this.started = started;
	}

	public void setRunnable(Duration runnable) {
		this.runnable = runnable;
	}

	public void setLatch(Duration latch) {
		this.latch = latch;
	}

	public void setRequest(Duration request) {
		this.request = request;
	}

	public void printSummary() {
		System.out.println("Runnable: " + runnable);
		System.out.println("Await Latch: " + latch);
		System.out.println("First request: " + request);
	}
}
