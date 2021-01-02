package salifm.pdftros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

class NewFolderHandler implements ActionListener {

	private JPanel checkboxesPanel;
	private Set<JCheckBox> checkboxes;

	NewFolderHandler(JPanel checkboxesPanel, Set<JCheckBox> checkboxes) {
		this.checkboxesPanel = checkboxesPanel;
		this.checkboxes = checkboxes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final String input = JOptionPane.showInputDialog((JButton) e.getSource(), "New Folder Name:");
		if ((input != null) && (input.length() > 0)) {
			try {
				FileManager.createFolder(input);
			} catch (IOException ioException) {
				App.showError(ioException);
				return;
			}
			AddWindowPanel.syncCheckBoxes(this.checkboxesPanel, FileManager.getFolders(), this.checkboxes);
		}
	}
}
