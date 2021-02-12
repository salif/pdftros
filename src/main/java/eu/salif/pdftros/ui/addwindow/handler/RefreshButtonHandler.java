/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros.ui.addwindow.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JCheckBox;

import eu.salif.pdftros.ui.addwindow.CheckBoxesPanel;
import eu.salif.pdftros.util.FileUtil;

public class RefreshButtonHandler implements ActionListener {

	private final CheckBoxesPanel checkBoxesPanel;
	private final Set<JCheckBox> checkBoxes;

	public RefreshButtonHandler(CheckBoxesPanel checkBoxesPanel, Set<JCheckBox> checkBoxes) {
		this.checkBoxesPanel = checkBoxesPanel;
		this.checkBoxes = checkBoxes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.checkBoxesPanel.sync(FileUtil.getFolders(), this.checkBoxes);
	}
}
