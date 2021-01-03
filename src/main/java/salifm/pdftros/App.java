/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import salifm.pdftros.config.Config;
import salifm.pdftros.ui.AddWindow;
import salifm.pdftros.ui.MainWindow;
import salifm.pdftros.util.FileUtil;

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
			this.showMainWindow();
		}
	}

	private void showAddPdfWindow(String[] args) {
		for (final String arg : args) {
			new AddWindow(FileUtil.getFolders(), arg).start();
		}
	}

	private void showMainWindow() {
		new MainWindow().start();
	}

	public static void addPdfs(File pdf, String[] folders) {
		try {
			FileUtil.copyFile(pdf.toPath(), FileUtil.getPath(Config.getAllDir(), pdf.getName()));
		} catch (IOException e) {
			App.showError(e);
		}
		for (final String folder : folders) {
			try {
				FileUtil.createSymbolicLink(FileUtil.getPath(Config.getOrgDir(), folder, pdf.getName()),
				FileUtil.getPath(Config.getAllDir(), pdf.getName()));
			} catch (IOException e) {
				App.showError(e);
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

	public static void showError(Throwable t) {
		t.printStackTrace();
		JOptionPane.showMessageDialog(null, t.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
	}
}
