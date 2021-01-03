/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import salifm.pdftros.config.Config;

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
		return Path.of(Config.getMainDir(), ps);
	}

	public static void initFolders() throws IOException {
		Path[] ps = new Path[]{
				FileUtil.getPath(),
				FileUtil.getPath(Config.getAllDir()),
				FileUtil.getPath(Config.getOrgDir())};
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
}
