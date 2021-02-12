/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros.ui.addwindow.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class CancelButtonHandler implements ActionListener {

	private final Consumer<Void> consumer;

	public CancelButtonHandler(Consumer<Void> consumer) {
		this.consumer = consumer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.consumer.accept(null);
	}
}
