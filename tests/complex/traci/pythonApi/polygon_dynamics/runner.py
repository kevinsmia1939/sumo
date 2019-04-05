#!/usr/bin/env python
# -*- coding: utf-8 -*-
# Eclipse SUMO, Simulation of Urban MObility; see https://eclipse.org/sumo
# Copyright (C) 2008-2019 German Aerospace Center (DLR) and others.
# This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v20.html
# SPDX-License-Identifier: EPL-2.0

# @file    runner.py
# @author  Michael Behrisch
# @author  Daniel Krajzewicz
# @date    2011-03-04
# @version $Id$


from __future__ import print_function
from __future__ import absolute_import
import os
import sys

SUMO_HOME = os.path.join(os.path.dirname(__file__), "..", "..", "..", "..", "..")
sys.path.append(os.path.join(os.environ.get("SUMO_HOME", SUMO_HOME), "tools"))
if len(sys.argv) > 1:
    import libsumo as traci  # noqa
else:
    import traci  # noqa
import sumolib  # noqa

def examine(polygonID):
    print("examining", polygonID)
    print("shape", traci.polygon.getShape(polygonID))
    print("type", traci.polygon.getType(polygonID))
    print("color", traci.polygon.getColor(polygonID))
    print("filled", traci.polygon.getFilled(polygonID))

traci.start([sumolib.checkBinary('sumo-gui'), "-c", "sumo.sumocfg"])
for step in range(3):
    print("step", step)
    traci.simulationStep()
polygonID = "0"
print("adding", polygonID)
traci.polygon.add(
    polygonID, ((0, 50), (0, 50), (50, 50)), (100, 200, 0, 255), True, "test")

print("polygons", traci.polygon.getIDList())
print("polygon count", traci.polygon.getIDCount())

examine(polygonID)

for step in range(3, 6):
    print("step", step)
    traci.simulationStep()
    
# Add empty polygon dynamics
print ("Adding underspecified dynamics")
traci.polygon.addDynamics(polygonID)

#~ polygonID2 = "poly2"
#~ traci.polygon.add(
    #~ polygonID2, ((1, 1), (1, 10), (10, 10)), (1, 2, 3, 4), True, "test", lineWidth=3)
#~ print("new polygon lineWidth", traci.polygon.getLineWidth(polygonID2))
#~ traci.polygon.setLineWidth(polygonID2, 0.5)
#~ print("lineWidth modified", traci.polygon.getLineWidth(polygonID2))

traci.close()
