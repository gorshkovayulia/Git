package julia.git;

public class Commit implements GitObject {
    private final String tree; // SHA1 of tree object
    private String parent; // SHA1 of previous commits or root commit if it's the first commit in the project
    private final String message; // Comment describing the changes
    private final String author; // The name of person responsible for changes
    private final String date; // The date of commit creation

    Commit(String tree, String parent, String message, String author, String date) {
        this.tree = tree;
        this.parent = parent;
        this.message = message;
        this.author = author;
        this.date = date;
    }

    Commit(String tree, String message, String author, String date) {
        this.tree = tree;
        this.message = message;
        this.author = author;
        this.date = date;
    }

    @Override
    public String getContent() {
        StringBuilder builder = new StringBuilder();
        builder.append("tree ").append(tree).append("\n").
                append("Author:").append(author).append("\n").
                append("Date:").append(date).append("\n").
                append("\n").append("     ").append(message);
        if (parent != null) {
            builder.insert(46, "parent " + parent + "\n");
        }
        return builder.toString();
    }
}
