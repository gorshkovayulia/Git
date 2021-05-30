package julia.git;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class File implements Listable {
    private int size;
    private final byte[] b;

    File(int size, byte[] b) {
        this.size = size;
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

    @Override
    public String getHash() throws NoSuchAlgorithmException {
        String content = getContent();
        byte[] sha = sha1(content);
        StringBuilder result = new StringBuilder();
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

    private static byte[] sha1(String content) throws NoSuchAlgorithmException {
        byte[] data = content.getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        return messageDigest.digest(data);
    }
}

