/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.config;

import java.nio.file.Path;

import salifm.pdftros.App;

public class Config {
	private static final String DEFAULT_LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

	private static String lookAndFeel = DEFAULT_LOOK_AND_FEEL;
	private static String mainDir = "pdfs";
	private static String allDir = "all";
	private static String orgDir = "organized";

	public static String getLookAndFeel() {
		return lookAndFeel;
	}

	public static void setLookAndFeel(String lookAndFeel) {
		Config.lookAndFeel = lookAndFeel;
	}

	public static String getMainDir() {
		return Path.of(System.getProperty("user.home"), mainDir).toString();
	}

	public static void setMainDir(String mainDir) {
		Config.mainDir = mainDir;
	}

	public static String getAllDir() {
		return allDir;
	}

	public static void setAllDir(String allDir) {
		Config.allDir = allDir;
	}

	public static String getOrgDir() {
		return orgDir;
	}

	public static void setOrgDir(String orgDir) {
		Config.orgDir = orgDir;
	}

	public static void save() {
		// TODO
		App.showError(new Exception("Not implemented yet!"));
	}
}
