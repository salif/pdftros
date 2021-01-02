package salifm.pdftros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;
import java.util.function.Consumer;

class AddButtonHandler implements ActionListener {

	private final File file;
	private final Set<JCheckBox> checkboxes;
	private final Consumer<Void> closeCallback;

	AddButtonHandler(File file, Set<JCheckBox> checkboxes, Consumer<Void> closeCallback) {
		this.file = file;
		this.checkboxes = checkboxes;
		this.closeCallback = closeCallback;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final String[] folders = checkboxes.stream().filter(AbstractButton::isSelected)
			.map(AbstractButton::getText).toArray(String[]::new);
		if (folders.length == 0) {
			closeCallback.accept(null);
			return;
		}
		App.addPdfs(this.file, folders);
		closeCallback.accept(null);
	}
}
