/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.addwindow.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JCheckBox;

import salifm.pdftros.ui.addwindow.CheckBoxesPanel;
import salifm.pdftros.util.FileUtil;

public class RefreshFoldersHandler implements ActionListener {

	private final CheckBoxesPanel checkBoxesPanel;
	private final Set<JCheckBox> checkBoxes;

	public RefreshFoldersHandler(CheckBoxesPanel checkBoxesPanel, Set<JCheckBox> checkBoxes) {
		this.checkBoxesPanel = checkBoxesPanel;
		this.checkBoxes = checkBoxes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.checkBoxesPanel.sync(FileUtil.getFolders(), this.checkBoxes);
	}
}
