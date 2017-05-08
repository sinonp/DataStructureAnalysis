package metric;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ListMetricTest {

    @Before
    public void setUp() {

    }

    @Test
    public void whenCalledProduceAverageMetric() {
        Metric metric1 = new ListMetric("testMetric", 12000, 13000, 14000, 15000);
        ListMetric metric2 = new ListMetric("testMetric", 15000, 15000, 15000, 15000);
        Metric averageMetric = new ListMetric("testMetric", 13500, 14000, 14500, 15000);
        assertEquals(averageMetric, metric1.average(metric2));
    }

    @Test
    public void testEquality() {
        Metric metric = new ListMetric("testMetric", 12000, 13000, 14000, 15000);
        Metric metricDifferentTimes = new ListMetric("testMetric", 15000, 15000, 15000, 15000);
        Metric metricSameValues = new ListMetric("testMetric", 12000, 13000, 14000, 15000);
        Metric metricDifferentName = new ListMetric("testMetric2", 12000, 13000, 14000, 15000);
        assertEquals(metric, metricSameValues);
        assertNotEquals(metric, metricDifferentTimes);
        assertNotEquals(metric, metricDifferentName);
    }
}