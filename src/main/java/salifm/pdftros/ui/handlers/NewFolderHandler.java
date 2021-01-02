/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.handlers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

import salifm.pdftros.ui.AddWindowPanel;
import salifm.pdftros.util.FileUtil;
import salifm.pdftros.App;


public class NewFolderHandler implements ActionListener {

	private JPanel checkboxesPanel;
	private Set<JCheckBox> checkboxes;

	public NewFolderHandler(JPanel checkboxesPanel, Set<JCheckBox> checkboxes) {
		this.checkboxesPanel = checkboxesPanel;
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
			AddWindowPanel.syncCheckBoxes(this.checkboxesPanel, FileUtil.getFolders(), this.checkboxes);
		}
	}
}
