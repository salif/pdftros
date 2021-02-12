/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros.ui.mainwindow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import eu.salif.pdftros.App;
import eu.salif.pdftros.config.Config;

public class ThemeRow extends JPanel {

	private static final long serialVersionUID = 1L;

	public ThemeRow() {
		super(new BorderLayout());
		super.add(new JLabel("Theme "), BorderLayout.LINE_START);

		final JComboBox<String> themesList = new JComboBox<>(
				Arrays.stream(UIManager.getInstalledLookAndFeels()).map(m -> m.getClassName()).toArray(String[]::new));

		super.add(themesList, BorderLayout.CENTER);

		final JButton setThemeButton = new JButton("set");
		setThemeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Config.setLookAndFeel((String) themesList.getSelectedItem());
				Config.sync();
				App.showInfo("Done!");
			}
		});
		super.add(setThemeButton, BorderLayout.LINE_END);
	}
}
