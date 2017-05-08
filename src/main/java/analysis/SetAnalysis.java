package analysis;

import metric.Metric;
import metric.SetMetric;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetAnalysis<E> implements Analysis<E> {

    private SetMetric metric;

    private Set<E> set;

    private SetAnalysis() {
    }

    public static <E> SetAnalysis<E> getHashSetAnalysis() {
        SetAnalysis<E> setAnalysis = new SetAnalysis<>();
        setAnalysis.metric = new SetMetric("HashSetMetric");
        setAnalysis.set = new HashSet<>();
        return setAnalysis;
    }

    public static <E> SetAnalysis<E> getLinkedHashSetAnalysis() {
        SetAnalysis<E> setAnalysis = new SetAnalysis<>();
        setAnalysis.metric = new SetMetric("LinkedHashSetMetric");
        setAnalysis.set = new LinkedHashSet<>();
        return setAnalysis;
    }

    //TODO: Officially decide not to use EnumSet
//    public static <E> SetAnalysis<E> getEnumSetAnalysis() {
//        SetAnalysis<E> setAnalysis = new SetAnalysis<>();
//        setAnalysis.metric = new SetMetric("EnumSetMetric");
//        setAnalysis.set = new EnumSet<>();
//        return setAnalysis;
//    }

    public static <E> SetAnalysis<E> getTreeSetAnalysis() {
        SetAnalysis<E> setAnalysis = new SetAnalysis<>();
        setAnalysis.metric = new SetMetric("TreeSetMetric");
        setAnalysis.set = new TreeSet<>();
        return setAnalysis;
    }

    public static <E> SetAnalysis<E> getCopyOnWriteArraySetAnalysis() {
        SetAnalysis<E> setAnalysis = new SetAnalysis<>();
        setAnalysis.metric = new SetMetric("CopyOnWriteArraySetMetric");
        setAnalysis.set = new CopyOnWriteArraySet<>();
        return setAnalysis;
    }

    public static <E> SetAnalysis<E> getConcurrentSkipListAnalysis() {
        SetAnalysis<E> setAnalysis = new SetAnalysis<>();
        setAnalysis.metric = new SetMetric("ConcurrentSkipListSetMetric");
        setAnalysis.set = new ConcurrentSkipListSet<>();
        return setAnalysis;
    }

    private void runPopulate(Set<E> objectsToInsert) {
        set.addAll(objectsToInsert);
    }

    private long runAdd(E target) {
        long startTime = System.nanoTime();
        set.contains(target);
        return System.nanoTime() - startTime;
    }

    private long runContains(E target) {
        long startTime = System.nanoTime();
        set.contains(target);
        return System.nanoTime() - startTime;
    }

    private long runNext() {
        Iterator<E> iterator = set.iterator();
        long startTime = System.nanoTime();
        iterator.next();
        return System.nanoTime() - startTime;
    }

    @Override
    public Metric runAnalysis(Set<E> populatedSet) {
        //TODO: Need to retrieve actual random element.
        E randomElement = null;
        for (E element : populatedSet) {
            randomElement = element;
            break;
        }
        runPopulate(populatedSet);
        metric.setAddTime(runAdd(randomElement));
        metric.setContainsTime(runContains(randomElement));
        metric.setNextTime(runNext());
        return metric;
    }
}
