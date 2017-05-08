package analysis;

import metric.Metric;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ListAnalysisTest {

    private List<Integer> populatedIntegerCollection;

    @Before
    public void setUp() {
        populatedIntegerCollection = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) populatedIntegerCollection.add(i);
    }

    //TODO: Expand these test cases.
    @Test
    public void getArrayListAnalysis() {
        assertTrue(ListAnalysis.getArrayListAnalysis() != null);
    }

    @Test
    public void getLinkedListAnalysis() {
        assertTrue(ListAnalysis.getLinkedListAnalysis() != null);
    }

    @Test
    public void getCopyOnWriteArrayListAnalysis() {
        assertTrue(ListAnalysis.getCopyOnWriteArrayListAnalysis() != null);
    }

    @Test
    public void whenCalledProduceMetric() {
        ListAnalysis<Integer> arrayListAnalysis = ListAnalysis.getArrayListAnalysis();
        Metric metric = arrayListAnalysis.runAnalysis(populatedIntegerCollection);
        assertTrue("Should produce a metric!", metric != null);
    }
}
