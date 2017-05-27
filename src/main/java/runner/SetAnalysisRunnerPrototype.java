package runner;

import analysis.SetAnalysis;
import metric.Metric;

import java.util.*;

public class SetAnalysisRunnerPrototype {

    private static <T> void runSetAnalysisTest(Set<T> set) {

        ArrayList<Metric> hashSetAnalysisList = new ArrayList<>();
        ArrayList<Metric> linkedHashSetAnalysisList = new ArrayList<>();
        ArrayList<Metric> treeSetAnalysisList = new ArrayList<>();
        ArrayList<Metric> copyOnWriteArraySetAnalysisList = new ArrayList<>();
        ArrayList<Metric> concurrentSkipSetAnalysisList = new ArrayList<>();

        runSetAnalysis(set, hashSetAnalysisList, linkedHashSetAnalysisList, treeSetAnalysisList,
                copyOnWriteArraySetAnalysisList, concurrentSkipSetAnalysisList);

        Optional<Metric> arraySetAnalysisAverage = hashSetAnalysisList.stream()
                .reduce(Metric::average);
        Optional<Metric> linkedSetAnalysisAverage = linkedHashSetAnalysisList.stream()
                .reduce(Metric::average);
        Optional<Metric> treeSetAnalysisAverage = treeSetAnalysisList.stream()
                .reduce(Metric::average);
        Optional<Metric> copyOnWriteArraySetAnalysisAverage = copyOnWriteArraySetAnalysisList.stream()
                .reduce(Metric::average);
        Optional<Metric> concurrentSkipSetAnalysisAverage = concurrentSkipSetAnalysisList.stream()
                .reduce(Metric::average);

        printResults(arraySetAnalysisAverage.orElseGet(null), linkedSetAnalysisAverage.orElseGet(null),
                treeSetAnalysisAverage.orElseGet(null), copyOnWriteArraySetAnalysisAverage.orElseGet(null),
                concurrentSkipSetAnalysisAverage.orElseGet(null));
    }

    private static void printResults(Metric arraySetAnalysisAverage, Metric linkedSetAnalysisAverage,
                                     Metric treeSetAnalysisAverage, Metric copyOnWriteArraySetAnalysisAverage,
                                     Metric concurrentSkipSetAnalysisAverage) {
        System.out.println(arraySetAnalysisAverage);
        System.out.println(linkedSetAnalysisAverage);
        System.out.println(treeSetAnalysisAverage);
        System.out.println(copyOnWriteArraySetAnalysisAverage);
        System.out.println(concurrentSkipSetAnalysisAverage);
    }

    private static <T> void runSetAnalysis(Set<T> set, ArrayList<Metric> hashSetAnalysisList, ArrayList<Metric> linkedHashSetAnalysisList,
                                           ArrayList<Metric> treeSetAnalysisList, ArrayList<Metric> copyOnWriteArraySetAnalysisList,
                                           ArrayList<Metric> concurrentSkipSetAnalysisList) {
        for (int i = 0; i < 1_000; i++) {
            hashSetAnalysisList.add(SetAnalysis.<T>getHashSetAnalysis().runAnalysis(set));
            linkedHashSetAnalysisList.add(SetAnalysis.<T>getLinkedHashSetAnalysis().runAnalysis(set));
            treeSetAnalysisList.add(SetAnalysis.<T>getTreeSetAnalysis().runAnalysis(set));
            copyOnWriteArraySetAnalysisList.add(SetAnalysis.<T>getCopyOnWriteArraySetAnalysis().runAnalysis(set));
            concurrentSkipSetAnalysisList.add(SetAnalysis.<T>getConcurrentSkipListAnalysis().runAnalysis(set));
        }
    }

    public static void main(String[] args) {
        LinkedHashSet<Integer> integerSet = new LinkedHashSet<>();
        for (int i = 0; i < 1_000_000; i++) integerSet.add(i);
        SetAnalysisRunnerPrototype.runSetAnalysisTest(integerSet);
    }
}
