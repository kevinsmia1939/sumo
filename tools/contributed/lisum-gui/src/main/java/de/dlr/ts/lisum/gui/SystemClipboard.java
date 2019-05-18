/****************************************************************************/
// Eclipse SUMO, Simulation of Urban MObility; see https://eclipse.org/sumo
// Copyright (C) 2016-2019 German Aerospace Center (DLR) and others.
// This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v2.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v20.html
// SPDX-License-Identifier: EPL-2.0
/****************************************************************************/
/// @file    SystemClipboard.java
/// @author  Maximiliano Bottazzi
/// @date    2016
/// @version $Id$
///
//
/****************************************************************************/
package de.dlr.ts.lisum.gui;

import javafx.scene.input.Clipboard;


/**
 *
 * @author @author <a href="mailto:maximiliano.bottazzi@dlr.de">Maximiliano Bottazzi</a>
 */
public class SystemClipboard {
    private static final SystemClipboard INSTANCE = new SystemClipboard();
    private final Clipboard clipboard = Clipboard.getSystemClipboard();


    /**
     *
     * @return
     */
    public static SystemClipboard getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @return
     */
    public Clipboard getClipboard() {
        return clipboard;
    }

    /**
     *
     */
    public SystemClipboard() {
    }
}
