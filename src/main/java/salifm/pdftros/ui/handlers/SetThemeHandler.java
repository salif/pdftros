/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import salifm.pdftros.config.Config;

public class SetThemeHandler implements ActionListener {

	private JComboBox<String> themesList;

	public SetThemeHandler(JComboBox<String> themesList) {
		this.themesList = themesList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Config.setLookAndFeel((String) this.themesList.getSelectedItem());
		Config.sync();
	}
}
