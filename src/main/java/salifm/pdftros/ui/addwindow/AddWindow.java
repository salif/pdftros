/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.addwindow;

import salifm.pdftros.config.Config;
import salifm.pdftros.ui.Window;

public class AddWindow extends Window {

	private static final long serialVersionUID = -3621202156259013407L;

	public AddWindow(String[] folders, String pdf) {
		super("Add pdf", Config.getAddWindowWidth(), Config.getAddWindowHeight());
		super.setContentPane(new AddWindowPanel(folders, pdf, Void -> super.dispose()));
	}
}
