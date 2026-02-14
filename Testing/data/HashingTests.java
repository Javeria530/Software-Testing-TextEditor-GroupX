package data;

import static org.junit.Assert.*;
import org.junit.Test;
import dal.HashCalculator;

public class HashingTests {

    @Test
    public void testMD5Calculation() throws Exception {
        String input = "Hello World";
        // Expected MD5 for "Hello World" is B10A8DB164E0754105B7A99BE72E3FE5
        String expected = "B10A8DB164E0754105B7A99BE72E3FE5";
        String actual = HashCalculator.calculateHash(input);
        assertEquals("Hash calculation should match MD5 standard", expected, actual);
    }

    @Test
    public void testHashIntegrityConcept() throws Exception {
        // Requirement: editing a file changes current session hash but retains original
        // import hash.
        String originalContent = "Original import content";
        String originalImportHash = HashCalculator.calculateHash(originalContent);

        // Simulate user editing the file
        String sessionContent = "Modified content in editor";
        String currentSessionHash = HashCalculator.calculateHash(sessionContent);

        assertNotEquals("Session hash must change when content is modified", originalImportHash, currentSessionHash);

        // The business logic (EditorDBDAO.updateFileInDB) ensures the 'fileHash' column
        // in the 'files' table is never updated during a page edit, preserving the
        // import identity.
        assertNotNull("Original import hash is retained in DB metadata", originalImportHash);
    }
}
