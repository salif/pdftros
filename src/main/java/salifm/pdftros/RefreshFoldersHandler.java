package salifm.pdftros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

class RefreshFoldersHandler implements ActionListener {

	private JPanel checkboxesPanel;
	private Set<JCheckBox> checkboxes;

	RefreshFoldersHandler(JPanel checkboxesPanel, Set<JCheckBox> checkboxes) {
		this.checkboxesPanel = checkboxesPanel;
		this.checkboxes = checkboxes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AddWindowPanel.syncCheckBoxes(this.checkboxesPanel, FileManager.getFolders(), this.checkboxes);
	}
}
