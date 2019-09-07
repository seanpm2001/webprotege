package edu.stanford.bmir.protege.web.server.index.impl;

import edu.stanford.bmir.protege.web.server.change.OntologyChange;
import edu.stanford.bmir.protege.web.server.index.impl.IndexUpdater;
import edu.stanford.bmir.protege.web.server.index.impl.RequiresOntologyChangeNotification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-08-09
 */
@RunWith(MockitoJUnitRunner.class)
public class IndexUpdate_TestCase {

    private IndexUpdater indexUpdater;

    @Mock
    private RequiresOntologyChangeNotification index;

    @Mock
    private OntologyChange ontologyChange;

    @Before
    public void setUp() {
        indexUpdater = new IndexUpdater();
    }

    @Test
    public void shouldShouldNotAddMultipleListeners() {
        indexUpdater.registerIndex(index);
        indexUpdater.registerIndex(index);
        var changes = Collections.singletonList(ontologyChange);
        indexUpdater.propagateOntologyChanges(changes);
        verify(index, times(1)).handleOntologyChanges(changes);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNpeIfIndexIsNull() {
        indexUpdater.registerIndex(null);
    }
}