/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.config;

import java.nio.file.Path;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Config {
	private static final Preferences preferences = Preferences.userRoot().node("salifm/pdftros/config/Config");
	private static final String DEFAULT_LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static String userHome;
	private static String lookAndFeel;
	private static String mainDir;
	private static String allDir;
	private static String orgDir;

	public static void sync() {
		userHome = System.getProperty("user.home");
		lookAndFeel = preferences.get("lookAndFeel", DEFAULT_LOOK_AND_FEEL);
		mainDir = preferences.get("mainDir", "pdfs");
		allDir = preferences.get("allDir", "all");
		orgDir = preferences.get("orgDir", "organized");
	}

	public static String getLookAndFeel() {
		return lookAndFeel;
	}

	public static void setLookAndFeel(String lookAndFeel) {
		preferences.put("lookAndFeel", lookAndFeel);
	}

	public static String getMainDir() {
		return Path.of(userHome, mainDir).toString();
	}

	public static void setMainDir(String mainDir) {
		preferences.put("mainDir", mainDir);
	}

	public static String getAllDir() {
		return allDir;
	}

	public static void setAllDir(String allDir) {
		preferences.put("allDir", allDir);
	}

	public static String getOrgDir() {
		return orgDir;
	}

	public static void setOrgDir(String orgDir) {
		preferences.put("orgDir", orgDir);
	}

	public static void flush() throws BackingStoreException {
		preferences.flush();
	}
}
