/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros.ui.addwindow;

import java.awt.GridLayout;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import eu.salif.pdftros.ui.addwindow.handler.CancelButtonHandler;
import eu.salif.pdftros.ui.addwindow.handler.NewFolderButtonHandler;
import eu.salif.pdftros.ui.addwindow.handler.OkButtonHandler;
import eu.salif.pdftros.ui.addwindow.handler.RefreshButtonHandler;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = -9123486945749970181L;

	public ButtonsPanel(Path file, CheckBoxesPanel checkBoxesPanel, Set<JCheckBox> checkboxes, Consumer<Void> consumer) {
		super(new GridLayout(0, 4));

		final JButton cancelButton = new JButton("cancel");
		cancelButton.addActionListener(new CancelButtonHandler(consumer));

		final JButton refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new RefreshButtonHandler(checkBoxesPanel, checkboxes));

		final JButton newFolderButton = new JButton("new folder");
		newFolderButton.addActionListener(new NewFolderButtonHandler(checkBoxesPanel, checkboxes));

		final JButton okButton = new JButton("ok");
		okButton.addActionListener(new OkButtonHandler(file, checkboxes, consumer));

		super.add(cancelButton);
		super.add(refreshButton);
		super.add(newFolderButton);
		super.add(okButton);
	}
}
