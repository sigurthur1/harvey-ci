package org.harvey.ci.core;

import java.io.File;

public class HJob {
	private String id;
	private File dir;

	public HJob(File dir) {
		this.dir = dir;
		// TODO: generate hashed (SHA256) id from directory name.
	}

	public String getId() {
		return id;
	}

	public File getDir() {
		return dir;
	}
}
