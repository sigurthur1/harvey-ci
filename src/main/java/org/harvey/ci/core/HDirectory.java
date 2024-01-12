package org.harvey.ci.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Base directory for the Harvey files system. 
 * <p>
 * This class cascades the creation of the base directory by first checking the
 * HARRISVILLE environment variable, then for a .harrisville directory in the
 * user's home directory, and finally for a .harrisville directory in the start
 * up (current working) directory of this process.
 * <p>
 * Hopefully, one of those works.
 * 
 * @author A. Shirley
 * @since January 12, 2024
 */
public class HDirectory {

	private File directory;

	private File ensureDirectory(Path path) throws IOException {
		File dir = path.toFile();
		if (dir.exists() && !dir.isDirectory()) {
			throw new IOException("Harrisville exists but is not directory");
		}
		return dir;
	}

	public File getDirectory() {
		if (directory == null) {
			try {
				String s = System.getProperty("HARRISVILLE");
				if (s != null) {
					Path path = Paths.get(s);
					return ensureDirectory(path);
				} else {
					String h = System.getProperty("user.home");
					if (h != null) {
						Path path = Paths.get(h, ".harrisville");
						return ensureDirectory(path);
					} else {
						Path path = Paths.get(".harrisville");
						return ensureDirectory(path);
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return directory;
	}

}
