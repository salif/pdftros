/*
 * Copyright (c) 2021 Salif Mehmed
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
**/

package salifm.pdftros;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import salifm.pdftros.config.Config;
import salifm.pdftros.ui.AddWindow;
import salifm.pdftros.util.FileManager;

public class App {

	public void start(String[] args) {
		setTheme(Config.getLookAndFeel());
		try {
			FileManager.initFolders(FileManager.getPath(), FileManager.getPath(Config.getAllDir()),
					FileManager.getPath(Config.getOrgDir()));
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
			new AddWindow(FileManager.getFolders(), arg).start();
		}
	}

	private void showMainWindow() {
		// TODO
	}

	public static void addPdfs(File pdf, String[] folders) {
		try {
			FileManager.copyFile(pdf.toPath(), FileManager.getPath(Config.getAllDir(), pdf.getName()));
		} catch (IOException e) {
			App.showError(e);
		}
		for (final String folder : folders) {
			try {
				FileManager.createSymbolicLink(FileManager.getPath(Config.getOrgDir(), folder, pdf.getName()),
						FileManager.getPath(Config.getAllDir(), pdf.getName()));
			} catch (IOException e) {
				App.showError(e);
				return;
			}
		}
	}

	private static void setTheme(String lookAndFeel) {
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
