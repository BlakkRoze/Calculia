package org.blakkroze.calculia.controllers;

import org.blakkroze.calculia.nodes.Node;

public interface OperationSettingsController <T extends Node> {
    void getNode(T node);
}
