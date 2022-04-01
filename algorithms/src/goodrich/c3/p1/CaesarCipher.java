package goodrich.c3.p1;

/** Class for doing encryption and decryption using the Caesar Cipher. */
public class CaesarCipher {
    protected char[] encoder = new char[26]; // Encrytion array
    protected char[] decoder = new char[26]; // Decrytion array

    /** Constructor that initializes the encryption and decryption arrays. */
    public CaesarCipher(int rotation) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char) ('A' + (i + rotation) % 26);
            decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
        }
    }

    /** Returns String representing encrypted message. */
    public String encrypt(String message) {
        return transform(message, encoder); // use encoder array
    }

    /** Returns decryted mesage given encrypted secret. */
    public String decrypt(String secret) {
        return transform(secret, decoder); // use decoder array
    }

    /** Returns transformation of original String using given code. */
    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            if (Character.isUpperCase(msg[i])) { // we have a letter to change
                int j = msg[i] - 'A';            // will be value from 0 to 25
                msg[i] = code[j];                // replace the character
            }
        }
        return new String(msg);
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer); // should be plaintext again
    }
}