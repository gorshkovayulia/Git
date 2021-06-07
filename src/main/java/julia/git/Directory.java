package julia.git;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Directory implements Listable {
    private final HashMap<String, Listable> content = new HashMap<>();

    public void add(String name, Listable list) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty!");
        }
        content.put(name, list);
    }

    public List<String> list() {
        return new ArrayList<>(content.keySet());
    }

    public Listable get(String name) {
        return content.get(name);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public String getContent() {
        if (content.isEmpty()) {
//            throw new IllegalStateException("Directory is empty!");
            return "Directory is empty!";
        } else {
            StringBuilder builder = new StringBuilder();
            for (String key : content.keySet()) {
                Listable list = content.get(key);
                String hash = list.getHash();
                if (list.isDirectory()) {
                    builder.append("tree ").append(hash).append("    ").append(key).append("\n");
                } else {
                    builder.append("blob ").append(hash).append("    ").append(key).append("\n");
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }
    }
}
