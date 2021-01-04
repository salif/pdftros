/*
  Copyright (c) 2021 Salif Mehmed
  This Source Code Form is subject to the terms of the Mozilla Public
  License, v. 2.0. If a copy of the MPL was not distributed with this
  file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/

package salifm.pdftros.ui.mainwindow;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import salifm.pdftros.config.Config;

public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ConfigPanel() {
		super(new GridLayout(0, 1));
		super.setBorder(BorderFactory.createTitledBorder("Config "));
		super.add(new ThemeRow());
		super.add(new ConfigPanelRow("Main dir ", Config.getMainDir(),
			mainDir -> Config.setMainDir(mainDir)));
		super.add(new ConfigPanelRow("All Dir ", Config.getAllDir(),
			allDir -> Config.setAllDir(allDir)));
		super.add(new ConfigPanelRow("Org Dir ", Config.getOrgDir(),
			orgDir -> Config.setOrgDir(orgDir)));
		super.add(new ConfigPanelRow("AddWindow width ", String.valueOf(Config.getAddWindowWidth()),
			addWindowWidth -> Config.setAddWindowWidth(Integer.valueOf(addWindowWidth))));
		super.add(new ConfigPanelRow("AddWindow height ", String.valueOf(Config.getAddWindowHeight()),
			addWindowHeight -> Config.setAddWindowHeight(Integer.valueOf(addWindowHeight))));
		super.add(new ConfigPanelRow("MainWindow width ", String.valueOf(Config.getMainWindowWidth()),
			mainWindowWidth -> Config.setMainWindowWidth(Integer.valueOf(mainWindowWidth))));
		super.add(new ConfigPanelRow("MainWindow height ", String.valueOf(Config.getMainWindowHeight()),
			mainWindowHeight -> Config.setMainWindowHeight(Integer.valueOf(mainWindowHeight))));
	}
}
