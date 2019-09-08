package edu.stanford.bmir.protege.web.server.index.impl;

import edu.stanford.bmir.protege.web.server.change.OntologyChange;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-08-09
 */
public interface RequiresOntologyChangeNotification {

    void applyChanges(@Nonnull List<OntologyChange> changes);
}
