/****************************************************************************/
// Eclipse SUMO, Simulation of Urban MObility; see https://eclipse.org/sumo
// Copyright (C) 2016-2019 German Aerospace Center (DLR) and others.
// This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v2.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v20.html
// SPDX-License-Identifier: EPL-2.0
/****************************************************************************/
/// @file    LisumAboutWindow.java
/// @author  Maximiliano Bottazzi
/// @date    2016
/// @version $Id$
///
//
/****************************************************************************/
package de.dlr.ts.lisum.gui.misc;

import de.dlr.ts.commons.javafx.windows.AboutWindow;
import de.dlr.ts.lisum.gui.SystemProperties;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

/**
 *
 * @author @author <a href="mailto:maximiliano.bottazzi@dlr.de">Maximiliano Bottazzi</a>
 */
public final class LisumAboutWindow {
    private final AboutWindow win;

    /**
     *
     * @param owner
     */
    public LisumAboutWindow(Window owner) {
        ImageView iv = new ImageView(SystemProperties.getInstance().getMainIcon());
        iv.setScaleX(.8);
        iv.setScaleY(.8);

        win = new AboutWindow(owner);
        win.setIcon(iv);
        win.setSystemNameString(SystemProperties.getInstance().getSystemName());
        win.setCopyright("\u00A92017 DLR Institute of Transportation Systems");

        StringBuilder sb = new StringBuilder();
        sb.append("Product Version").append("\n");
        sb.append(SystemProperties.getInstance().getSystemName()).append("\n").append("\n");

        sb.append("Contact: Maximiliano Bottazzi (maximiliano.bottazi@dlr.de)").append("\n");

        win.setLicense(sb.toString());
    }

    /**
     *
     */
    public void show() {
        win.show();
    }
}
