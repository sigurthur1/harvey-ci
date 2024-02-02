package org.harvey.ci.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class HDirectoryTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	private Path originalUserHomePath;

	@Before
	public void setUp() {
		originalUserHomePath = Paths.get(System.getProperty("user.home"));
	}

	@After
	public void tearDown() {
		System.setProperty("user.home", originalUserHomePath.toFile().getAbsolutePath());
	}

	@Test
	public void testGetDirectoryResolveToHarrisville() {
		File expected = new File(folder.getRoot(), ".harrisville");
		try {
			System.setProperty("HARRISVILLE", expected.getAbsolutePath());
			File resolved = (new HDirectory()).getDirectory();
			assertEquals(expected, resolved);
		} finally {
			System.clearProperty("HARRISVILLE");
		}
	}

	@Test
	public void testGetDirectoryResolveToUserHome() throws IOException {
		System.setProperty("user.home", folder.getRoot().getAbsolutePath());
		File expected = folder.newFolder(".harrisville");
		File resolved = (new HDirectory()).getDirectory();
		assertEquals(expected, resolved);
	}
}
