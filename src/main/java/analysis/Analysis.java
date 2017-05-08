package analysis;

import metric.Metric;

import java.util.Set;

public interface Analysis<E> {
    Metric runAnalysis(Set<E> populatedSet);
}
