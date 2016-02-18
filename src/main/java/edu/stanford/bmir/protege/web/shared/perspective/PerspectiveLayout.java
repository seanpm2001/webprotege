package edu.stanford.bmir.protege.web.shared.perspective;

import com.google.common.base.Objects;
import com.google.gwt.user.client.rpc.IsSerializable;
import edu.stanford.protege.widgetmap.shared.node.Node;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 17/02/16
 */
public class PerspectiveLayout implements IsSerializable, HasPerspectiveId {

    private PerspectiveId perspectiveId;

    private Node rootNode;


    /**
     * For serialization purposes only
     */
    private PerspectiveLayout() {
    }

    public PerspectiveLayout(PerspectiveId perspectiveId, Node rootNode) {
        this.perspectiveId = checkNotNull(perspectiveId);
        this.rootNode = checkNotNull(rootNode).duplicate();
    }

    @Override
    public PerspectiveId getPerspectiveId() {
        return perspectiveId;
    }

    /**
     * Gets the root node for the perspect.
     * @return The root node.  Not {@code null}.  Note that this is a copy.  Modifying the returned node will not
     * alter the underlying node for this layout.
     */
    public Node getRootNode() {
        return rootNode.duplicate();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(perspectiveId, rootNode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PerspectiveLayout)) {
            return false;
        }
        PerspectiveLayout other = (PerspectiveLayout) obj;
        return this.perspectiveId.equals(other.perspectiveId)
                && this.rootNode.equals(other.rootNode);
    }


    @Override
    public String toString() {
        return toStringHelper("PerspectiveLayout")
                .addValue(perspectiveId)
                .addValue(rootNode)
                .toString();
    }
}
