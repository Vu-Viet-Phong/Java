package goodrich.others;

/** Class for doing encryption and decrytion using the Caesar Cipher. */
public class CaesarCipher {
    protected char[] encoder = new char[26]; // encryption array
    protected char[] decoder = new char[26]; // decryption array

    public CaesarCipher(int rotation) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char) ('A' + (i + rotation) % 26);
            decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
        }
    }

    /** Returns String representing encrypted message. */
    public String encrypt(String message) {
        return transform(message, encoder);
    }

    /** Returns decrypted message given encrypted secret. */
    public String decrypt(String secret) {
        return transform(secret, decoder);
    }

    /** Transformation of original String using given code */
    public String transform(String original, char[] code) {
        char[] message = original.toCharArray();
        int n = message.length;

        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(message[i])) {
                int j = message[i] - 'A';
                message[i] = code[j];
            }
        }

        return new String(message);
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String coded = cipher.encrypt(message);
        System.out.println("secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }
}
