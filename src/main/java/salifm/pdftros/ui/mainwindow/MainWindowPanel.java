/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.mainwindow;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MainWindowPanel extends JPanel {

	private static final long serialVersionUID = 5620631415732606469L;

	public MainWindowPanel() {
		super(new GridLayout(0, 1));
		super.add(new ConfigPanel());
	}
}
