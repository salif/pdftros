/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.mainwindow;

import salifm.pdftros.config.Config;
import salifm.pdftros.ui.Window;

public class MainWindow extends Window {

	private static final long serialVersionUID = 2451735109654782417L;

	public MainWindow() {
		super("pdftros settings", Config.getMainWindowWidth(), Config.getMainWindowHeight());
		super.setContentPane(new MainWindowPanel());
	}
}
