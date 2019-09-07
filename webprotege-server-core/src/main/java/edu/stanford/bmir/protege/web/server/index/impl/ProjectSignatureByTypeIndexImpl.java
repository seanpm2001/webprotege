package edu.stanford.bmir.protege.web.server.index.impl;

import edu.stanford.bmir.protege.web.server.index.ProjectSignatureByTypeIndex;
import org.semanticweb.owlapi.model.EntityType;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-08-16
 */
public class ProjectSignatureByTypeIndexImpl implements ProjectSignatureByTypeIndex {

    @Nonnull
    private final AxiomsByEntityReferenceIndexImpl delegate;

    @Inject
    public ProjectSignatureByTypeIndexImpl(@Nonnull AxiomsByEntityReferenceIndexImpl axiomsByEntityReferenceIndex) {
        this.delegate = checkNotNull(axiomsByEntityReferenceIndex);
    }

    @Nonnull
    @Override
    public <E extends OWLEntity> Stream<E> getSignature(@Nonnull EntityType<E> entityType) {
        checkNotNull(entityType);
        return delegate.getProjectAxiomsSignature(entityType);
    }
}