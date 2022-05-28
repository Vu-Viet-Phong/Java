package goodrich.c3;

/**
 * Class for doing encryption and decryption using the Caesar Cipher.
 */
public class CaesarCipher {
    protected char[] encoder = new char[26]; // encryption array
    protected char[] decoder = new char[26]; // decryption array

    public CaesarCipher(int rotation) {
        for (int idx = 0; idx < 26; idx++) {
            encoder[idx] = (char) ('A' + (idx + rotation) % 26);            
            decoder[idx] = (char) ('A' + (idx - rotation + 26) % 26);
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

    /** Returns transformation of original String using given code. */
    private String transform(String original, char[] code) {
        char[] message = original.toCharArray();
        int n = message.length;
        
        for (int idx = 0; idx < n; idx++) {
            if (Character.isUpperCase(message[idx])) {
                int j = message[idx] - 'A';
                message[idx] = code[j];
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
        System.out.println("Secret: " + coded);
        
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }
}