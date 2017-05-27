package metric;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SetMetricTest {
    
    @Before
    public void setUp() { }

    @Test
    public void whenCalledProduceAverageMetric() {
        Metric metric1 = new SetMetric("testSetMetric", 12000, 13000, 15000);
        SetMetric metric2 = new SetMetric("testSetMetric", 15000, 15000, 15000);
        Metric averageMetric = new SetMetric("testSetMetric", 13500, 14000, 15000);
        assertEquals(averageMetric, metric1.average(metric2));
    }

    @Test
    public void testEquality() {
        Metric metric = new SetMetric("testSetMetric", 12000, 13000, 14000);
        Metric metricDifferentTimes = new SetMetric("testSetMetric", 15000, 15000, 15000);
        Metric metricSameValues = new SetMetric("testSetMetric", 12000, 13000, 14000);
        Metric metricDifferentName = new SetMetric("testSetMetric2", 12000, 13000, 14000);
        assertEquals(metric, metricSameValues);
        assertNotEquals(metric, metricDifferentTimes);
        assertNotEquals(metric, metricDifferentName);
    }
}
