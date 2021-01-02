package salifm.pdftros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

class FileManager {

	@SuppressWarnings("ConstantConditions")
	static String[] getFolders() {
		final File[] folders = Arrays.stream(new File(getPath(Config.getOrgDir()).toString())
			.listFiles(File::isDirectory)).sorted().toArray(File[]::new);
		if (null == folders) {
			return new String[]{};
		}
		return Arrays.stream(folders).map(File::getName).toArray(String[]::new);
	}

	static Path getPath(String... ps) {
		return Path.of(Config.getMainDir(), ps);
	}

	static void initFolders(Path... ps) throws IOException {
		for (final Path p : ps) {
			if (!Files.isDirectory(p)) {
				Files.createDirectory(p);
			}
		}
	}

	static void createFolder(String folderName) throws IOException {
		Files.createDirectory(getPath(Config.getOrgDir(), folderName));
	}

	static void copyFile(Path file, Path folder) throws IOException {
		Files.copy(file, folder);
	}

	static void createSymbolicLink(Path file, Path folder) throws IOException {
		Files.createSymbolicLink(file, folder);
	}
}
