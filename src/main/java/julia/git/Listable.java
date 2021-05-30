package julia.git;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface Listable {
    List<String> list();
    boolean isDirectory();
    Listable get(String name);
    String getContent() throws UnsupportedEncodingException, NoSuchAlgorithmException;
    String getHash() throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
