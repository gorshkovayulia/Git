package julia.git;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class DirectoryTest {

    @Test
    public void possibleToAddFileIntoDirectory() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        assertEquals("blob a94a8fe5ccb19ba61c4c0873d391e987982fbbd3    Tester", directory.getContent());
    }

    @Test
    public void possibleToAddNotEmptyDirectoryIntoDirectory() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        Directory directory2 = new Directory();
        directory2.add("Tester", file);
        directory.add("Directory", directory2);
        assertEquals("tree d6e6647059d41c471ebe5ede49872da381fbf93e    Directory", directory.getContent());
    }

    @Test
    public void possibleToAddFileAndDirectoryIntoDirectory() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        Directory directory2 = new Directory();
        directory2.add("Tester", file);
        directory.add("Tester", file);
        directory.add("Directory", directory2);
        assertEquals("blob a94a8fe5ccb19ba61c4c0873d391e987982fbbd3    Tester" + "\n" +
                "tree d6e6647059d41c471ebe5ede49872da381fbf93e    Directory", directory.getContent());
    }

    @Test
    public void impossibleToAddFileWithNullNameIntoDirectory() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        Exception e = assertThrows(IllegalArgumentException.class, () -> directory.add(null, file));
        assertEquals("File name cannot be null or empty!", e.getMessage());
    }

    @Test
    public void impossibleToAddFileWithEmptyNameIntoDirectory() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        Exception e = assertThrows(IllegalArgumentException.class, () -> directory.add("", file));
        assertEquals("File name cannot be null or empty!", e.getMessage());
    }

    @Test
    public void impossibleToAddFileIntoDirectoryIfFileNameContainsOnlySpaces() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        Exception e = assertThrows(IllegalArgumentException.class, () -> directory.add("  ", file));
        assertEquals("File name cannot be null or empty!", e.getMessage());
    }

    @Test
    public void possibleToGetListWithKeys() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        Directory directory2 = new Directory();
        directory.add("Tester", file);
        directory.add("Directory2", directory2);
        ArrayList <String> list = new ArrayList<>();
        list.add("Directory2");
        list.add("Tester");
        assertEquals(list, directory.list());
    }

    @Test
    public void possibleToGetFileObject() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        assertEquals(file, directory.get("Tester"));
    }

    @Test
    public void possibleToGetDirectoryObject() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        Directory directory2 = new Directory();
        directory2.add("Tester", file);
        directory.add("Directory2", directory2);
        assertEquals(directory2, directory.get("Directory2"));
    }

    @Test
    public void directoryIsDirectory() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        assertTrue(directory.isDirectory());
    }

    @Test
    public void impossibleToGetContentIfDirectoryIsEmpty() {
        Directory directory = new Directory();
        Exception e = assertThrows(IllegalStateException.class, directory::getContent);
        assertEquals("Directory is empty!", e.getMessage());
    }

    @Test
    public void possibleToGetHashForNotEmptyDirectory() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        assertEquals("d6e6647059d41c471ebe5ede49872da381fbf93e", directory.getHash());
    }
}