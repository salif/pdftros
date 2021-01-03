/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.addwindow;

import java.awt.GridLayout;
import java.io.File;
import java.util.Set;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import salifm.pdftros.ui.addwindow.handler.AddButtonHandler;
import salifm.pdftros.ui.addwindow.handler.NewFolderHandler;
import salifm.pdftros.ui.addwindow.handler.RefreshFoldersHandler;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = -9123486945749970181L;

	public ButtonsPanel(File file, CheckBoxesPanel checkBoxesPanel, Set<JCheckBox> checkboxes, Consumer<Void> consumer) {
		super(new GridLayout(0, 3));

		final JButton refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new RefreshFoldersHandler(checkBoxesPanel, checkboxes));

		final JButton newFolderButton = new JButton("new");
		newFolderButton.addActionListener(new NewFolderHandler(checkBoxesPanel, checkboxes));

		final JButton addPdfButton = new JButton("ok");
		addPdfButton.addActionListener(new AddButtonHandler(file, checkboxes, consumer));

		super.add(refreshButton);
		super.add(newFolderButton);
		super.add(addPdfButton);
	}
}
