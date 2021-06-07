package julia.git;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileTest {

    @Test
    public void fileIsNotDirectory() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        assertFalse(file.isDirectory());
    }

    @Test
    public void possibleToGetContentFromFile() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        assertEquals("test", file.getContent());
    }

    @Test
    public void possibleToGetContentFromEmptyFile() {
        byte[] b = new byte[] {};
        File file = new File(b);
        assertEquals("", file.getContent());
    }

    @Test
    public void possibleToGetHash() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        assertEquals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", file.getHash());
    }

    @Test
    public void possibleToGetHashForEmptyFile() {
        byte[] b = new byte[] {};
        File file = new File(b);
        assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", file.getHash());
    }
}