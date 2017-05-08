package analysis;

import metric.Metric;
import metric.SetMetric;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetAnalysisTest {

    private Set<Integer> populatedIntegerSet;

    @Before
    public void setUp() {
        populatedIntegerSet = new HashSet<>();
        for (int i = 0; i < 1000; i++) populatedIntegerSet.add(i);
    }

    @Test
    public void whenRunProduceSetMetric() {
        SetAnalysis<Integer> setAnalysis = SetAnalysis.getHashSetAnalysis();
        Metric metric = setAnalysis.runAnalysis(populatedIntegerSet);
        SetMetric setMetric = (SetMetric) metric;
        assertTrue("Add Time Not Populated", setMetric.getAddTime() > 0);
        assertTrue("Contains Time Not Populated", setMetric.getContainsTime() > 0);
        assertTrue("Next Time Not Populated", setMetric.getNextTime() > 0);
    }
    @Test
    public void whenRunProduceHashSetMetric() {
        SetAnalysis<Integer> setAnalysis = SetAnalysis.getHashSetAnalysis();
        Metric metric = setAnalysis.runAnalysis(populatedIntegerSet);
        SetMetric setMetric = (SetMetric) metric;
        assertEquals("HashSetMetric", setMetric.getMetricName());
    }
    @Test
    public void whenRunProduceLinkedHashSetMetric() {
        SetAnalysis<Integer> setAnalysis = SetAnalysis.getLinkedHashSetAnalysis();
        Metric metric = setAnalysis.runAnalysis(populatedIntegerSet);
        SetMetric setMetric = (SetMetric) metric;
        assertEquals("LinkedHashSetMetric", setMetric.getMetricName());
    }
    @Test
    public void whenRunProduceTreeSetMetric() {
        SetAnalysis<Integer> setAnalysis = SetAnalysis.getTreeSetAnalysis();
        Metric metric = setAnalysis.runAnalysis(populatedIntegerSet);
        SetMetric setMetric = (SetMetric) metric;
        assertEquals("TreeSetMetric", setMetric.getMetricName());
    }
    @Test
    public void whenRunProduceCopyOnWriteArraySetMetric() {
        SetAnalysis<Integer> setAnalysis = SetAnalysis.getCopyOnWriteArraySetAnalysis();
        Metric metric = setAnalysis.runAnalysis(populatedIntegerSet);
        SetMetric setMetric = (SetMetric) metric;
        assertEquals("CopyOnWriteArraySetMetric", setMetric.getMetricName());
    }

    @Test
    public void whenRunProduceConcurrentSkipListSetMetric() {
        SetAnalysis<Integer> setAnalysis = SetAnalysis.getConcurrentSkipListAnalysis();
        Metric metric = setAnalysis.runAnalysis(populatedIntegerSet);
        SetMetric setMetric = (SetMetric) metric;
        assertEquals("ConcurrentSkipListSetMetric", setMetric.getMetricName());
    }

}
