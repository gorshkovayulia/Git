package julia.git;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface Listable {
    List<String> list();
    boolean isDirectory();
    Listable get(String name);
    String getContent();

    default String getHash() {
        String content = getContent();
        StringBuilder result = new StringBuilder();
        byte[] sha = sha1(content);
        for (byte b : sha) {
            int decimal = (int) b & 0xff;
            String hex = Integer.toHexString(decimal);
            if (hex.length() % 2 == 1) {
                hex = "0" + hex;
            }
            result.append(hex);
        }
        return result.toString();
    }

    static byte[] sha1(String content) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] data = content.getBytes(StandardCharsets.UTF_8);
            return messageDigest.digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}
