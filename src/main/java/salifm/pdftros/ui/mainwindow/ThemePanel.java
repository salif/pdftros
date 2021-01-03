/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.mainwindow;

import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.UIManager;

import salifm.pdftros.ui.mainwindow.handler.SetThemeHandler;

public class ThemePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ThemePanel() {
		final BoxLayout themeLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		super.setLayout(themeLayout);
		super.setBorder(BorderFactory.createTitledBorder("Theme"));

		final JComboBox<String> themesList = new JComboBox<>(
				Arrays.stream(UIManager.getInstalledLookAndFeels())
				.map(m -> m.getClassName()).toArray(String[]::new));

		super.add(themesList);

		final JButton setThemeButton = new JButton("set theme");
		setThemeButton.addActionListener(new SetThemeHandler(themesList));
		super.add(setThemeButton);
	}

}
