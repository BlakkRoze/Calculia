package org.blakkroze.calculia.utils;

import org.blakkroze.calculia.nodes.Node;
import org.blakkroze.calculia.nodes.TwoArgNode;
import org.blakkroze.calculia.nodes.SingleArgNode;
import org.blakkroze.calculia.nodes.ValNode;

import java.util.HashSet;
import java.util.Set;

public class CycleDetector {

    public static boolean wouldCreateCycle(Node startingNode, Node argumentNode) {
        if (argumentNode == null) {
            return false;
        }

        if (argumentNode == startingNode) {
            return true;
        }

        Set<Node> visited = new HashSet<>();
        return hasCycle(startingNode, argumentNode, visited);
    }

    private static boolean hasCycle(Node target, Node current, Set<Node> visited) {
        if (current == null || visited.contains(current)) {
            return false;
        }

        if (current == target) {
            return true;
        }

        if (current instanceof ValNode) {
            return false;
        }

        visited.add(current);

        if (current instanceof TwoArgNode twoArgNode) {
            return hasCycle(target, twoArgNode.getLeftArgNode(), visited) ||
                    hasCycle(target, twoArgNode.getRightArgNode(), visited);
        }

        if (current instanceof SingleArgNode singleArgNode) {
            return hasCycle(target, singleArgNode.getArgNode(), visited);
        }

        return false;
    }
}