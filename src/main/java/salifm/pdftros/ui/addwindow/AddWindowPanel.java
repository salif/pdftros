/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.addwindow;

import java.awt.BorderLayout;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddWindowPanel extends JPanel {

	private static final long serialVersionUID = -7448484800129864793L;

	public AddWindowPanel(String[] folders, String pdf, Consumer<Void> consumer) {
		super(new BorderLayout());

		final File file = new File(pdf);
		final Set<JCheckBox> checkboxes = new HashSet<>();

		super.add(new JLabel(file.getName()), BorderLayout.NORTH);
		final CheckBoxesPanel checkBoxesPanel = new CheckBoxesPanel(checkboxes, folders);
		super.add(checkBoxesPanel, BorderLayout.CENTER);
		super.add(new ButtonsPanel(file, checkBoxesPanel, checkboxes, consumer), BorderLayout.SOUTH);
	}
}

