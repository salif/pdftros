/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros.ui.mainwindow;

import javax.swing.JScrollPane;

import eu.salif.pdftros.config.Config;
import eu.salif.pdftros.ui.Window;

public class MainWindow extends Window {

	private static final long serialVersionUID = 2451735109654782417L;

	public MainWindow() {
		super("pdftros settings", Config.getMainWindowWidth(), Config.getMainWindowHeight());
		super.setContentPane(new JScrollPane(new MainWindowPanel()));
		super.pack();
	}
}
