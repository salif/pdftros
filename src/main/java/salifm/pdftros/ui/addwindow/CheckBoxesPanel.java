/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.addwindow;

import java.awt.FlowLayout;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBoxesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CheckBoxesPanel(Set<JCheckBox> checkboxes, String[] folders) {
		super(new FlowLayout());
		this.sync(folders, checkboxes);
	}

	public void sync(String[] folders, Set<JCheckBox> checkboxes) {
		this.removeAll();
		this.revalidate();
		this.repaint();
		checkboxes.clear();

		for (final String folderName : folders) {
			final JCheckBox c = new JCheckBox(folderName);
			checkboxes.add(c);
			this.add(c);
		}
	}

}
