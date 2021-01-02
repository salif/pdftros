/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -5206892306106613089L;

	public MainWindow() {
		super.setTitle("pdftros settings");
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(512, 512);
		super.setLocationRelativeTo(null);
		super.setContentPane(new MainWindowPanel());
	}

	public void start() {
		super.setVisible(true);
	}
}
