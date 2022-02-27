package julia.git;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectsTest {

    @Test
    public void possibleToAddDirectoryIntoObjects() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        Objects objects = new Objects();
        objects.add(directory);
        assertEquals(directory, objects.get("d6e6647059d41c471ebe5ede49872da381fbf93e"));
    }

    @Test
    public void possibleToAddFileIntoObjects() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Objects objects = new Objects();
        objects.add(file);
        assertEquals(file, objects.get("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3"));
    }

    @Test
    public void possibleToAddCommitIntoObjects() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Commit commit = new Commit(file.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Objects objects = new Objects();
        objects.add(commit);
        assertEquals(commit, objects.get("9471e2f1f8a457d490cc31e361bab736ad530a01"));
    }

    @Test
    public void impossibleToGetNotExistingObject() {
        byte[] b = new byte[] {116, 101, 115, 116};
        File file = new File(b);
        Objects objects = new Objects();
        objects.add(file);
        Exception e = assertThrows(IllegalArgumentException.class, () -> objects.get("e6e6647059d41c471ebe5ede49872da381fbf93e"));
        assertEquals("GitObject with such hash does not exist!", e.getMessage());
    }
}