/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import eu.salif.pdftros.config.Config;

public class FileUtil {

	@SuppressWarnings("ConstantConditions")
	public static String[] getFolders() {
		final File[] folders = Arrays.stream(new File(getPath(Config.getOrgDir()).toString())
			.listFiles(File::isDirectory)).sorted().toArray(File[]::new);
		if (null == folders) {
			return new String[]{};
		}
		return Arrays.stream(folders).map(File::getName).toArray(String[]::new);
	}

	public static Path getPath(String... ps) {
		return Path.of(Config.getFullMainDir().toString(), ps);
	}

	public static boolean exists(Path path) {
		return Files.exists(path);
	}

	public static void initFolders() throws IOException {
		final Path[] ps = new Path[]{
				FileUtil.getPath(),
				FileUtil.getPath(Config.getAllDir()),
				FileUtil.getPath(Config.getOrgDir()),
				FileUtil.getPath(Config.getWaitingDir())};
		for (final Path p : ps) {
			if (!Files.isDirectory(p)) {
				Files.createDirectory(p);
			}
		}
	}

	public static void createFolder(String folderName) throws IOException {
		Files.createDirectory(getPath(Config.getOrgDir(), folderName));
	}

	public static void copyFile(Path file, Path folder) throws IOException {
		Files.copy(file, folder);
	}

	public static void createSymbolicLink(Path file, Path folder) throws IOException {
		Files.createSymbolicLink(file, folder);
	}

	public static boolean isAdded(Path file) {
		final String fileName = file.getFileName().toString();
		if (exists(FileUtil.getPath(Config.getAllDir(), fileName)) ||
			exists(FileUtil.getPath(Config.getWaitingDir(), fileName))) {
			return true;
		} else {
			return false;
		}
	}
}
