package julia.git;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1 {
    static byte[] getSha1(String content) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] data = content.getBytes(StandardCharsets.UTF_8);
            return messageDigest.digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}
