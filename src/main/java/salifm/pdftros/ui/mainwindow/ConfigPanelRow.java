/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.mainwindow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import salifm.pdftros.App;
import salifm.pdftros.config.Config;

public class ConfigPanelRow extends JPanel {

	private static final long serialVersionUID = 3271075057905751387L;

	public ConfigPanelRow(String label, String value, Consumer<String> consumer) {
		super(new BorderLayout());
		super.add(new JLabel(label), BorderLayout.LINE_START);
		final JTextField field = new JTextField(value);
		super.add(field, BorderLayout.CENTER);
		final JButton button = new JButton("set");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consumer.accept(field.getText());
				Config.sync();
				App.showInfo("Done!");
			}
		});
		super.add(button, BorderLayout.LINE_END);
	}
}
