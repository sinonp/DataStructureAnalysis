package analysis;

import metric.ListMetric;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListAnalysis<E> {

    private List<E> list;

    private ListMetric metric;

    private ListAnalysis() {}

    public static <E> ListAnalysis<E> getArrayListAnalysis() {
        ListAnalysis<E> listAnalysis = new ListAnalysis<>();
        listAnalysis.list = new ArrayList<>();
        listAnalysis.metric = new ListMetric("ArrayListMetric");
        return listAnalysis;
    }

    public static <E> ListAnalysis<E> getLinkedListAnalysis() {
        ListAnalysis<E> listAnalysis = new ListAnalysis<>();
        listAnalysis.list = new LinkedList<>();
        listAnalysis.metric = new ListMetric("LinkedListMetric");
        return listAnalysis;
    }

    public static <E> ListAnalysis<E> getCopyOnWriteArrayListAnalysis() {
        ListAnalysis<E> listAnalysis = new ListAnalysis<>();
        listAnalysis.list = new CopyOnWriteArrayList<>();
        listAnalysis.metric = new ListMetric("CopyOnWriteArrayList");
        return listAnalysis;
    }

    private void runPopulate(List<E> objectsToInsert) {
        list.addAll(objectsToInsert);
    }

    private long runGet(int targetIndex) {
        long startTime = System.nanoTime();
        list.get(targetIndex);
        return System.nanoTime() - startTime;
    }

    private long runContains(E target) {
        long startTime = System.nanoTime();
        list.contains(target);
        return System.nanoTime() - startTime;
    }

    private long runRemove(E target) {
        long startTime = System.nanoTime();
        list.remove(target);
        return System.nanoTime() - startTime;
    }

    private long runAdd(E target) {
        long startTime = System.nanoTime();
        list.add(target);
        return System.nanoTime() - startTime;
    }

    public ListMetric runAnalysis(List<E> list) {
        int randomIndex = (int) (Math.random() * list.size());

        runPopulate(list);
        metric.setGetTime(runGet(randomIndex));

        E targetObject = this.list.get(randomIndex);

        metric.setContainsTime(runContains(targetObject));
        metric.setRemoveTime(runRemove(targetObject));
        metric.setAddTime(runAdd(targetObject));

        return metric;
    }
}
