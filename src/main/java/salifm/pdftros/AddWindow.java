package salifm.pdftros;

class AddWindow extends Window {

	private static final long serialVersionUID = 8134332380651093722L;

	AddWindow(String[] folders, String pdf) {
		super("Add pdf", 400, 200);
		super.setContentPane(new AddWindowPanel(folders, pdf, super::close));
	}
}
