/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 3831063236809488549L;

	public Window(String title, int width, int height) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(width, height);
		super.setLocationRelativeTo(null);
	}

	public void start() {
		super.setVisible(true);
	}
}
