package julia.git;

public interface GitObject {
    String getContent();

    default String getHash() {
        String content = getContent();
        StringBuilder result = new StringBuilder();
        byte[] sha = Sha1.getSha1(content);
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
}
