package analysis;

import metric.Metric;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ListAnalysisTest {

    private List<String> populatedCollection;

    @Before
    public void setUp() {
        populatedCollection = new ArrayList<>();
        for (int i = 0; i < 1000; i++) populatedCollection.add("String");
        populatedCollection.add("String");
    }

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
        ListAnalysis<String> arrayListAnalysis = ListAnalysis.getArrayListAnalysis();
        Metric metric = arrayListAnalysis.runAnalysis(populatedCollection);
        assertTrue("Should produce a metric!", metric != null);
    }
}
