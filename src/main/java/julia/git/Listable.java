package julia.git;

import java.util.List;

public interface Listable {
    List<String> list();

    boolean isDirectory();

    Listable get(String name);
}
