/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros;

import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import eu.salif.pdftros.config.Config;
import eu.salif.pdftros.ui.addwindow.AddWindow;
import eu.salif.pdftros.ui.mainwindow.MainWindow;
import eu.salif.pdftros.util.FileUtil;

public class App {

	public void start(String[] args) {
		Config.sync();
		setTheme(Config.getLookAndFeel());
		try {
			FileUtil.initFolders();
		} catch (Throwable t) {
			showError(t);
			return;
		}
		if (args.length > 0) {
			this.showAddPdfWindow(args);
		} else {
			new MainWindow().start();
		}
	}

	private void showAddPdfWindow(String[] args) {
		for (final String arg : args) {
			final Path file = Path.of(arg);
			if (!FileUtil.exists(file)) {
				showError(new Exception(String.format("%s does not exist!", arg)));
			} else if (FileUtil.isAdded(file)) {
				showError(new Exception("Already added!"));
			} else {
				new AddWindow(FileUtil.getFolders(), file).start();
			}
		}
	}

	public static void addPdfs(Path file, String[] folders) {
		final String fileName = file.getFileName().toString();
		try {
			FileUtil.copyFile(file, FileUtil.getPath(Config.getAllDir(), fileName));
		} catch (IOException e) {
			showError(e);
			return;
		}
		for (final String folder : folders) {
			try {
				FileUtil.createSymbolicLink(FileUtil.getPath(Config.getOrgDir(), folder, fileName),
					FileUtil.getPath(Config.getAllDir(), fileName));
			} catch (IOException e) {
				showError(e);
				return;
			}
		}
	}

	public static void setTheme(String lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void showInfo(String text) {
		JOptionPane.showMessageDialog(null, text);
	}

	public static void showError(Throwable t) {
		t.printStackTrace();
		JOptionPane.showMessageDialog(null, t.getLocalizedMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
	}

	public static void addToWaitingDir(Path file) {
		final String fileName = file.getFileName().toString();
		try {
			FileUtil.copyFile(file, FileUtil.getPath(Config.getWaitingDir(), fileName));
		} catch (IOException e) {
			showError(e);
			return;
		}
	}
}
