package julia.git;

import java.util.LinkedList;
import java.util.List;

public class Commit implements Listable {
    LinkedList list = new LinkedList();
    String tree; // SHA1 of tree object
    String parent; // SHA1 of previous commits or root commit if it's the first commit in the project
    String message; // Comment describing the changes
    String author; // The name of person responsible for changes
    String committer; // The name of person who created the commit
    String date;

    Commit(String message, String author, String committer, String date) {
        this.message = message;
        this.author = author;
        this.committer = committer;
        this.date = date;
    }

    @Override
    public List<String> list() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public Listable get(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public String getHash() {
        return Listable.super.getHash();
    }
}
