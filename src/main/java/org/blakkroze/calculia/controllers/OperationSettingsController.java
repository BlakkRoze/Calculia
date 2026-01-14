package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.containers.NodeContainer;
import org.blakkroze.calculia.nodes.Node;

public interface OperationSettingsController <T extends Node> {
    void setContainer(NodeContainer container);
    boolean fillNode(T node);
}
