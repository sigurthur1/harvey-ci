package org.harvey.ci.core;

import java.io.File;

public class HJob {
	private File dir;

	public HJob(File dir) {
		this.dir = dir;
	}

	public File getDir() {
		return dir;
	}
}
