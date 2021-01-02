/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui;

import javax.swing.JFrame;

public class AddWindow extends JFrame {

	private static final long serialVersionUID = 2586174935411379563L;

	public AddWindow(String[] folders, String pdf) {
		super.setTitle("Add pdf");
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(400, 300);
		super.setLocationRelativeTo(null);
		super.setContentPane(new AddWindowPanel(folders, pdf, (Void v) -> {super.dispose();}));
	}

	public void start() {
		super.setVisible(true);
	}
}
