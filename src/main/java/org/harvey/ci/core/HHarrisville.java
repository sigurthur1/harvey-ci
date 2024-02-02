package org.harvey.ci.core;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class HHarrisville implements InitializingBean {

	@Autowired
	private HDirectory hDir;
	private File hJobsDir;
	private File hBinDir;
	private File hConfigDir;

	public HHarrisville() {
		super();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		File dir = getHDir();
		if (!dir.isDirectory()) {
			dir.mkdirs();
			getHBinDir().mkdir();
			getHConfigDir().mkdir();
			getHConfigDir().mkdir();
			getHJobsDir().mkdir();
		}
	}

	public File getHDir() {
		return hDir.getDirectory();
	}

	public File getHBinDir() {
		if (hBinDir == null) {
			hBinDir = new File(getHDir(), "bin");
		}
		return hBinDir;
	}

	public File getHConfigDir() {
		if (hConfigDir == null) {
			hConfigDir = new File(getHDir(), "config");
		}
		return hConfigDir;
	}

	public File getHJobsDir() {
		if (hJobsDir == null) {
			hJobsDir = new File(getHDir(), "jobs");
		}
		return hJobsDir;
	}

	public List<HJob> getHJobs() {
		File[] dirset = getHJobsDir().listFiles(path -> path.isDirectory());
		return Arrays.asList(dirset).stream()
			.map(dir -> new HJob(dir)).collect(Collectors.toList());
	}
}
