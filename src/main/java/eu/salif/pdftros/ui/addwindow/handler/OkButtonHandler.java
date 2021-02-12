/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros.ui.addwindow.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

import eu.salif.pdftros.App;

public class OkButtonHandler implements ActionListener {

	private final Path file;
	private final Set<JCheckBox> checkboxes;
	private final Consumer<Void> consumer;

	public OkButtonHandler(Path file, Set<JCheckBox> checkboxes, Consumer<Void> consumer) {
		this.file = file;
		this.checkboxes = checkboxes;
		this.consumer = consumer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final String[] folders = checkboxes.stream().filter(AbstractButton::isSelected)
			.map(AbstractButton::getText).toArray(String[]::new);
		if (folders.length == 0) {
			App.addToWaitingDir(this.file);
			this.consumer.accept(null);
			return;
		}
		App.addPdfs(this.file, folders);
		this.consumer.accept(null);
	}
}
