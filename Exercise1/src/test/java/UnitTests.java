import org.example.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UnitTests {
    @Test
    public void testPrimeNumber() {
        assertEquals(3, Main.findNthPrime(2));
        assertEquals(2, Main.findNthPrime(1));
        assertEquals(8377, Main.findNthPrime(1049));
        assertEquals(53, Main.findNthPrime(16));

    }

    @Test
    public void testFindSubStringWords() {
        String searchString = "EXE";
        List<String> words = Arrays.asList("EXECUTABLE", "EXAMPLE", "EXEFILE", "NOTEXECUTABLE");

        List<String> expected = Arrays.asList("EXECUTABLE", "EXEFILE", "NOTEXECUTABLE");
        List<String> actual = Main.findSubStringWords(searchString, words);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindSubStringWordsNoMatch() {
        String searchString = "EXE";
        List<String> words = Arrays.asList("testing", "test", "example", "testcase", "unit test");

        List<String> expected = Arrays.asList();
        List<String> actual = Main.findSubStringWords(searchString, words);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindSubStringWordsEmptyList() {
        String searchString = "EXE";
        List<String> words = Arrays.asList();

        List<String> expected = Arrays.asList();
        List<String> actual = Main.findSubStringWords(searchString, words);

        assertEquals(expected, actual);
    }

}
