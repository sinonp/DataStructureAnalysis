import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ListAnalysis<E> {

    private List<E> list;

    private String getComplexity;
    private String addComplexity;
    private String containsComplexity;
    private String removeComplexity;

    String getBigO() {
        return "ArrayList::get - " + getComplexity + '\n' +
                "ArrayList::add - " + addComplexity + '\n' +
                "ArrayList::contains - " + containsComplexity + '\n' +
                "ArrayList::remove - " + removeComplexity;
    }

    private ListAnalysis() {}

    public static <E> ListAnalysis<E> getArrayListAnalysis() {
        ListAnalysis<E> listAnalysis = new ListAnalysis<>();
        listAnalysis.list = new ArrayList<>();
        listAnalysis.getComplexity = "O(1)";
        listAnalysis.addComplexity = "O(1)";
        listAnalysis.containsComplexity = "O(n)";
        listAnalysis.removeComplexity = "O(n)";
        return listAnalysis;
    }

    public static <E> ListAnalysis<E> getLinkedListAnalysis() {
        ListAnalysis<E> listAnalysis = new ListAnalysis<>();
        listAnalysis.list = new LinkedList<>();
        listAnalysis.getComplexity = "O(n)";
        listAnalysis.addComplexity = "O(1)";
        listAnalysis.containsComplexity = "O(n)";
        listAnalysis.removeComplexity = "O(1)";
        return listAnalysis;
    }

    public static <E> ListAnalysis<E> getCopyOnWriteArrayListAnalysis() {
        ListAnalysis<E> listAnalysis = new ListAnalysis<>();
        listAnalysis.list = new CopyOnWriteArrayList<>();
        listAnalysis.getComplexity = "O(1)";
        listAnalysis.addComplexity = "O(n)";
        listAnalysis.containsComplexity = "O(n)";
        listAnalysis.removeComplexity = "O(n)";
        return listAnalysis;
    }

    long runInsert(Collection<E> objectsToInsert) {
        long startTime = System.nanoTime();
        list.addAll(objectsToInsert);
        return System.nanoTime() - startTime;
    }

    public long runGet() {
        int targetIndex = (int)Math.random() % list.size();
        long startTime = System.nanoTime();
        list.get(targetIndex);
        return System.nanoTime() - startTime;
    }

    public long runContains(E target) {
        long startTime = System.nanoTime();
        list.contains(target);
        return System.nanoTime() - startTime;
    }

    public long runRemove(E target) {
        long startTime = System.nanoTime();
        list.remove(target);
        return System.nanoTime() - startTime;
    }
}
