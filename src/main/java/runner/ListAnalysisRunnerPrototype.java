package runner;

import analysis.ListAnalysis;
import metric.Metric;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListAnalysisRunnerPrototype {

    private static <T> void runListAnalysisTest(List<T> list) {

        ArrayList<Metric> arrayListAnalysisList = new ArrayList<>();
        ArrayList<Metric> linkedListAnalysisList = new ArrayList<>();
        ArrayList<Metric> copyOnWriteArrayListAnalysisList = new ArrayList<>();

        runListAnalysis(list, arrayListAnalysisList, linkedListAnalysisList, copyOnWriteArrayListAnalysisList);

        Optional<Metric> arrayListAnalysisAverage = arrayListAnalysisList.stream()
                .reduce(Metric::average);
        Optional<Metric> linkedListAnalysisAverage = linkedListAnalysisList.stream()
                .reduce(Metric::average);
        Optional<Metric> copyOnWriteArrayListAnalysisAverage = copyOnWriteArrayListAnalysisList.stream()
                .reduce(Metric::average);

        System.out.println(arrayListAnalysisAverage);
        System.out.println(linkedListAnalysisAverage);
        System.out.println(copyOnWriteArrayListAnalysisAverage);
    }

    private static <T> void runListAnalysis(List<T> list, ArrayList<Metric> arrayListAnalysisList, ArrayList<Metric> linkedListAnalysisList, ArrayList<Metric> copyOnWriteArrayListAnalysisList) {
        for (int i = 0; i < 1_000; i++) {
            arrayListAnalysisList.add(ListAnalysis.<T>getArrayListAnalysis().runAnalysis(list));
            linkedListAnalysisList.add(ListAnalysis.<T>getLinkedListAnalysis().runAnalysis(list));
            copyOnWriteArrayListAnalysisList.add(ListAnalysis.<T>getCopyOnWriteArrayListAnalysis().runAnalysis(list));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) integerList.add(i);
        ListAnalysisRunnerPrototype.runListAnalysisTest(integerList);
    }
}
