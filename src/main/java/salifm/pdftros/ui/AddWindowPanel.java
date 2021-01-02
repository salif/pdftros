/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui;

import salifm.pdftros.ui.handlers.AddButtonHandler;
import salifm.pdftros.ui.handlers.NewFolderHandler;
import salifm.pdftros.ui.handlers.RefreshFoldersHandler;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AddWindowPanel extends JPanel {

	private static final long serialVersionUID = -4848686136035751295L;

	public AddWindowPanel(String[] folders, String pdf, Consumer<Void> closeCallback) {
		super(new BorderLayout());

		final File file = new File(pdf);
		final JLabel title = new JLabel(file.getName());
		super.add(title, BorderLayout.NORTH);

		final JPanel checkboxesPanel = new JPanel();
		checkboxesPanel.setLayout(new BoxLayout(checkboxesPanel, BoxLayout.Y_AXIS));
		final Set<JCheckBox> checkboxes = new HashSet<>();
		syncCheckBoxes(checkboxesPanel, folders, checkboxes);
		super.add(new JScrollPane(checkboxesPanel), BorderLayout.CENTER);

		final JPanel buttonsPanel = new JPanel(new GridLayout(1, 3));

		final JButton refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new RefreshFoldersHandler(checkboxesPanel, checkboxes));

		final JButton newFolderButton = new JButton("new");
		newFolderButton.addActionListener(new NewFolderHandler(checkboxesPanel, checkboxes));

		final JButton addPdfButton = new JButton("ok");
		addPdfButton.addActionListener(new AddButtonHandler(file, checkboxes, closeCallback));

		buttonsPanel.add(refreshButton);
		buttonsPanel.add(newFolderButton);
		buttonsPanel.add(addPdfButton);
		super.add(buttonsPanel, BorderLayout.SOUTH);
	}

	public static void syncCheckBoxes(JPanel checkboxesPanel, String[] folders, Set<JCheckBox> checkboxes) {
		checkboxesPanel.removeAll();
		checkboxesPanel.revalidate();
		checkboxesPanel.repaint();
		checkboxes.clear();
		for (final String folderName : folders) {
			final JCheckBox c = new JCheckBox(folderName);
			checkboxes.add(c);
			checkboxesPanel.add(c);
		}
	}
}

