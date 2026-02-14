package business;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dal.TFIDFCalculator;

public class TFIDFTests {

    private TFIDFCalculator calculator;

    @Before
    public void setUp() {
        calculator = new TFIDFCalculator();
    }

    @Test
    public void testTFIDFPositivePath() {
        // Known corpus (Arabic text)
        // Doc 1: "برنامج اختبار"
        // Doc 2: "برنامج كود"
        calculator.addDocumentToCorpus("برنامج اختبار");
        calculator.addDocumentToCorpus("برنامج كود");

        // Target document
        String document = "برنامج اختبار";

        // Manual Calculation:
        // Tokens: ["برنامج", "اختبار"] (size 2)
        // TF("برنامج") = 1/2 = 0.5, TF("اختبار") = 1/2 = 0.5
        // DF("برنامج") = 2, DF("اختبار") = 1
        // IDF("برنامج"): log(2 / (1 + 2)) = -0.405465
        // IDF("اختبار"): log(2 / (1 + 1)) = 0.0
        // Result = ((0.5 * -0.405465) + (0.5 * 0.0)) / 2 ≈ -0.101366

        double expectedScore = -0.101366;
        double actualScore = calculator.calculateDocumentTfIdf(document);

        assertEquals("TF-IDF score should match manual calculation within tolerance", expectedScore, actualScore, 0.01);
    }

    @Test
    public void testTFIDFEmptyDocument() {
        // Negative Path: Empty string after preprocessing results in empty word list
        // and division by zero (NaN)
        double score = calculator.calculateDocumentTfIdf("");
        assertTrue("TF-IDF for empty document should return NaN or 0.0 in current implementation",
                Double.isNaN(score) || score == 0.0);
    }

    @Test
    public void testTFIDFSpecialCharacters() {
        // Negative Path: Only special characters are removed by PreProcessText,
        // resulting in NaN
        double score = calculator.calculateDocumentTfIdf("!@#$%^&*()");
        assertTrue("TF-IDF for non-Arabic chars should be handled gracefully (NaN in this implementation)",
                Double.isNaN(score) || score == 0.0);
    }
}
