package salifm.pdftros;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

class AddWindowPanel extends JPanel {

	private static final long serialVersionUID = -5321973884809182673L;

	AddWindowPanel(String[] folders, String pdf, Consumer<Void> closeCallback) {
		super(new BorderLayout());

		final File file = new File(pdf);
		final JLabel title = new JLabel(file.getName());
		super.add(title, BorderLayout.NORTH);

		final JPanel checkboxesPanel = new JPanel();
		checkboxesPanel.setLayout(new BoxLayout(checkboxesPanel, BoxLayout.Y_AXIS));
		final Set<JCheckBox> checkboxes = new HashSet<>();
		syncCheckBoxes(checkboxesPanel, folders, checkboxes);
		super.add(new JScrollPane(checkboxesPanel), BorderLayout.CENTER);

		final JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));

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

	static void syncCheckBoxes(JPanel checkboxesPanel, String[] folders, Set<JCheckBox> checkboxes) {
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

