package salifm.pdftros;

import javax.swing.*;

abstract class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	Window(String title, int width, int height) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setSize(width, height);
		super.setLocationRelativeTo(null);
	}

	void start() {
		super.setVisible(true);
	}

	void close(Void unused) {
		super.dispose();
	}
}
