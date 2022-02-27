package julia.git;

import java.util.HashMap;
import java.util.Map;

public class Objects {
    private final Map<String, GitObject> objects = new HashMap<>();

    public GitObject get(String hash) {
        if(!objects.containsKey(hash)) {
            throw new IllegalArgumentException("GitObject with such hash does not exist!");
        } else {
            return objects.get(hash);
        }
    }

    public void add(GitObject object) {
        objects.put(object.getHash(), object);
    }
}
