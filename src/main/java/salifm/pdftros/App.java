package salifm.pdftros;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

class App {

	void main(String[] args) {
		try {
			setTheme(Config.getLookAndFeel());
			FileManager.initFolders(
				FileManager.getPath(),
				FileManager.getPath(Config.getAllDir()),
				FileManager.getPath(Config.getOrgDir()));
		} catch (Throwable t) {
			showError(t);
			return;
		}
		if (args.length > 0) {
			this.showAddPdfWindow(args);
		} else {
			// TODO
		}
	}

	private void showAddPdfWindow(String[] args) {
		for (final String arg : args) {
			new AddWindow(FileManager.getFolders(), arg).start();
		}
	}

	static void addPdfs(File pdf, String[] folders) {
		try {
			FileManager.copyFile(pdf.toPath(), FileManager.getPath(Config.getAllDir(), pdf.getName()));
		} catch (IOException e) {
			App.showError(e);
		}
		for (final String folder : folders) {
			try {
				FileManager.createSymbolicLink(
					FileManager.getPath(Config.getOrgDir(), folder, pdf.getName()),
					FileManager.getPath(Config.getAllDir(), pdf.getName()));
			} catch (IOException e) {
				App.showError(e);
				return;
			}
		}
	}

	static void setTheme(String lookAndFeel) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
		UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(lookAndFeel);
	}

	static void showError(Throwable t) {
		t.printStackTrace();
		JOptionPane.showMessageDialog(null, t.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
	}
}
