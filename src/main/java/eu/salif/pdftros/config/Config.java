/*
  Copyright 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package eu.salif.pdftros.config;

import java.nio.file.Path;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Config {
	private static final Preferences preferences = Preferences.userRoot().node("eu/salif/pdftros/config/Config");
	private static final String DEFAULT_LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static String userHome;
	private static String lookAndFeel;
	private static String mainDir;
	private static String allDir;
	private static String orgDir;
	private static String waitingDir;
	private static int addWindowWidth;
	private static int addWindowHeight;
	private static int mainWindowWidth;
	private static int mainWindowHeight;

	public static void sync() {
		userHome = System.getProperty("user.home");
		lookAndFeel = preferences.get("lookAndFeel", DEFAULT_LOOK_AND_FEEL);
		mainDir = preferences.get("mainDir", "pdfs");
		allDir = preferences.get("allDir", "all");
		orgDir = preferences.get("orgDir", "organized");
		waitingDir = preferences.get("waitingDir", "waiting");
		addWindowWidth = preferences.getInt("addWindowWidth", 500);
		addWindowHeight = preferences.getInt("addWindowHeight", 400);
		mainWindowWidth = preferences.getInt("mainWindowWidth", 512);
		mainWindowHeight = preferences.getInt("mainWindowHeight", 512);
	}

	public static String getLookAndFeel() {
		return lookAndFeel;
	}

	public static void setLookAndFeel(String lookAndFeel) {
		preferences.put("lookAndFeel", lookAndFeel);
	}

	public static Path getFullMainDir() {
		return Path.of(userHome, getMainDir());
	}

	public static String getMainDir() {
		return mainDir;
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

	public static String getWaitingDir() {
		return waitingDir;
	}

	public static void setWaitingDir(String waitingDir) {
		preferences.put("waitingDir", waitingDir);
	}

	public static int getAddWindowWidth() {
		return addWindowWidth;
	}

	public static void setAddWindowWidth(int addWindowWidth) {
		preferences.putInt("addWindowWidth", addWindowWidth);
	}

	public static int getAddWindowHeight() {
		return addWindowHeight;
	}

	public static void setAddWindowHeight(int addWindowHeight) {
		preferences.putInt("addWindowHeight", addWindowHeight);
	}

	public static int getMainWindowWidth() {
		return mainWindowWidth;
	}

	public static void setMainWindowWidth(int mainWindowWidth) {
		preferences.putInt("mainWindowWidth", mainWindowWidth);
	}

	public static int getMainWindowHeight() {
		return mainWindowHeight;
	}

	public static void setMainWindowHeight(int mainWindowHeight) {
		preferences.putInt("mainWindowHeight", mainWindowHeight);
	}

	public static void flush() throws BackingStoreException {
		preferences.flush();
	}
}
