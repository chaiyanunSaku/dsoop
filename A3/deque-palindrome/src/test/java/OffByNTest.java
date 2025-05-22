import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OffByNTest {

    @Test
    public void testOffByN() {
        OffByN offBy5 = new OffByN(5);

        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));

        assertFalse(offBy5.equalChars('f', 'h'));
        assertFalse(offBy5.equalChars('a', 'a'));
        assertFalse(offBy5.equalChars('z', 'a'));
    }
}
