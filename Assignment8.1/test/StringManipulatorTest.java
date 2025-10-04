/**8.1_task2 test:
 * Test class for StringManipulator.
 * This class contains unit tests for each method in the StringManipulator class.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    private final StringManipulator sm = new StringManipulator();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
    }

    @Test
    void testFindLength() {
        assertEquals(5, sm.findLength("Hello"));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", sm.convertToUpperCase("hello"));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("hello", sm.convertToLowerCase("HELLO"));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(sm.containsSubstring("HelloWorld", "World"));
        assertFalse(sm.containsSubstring("HelloWorld", "Java"));
    }
}
