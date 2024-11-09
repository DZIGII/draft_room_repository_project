package raf.draft.dsw.model.factories;

import raf.draft.dsw.model.nodes.DraftNode;

public interface DraftNodeFactory {
    DraftNode createNode(DraftNode parent);
}
