import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListAnalysisTest {

    private Collection<String> populatedCollection;

    @Before
    public void setUp() {
        populatedCollection = new ArrayList<>();
        for (int i = 0 ; i < 1000 ; i++) populatedCollection.add("String");
        populatedCollection.add("String");
    }

    @Test
    public void whenCalledReturnArrayListAnalysisBigO() {
        ListAnalysis analysis = ListAnalysis.getArrayListAnalysis();
        String bigO = analysis.getBigO();
        String expected = "ArrayList::get - O(1)\n" +
                "ArrayList::add - O(1)\n" +
                "ArrayList::contains - O(n)\n" +
                "ArrayList::remove - O(n)";
        assertEquals("Unexpected big O found", expected, bigO);
    }

    @Test
    public void whenCalledReturnLinkedListAnalysisBigO() {
        ListAnalysis analysis = ListAnalysis.getLinkedListAnalysis();
        String bigO = analysis.getBigO();
        String expected = "ArrayList::get - O(n)\n" +
                "ArrayList::add - O(1)\n" +
                "ArrayList::contains - O(n)\n" +
                "ArrayList::remove - O(1)";
        assertEquals("Unexpected big O found", expected, bigO);
    }

    @Test
    public void whenCalledReturnCopyOnWriteArrayListAnalysisBigO() {
        ListAnalysis analysis = ListAnalysis.getCopyOnWriteArrayListAnalysis();
        String bigO = analysis.getBigO();
        String expected = "ArrayList::get - O(1)\n" +
                "ArrayList::add - O(n)\n" +
                "ArrayList::contains - O(n)\n" +
                "ArrayList::remove - O(n)";
        assertEquals("Unexpected big O found", expected, bigO);
    }

    @Test
    public void whenCalledProduceInsertPerformance() {
        ListAnalysis<String> analysis = ListAnalysis.getArrayListAnalysis();
        long nanos = analysis.runInsert(populatedCollection);
        assertTrue("Running time should be positive: " + nanos,nanos > 0);
    }

    @Test
    public void whenCalledProduceGetPerformance() {
        ListAnalysis<String> analysis = ListAnalysis.getArrayListAnalysis();
        analysis.runInsert(populatedCollection);
        long nanos = analysis.runGet();
        assertTrue("Running time should be positive: " + nanos,nanos > 0);
    }

    @Test
    public void whenCalledProduceContainsPerformance() {
        ListAnalysis<String> analysis = ListAnalysis.getArrayListAnalysis();
        analysis.runInsert(populatedCollection);
        analysis.runContains("Target");
        long nanos = analysis.runGet();
        assertTrue("Running time should be positive: " + nanos,nanos > 0);
    }

    @Test
    public void whenCalledProduceRemovePerformance() {
        ListAnalysis<String> analysis = ListAnalysis.getArrayListAnalysis();
        analysis.runInsert(populatedCollection);
        analysis.runRemove("Target");
        long nanos = analysis.runGet();
        assertTrue("Running time should be positive: " + nanos,nanos > 0);
    }
}
