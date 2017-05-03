package runner;

import analysis.ListAnalysis;
import metric.Metric;

import java.util.*;

public class ListAnalysisRunner {

    public static <T> Collection<Metric> runListAnalysis(List<T> list) {

        ArrayList<Metric> arrayListAnalysisList = new ArrayList<>();
        ArrayList<Metric> linkedListAnalysisList = new ArrayList<>();
        ArrayList<Metric> copyOnWriteArrayListAnalysisList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            arrayListAnalysisList.add(ListAnalysis.<T>getArrayListAnalysis().runAnalysis(list));
            linkedListAnalysisList.add(ListAnalysis.<T>getLinkedListAnalysis().runAnalysis(list));
            copyOnWriteArrayListAnalysisList.add(ListAnalysis.<T>getCopyOnWriteArrayListAnalysis().runAnalysis(list));
        }

        Optional<Metric> arrayListAnalysisAverage = arrayListAnalysisList.stream()
                .reduce(Metric::average);
        Optional<Metric> linkedListAnalysisAverage = linkedListAnalysisList.stream()
                .reduce(Metric::average);
        Optional<Metric> copyOnWriteArrayListAnalysisAverage = copyOnWriteArrayListAnalysisList.stream()
                .reduce(Metric::average);

        ArrayList<Metric> returnList = new ArrayList<>();

        arrayListAnalysisAverage.ifPresent(returnList::add);
        linkedListAnalysisAverage.ifPresent(returnList::add);
        copyOnWriteArrayListAnalysisAverage.ifPresent(returnList::add);

        return returnList;
    }



    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) integerList.add(i);
        ListAnalysisRunner.runListAnalysis(integerList);
    }
}
