/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.addwindow.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import salifm.pdftros.App;
import salifm.pdftros.ui.addwindow.CheckBoxesPanel;
import salifm.pdftros.util.FileUtil;


public class NewFolderHandler implements ActionListener {

	private final CheckBoxesPanel checkBoxesPanel;
	private final Set<JCheckBox> checkboxes;

	public NewFolderHandler(CheckBoxesPanel checkBoxesPanel, Set<JCheckBox> checkboxes) {
		this.checkBoxesPanel = checkBoxesPanel;
		this.checkboxes = checkboxes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final String input = JOptionPane.showInputDialog((JButton) e.getSource(), "New Folder Name:");
		if ((input != null) && (input.length() > 0)) {
			try {
				FileUtil.createFolder(input);
			} catch (IOException ioException) {
				App.showError(ioException);
				return;
			}
			this.checkBoxesPanel.sync(FileUtil.getFolders(), this.checkboxes);
		}
	}
}
