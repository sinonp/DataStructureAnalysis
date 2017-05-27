package analysis;

import metric.ListMetric;
import metric.Metric;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListAnalysisTest {

    private List<Integer> populatedIntegerList;

    @Before
    public void setUp() {
        populatedIntegerList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) populatedIntegerList.add(i);
    }

    @Test
    public void whenRunProduceListMetric() {
        ListAnalysis<Integer> listAnalysis = ListAnalysis.getArrayListAnalysis();
        Metric metric = listAnalysis.runAnalysis(populatedIntegerList);
        ListMetric listMetric = (ListMetric) metric;
        assertTrue("Add Time Not Populated", listMetric.getAddTime() > 0);
        assertTrue("Contains Time Not Populated", listMetric.getContainsTime() > 0);
        assertTrue("Get Time Not Populated", listMetric.getGetTime() > 0);
        assertTrue("Remove Time Not Populated", listMetric.getRemoveTime() > 0);
    }

    @Test
    public void whenRunProduceArrayListMetric() {
        ListAnalysis<Integer> listAnalysis = ListAnalysis.getArrayListAnalysis();
        Metric metric = listAnalysis.runAnalysis(populatedIntegerList);
        ListMetric listMetric = (ListMetric) metric;
        assertEquals("ArrayListMetric", listMetric.getMetricName());
    }

    @Test
    public void whenRunProduceLinkedListMetric() {
        ListAnalysis<Integer> listAnalysis = ListAnalysis.getLinkedListAnalysis();
        Metric metric = listAnalysis.runAnalysis(populatedIntegerList);
        ListMetric listMetric = (ListMetric) metric;
        assertEquals("LinkedListMetric", listMetric.getMetricName());
    }

    @Test
    public void whenRunProduceCopyOnWriteArrayListMetric() {
        ListAnalysis<Integer> listAnalysis = ListAnalysis.getCopyOnWriteArrayListAnalysis();
        Metric metric = listAnalysis.runAnalysis(populatedIntegerList);
        ListMetric listMetric = (ListMetric) metric;
        assertEquals("CopyOnWriteArrayList", listMetric.getMetricName());
    }
}
