package julia.git;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Directory implements Listable {
    private final HashMap<String, Listable> content = new HashMap<>();

    public void add(String name, Listable list) {
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
    public String getContent() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        StringBuilder builder = new StringBuilder();
        for (String key : content.keySet()) {
            Listable list = content.get(key);
            String hash = list.getHash();
            builder.append(hash).append("     ").append(key).append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString(); // Get string containing keys + hashes
    }

    @Override
    public String getHash() throws NoSuchAlgorithmException {
        StringBuilder builder = new StringBuilder();
        for (String key : content.keySet()) {
            builder.append(key).append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        String content = builder.toString(); // Get string containing keys only
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