package salifm.pdftros;

import java.nio.file.Path;

class Config {
	private static final String DEFAULT_LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

	private static String lookAndFeel = DEFAULT_LOOK_AND_FEEL;
	private static String mainDir = "pdfs";
	private static String allDir = "all";
	private static String orgDir = "organized";

	static String getLookAndFeel() {
		return lookAndFeel;
	}

	static void setLookAndFeel(String lookAndFeel) {
		Config.lookAndFeel = lookAndFeel;
	}

	static String getMainDir() {
		return Path.of(System.getProperty("user.home"), mainDir).toString();
	}

	static void setMainDir(String mainDir) {
		Config.mainDir = mainDir;
	}

	static String getAllDir() {
		return allDir;
	}

	static void setAllDir(String allDir) {
		Config.allDir = allDir;
	}

	static String getOrgDir() {
		return orgDir;
	}

	static void setOrgDir(String orgDir) {
		Config.orgDir = orgDir;
	}
}
