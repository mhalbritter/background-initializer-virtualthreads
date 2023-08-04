package com.example.sb36695;

import java.time.Duration;

/**
 * @author Moritz Halbritter
 */
enum Timing {
	INSTANCE;

	private long started;

	void started() {
		this.started = System.nanoTime();
	}

	Duration elapsedSinceStart() {
		return Duration.ofNanos(System.nanoTime() - started);
	}
}
