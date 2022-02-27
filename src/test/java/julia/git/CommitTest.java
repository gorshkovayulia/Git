package julia.git;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommitTest {

    @Test
    public void possibleToCreateFirstCommit() {
        byte[] b = new byte[]{116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        Commit commit = new Commit(directory.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        assertEquals("tree d6e6647059d41c471ebe5ede49872da381fbf93e\n" +
                "Author:gorshkova_julia\n" +
                "Date:Tue Apr 27 22:32:35 2021 +0300\n" +
                "\n" +
                "     Test", commit.getContent());
    }

    @Test
    public void possibleToCreateSecondCommit() {
        byte[] b = new byte[]{116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        Commit commit = new Commit(directory.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Commit commit2 = new Commit(directory.getHash(), commit.getHash(), "Test2", "gorshkova_julia", "Tue Apr 27 22:33:35 2021 +0300");
        assertEquals("tree d6e6647059d41c471ebe5ede49872da381fbf93e\n" +
                "parent 932af51418307f9edf6387a183cebc8735c34c3e\n" +
                "Author:gorshkova_julia\n" +
                "Date:Tue Apr 27 22:33:35 2021 +0300\n" +
                "\n" +
                "     Test2", commit2.getContent());
    }

    @Test
    public void possibleToGetHashOfCommit() {
        byte[] b = new byte[]{116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        Commit commit = new Commit(directory.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        assertEquals("932af51418307f9edf6387a183cebc8735c34c3e", commit.getHash());
    }

    @Test
    public void hashOfCommitIsChangedWhenParentIsChanged() {
        byte[] b = new byte[]{116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        Commit commit = new Commit(directory.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Commit commit2 = new Commit(directory.getHash(), commit.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        assertNotEquals(commit.getHash(), commit2.getHash());
    }

    @Test
    public void hashOfCommitIsChangedWhenMessageIsChanged() {
        byte[] b = new byte[]{116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        Commit commit = new Commit(directory.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Commit commit2 = new Commit(directory.getHash(), commit.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Commit commit3 = new Commit(directory.getHash(), commit.getHash(),"Testik", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        assertNotEquals(commit2.getHash(), commit3.getHash());
    }

    @Test
    public void hashOfCommitIsChangedWhenAuthorIsChanged() {
        byte[] b = new byte[]{116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        Commit commit = new Commit(directory.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Commit commit2 = new Commit(directory.getHash(), commit.getHash(),"Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Commit commit3 = new Commit(directory.getHash(), commit.getHash(),"Test", "ivanov_ivan", "Tue Apr 27 22:32:35 2021 +0300");
        assertNotEquals(commit2.getHash(), commit3.getHash());
    }

    @Test
    public void hashOfCommitIsChangedWhenDateIsChanged() {
        byte[] b = new byte[]{116, 101, 115, 116};
        File file = new File(b);
        Directory directory = new Directory();
        directory.add("Tester", file);
        Commit commit = new Commit(directory.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Commit commit2 = new Commit(directory.getHash(), commit.getHash(), "Test", "gorshkova_julia", "Tue Apr 27 22:32:35 2021 +0300");
        Commit commit3 = new Commit(directory.getHash(), commit.getHash(), "Test", "gorshkova_julia", "Tue Apr 28 22:32:35 2021 +0300");
        assertNotEquals(commit2.getHash(), commit3.getHash());
    }
}
