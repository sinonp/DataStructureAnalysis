package metric;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetricTest {

    @Before
    public void setUp() {

    }

    @Test
    public void whenCalledProduceAverageMetric() {
        Metric metric1 = new Metric(10000, 12000, 13000, 14000, 15000);
        Metric metric2 = new Metric(15000, 15000, 15000, 15000, 15000);
        Metric expectedMetric = new Metric(12500, 13500, 14000, 14500, 15000);
        assertEquals(expectedMetric, metric1.average(metric2));
    }
}