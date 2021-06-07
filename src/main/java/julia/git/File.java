package julia.git;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class File implements Listable {
    private final byte[] b;

    File(byte[] b) {
        this.b = b;
    }

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
        return new String(b, StandardCharsets.ISO_8859_1);
    }
}

