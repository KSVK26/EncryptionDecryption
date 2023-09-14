import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Scanner;

public class TextFinal {

    public static void main(String[] args) {
        try {
            BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
            
            while(true)
            {
                System.out.println("TEXT ENCRYPTION/DECRYPTION");
                System.out.println("Choose an option:");
                System.out.println("1. Text Encryption");
                System.out.println("2. Text Decryption");
                System.out.println("0. Exit Program");
                Scanner scan = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.readLine());
            
            //int choice = scanner.nextInt();
            String keyHex;
            if (choice == 1) {
                // Encryption

                System.out.print("Enter Encryption Key: ");
                int inkey = scan.nextInt();
                switch(inkey)
                {

                    case 1: keyHex = "1eec2bd0a1699798849f2fa0ce1ac7d6";
                        break;
                    case 2: keyHex = "fe14677ace43e7b1c79a21b6335dd6dc";
                        break;
                    case 3: keyHex = "8f5cc9f3fc51b19e5a5cc71b6c7d6acc";
                        break;
                    case 4: keyHex = "12c19b20f3e4552ca824b0d86d33f898";
                        break;
                    case 5: keyHex = "1505735c933137eaecab4bdebb133089";
                        break;
                    case 6: keyHex = "b7bb320bb5f3760fe7adf9af8af82598";
                        break;
                    case 7: keyHex = "5679f58fa7037b860dadfa2bbf50d3df";
                        break;
                    case 8: keyHex = "08177426148b3e19f6fa5b9e6babdb71";
                        break;
                    default: System.out.println("Invaild Input");
                        return;

                }

                // Convert the hexadecimal string to a byte array
                byte[] keyData = new byte[16];
                for (int i = 0; i < 32; i += 2) {
                    keyData[i / 2] = (byte) ((Character.digit(keyHex.charAt(i), 16) << 4)
                     + Character.digit(keyHex.charAt(i + 1), 16));
                }

                // Create the cipher for encryption
                SecretKey secretKey = new SecretKeySpec(keyData, "AES");

                Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

                // Get user input for text to encrypt
                System.out.print("Enter text to Encrypt: ");
                Scanner sc= new Scanner(System.in);
                String plainText = sc.nextLine();

                // Encrypt the text
                byte[] encryptedBytes = encryptCipher.doFinal(plainText.getBytes());
                String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

                System.out.println("Encrypted Text: " + encryptedText);
            } else if (choice == 2) {
                // Decryption

                System.out.print("Enter Dencryption Key (Same as Encryption Key): ");
                int inkey = scan.nextInt();
                switch(inkey)
                {

                    case 1: 
                        keyHex = "1eec2bd0a1699798849f2fa0ce1ac7d6";
                        break;
                    case 2: 
                        keyHex = "fe14677ace43e7b1c79a21b6335dd6dc";
                        break;
                    case 3: 
                        keyHex = "8f5cc9f3fc51b19e5a5cc71b6c7d6acc";
                        break;
                    case 4: 
                        keyHex = "12c19b20f3e4552ca824b0d86d33f898";
                        break;
                    case 5: 
                        keyHex = "1505735c933137eaecab4bdebb133089";
                        break;
                    case 6:     
                        keyHex = "b7bb320bb5f3760fe7adf9af8af82598";
                        break;
                    case 7: 
                        keyHex = "5679f58fa7037b860dadfa2bbf50d3df";
                        break;
                    case 8:     
                        keyHex = "08177426148b3e19f6fa5b9e6babdb71";
                        break;
                    default: System.out.println("Invaild Input");
                        return;

                }

                // Convert the hexadecimal string to a byte array
                byte[] keyData = new byte[16];
                for (int i = 0; i < 32; i += 2) {
                    keyData[i / 2] = (byte) ((Character.digit(keyHex.charAt(i), 16) << 4) +
                            Character.digit(keyHex.charAt(i + 1), 16));
                }

                // Get user input for ciphertext to decrypt
                SecretKey secretKey = new SecretKeySpec(keyData, "AES");
                System.out.print("Enter Encrypted Text to Decrypt: ");
                Scanner sc= new Scanner(System.in);
                String encryptedText = sc.nextLine();

                // Create the cipher for decryption
                Cipher decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);

                // Decrypt the text
                byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedText));
                String decryptedText = new String(decryptedBytes);

                System.out.println("Decrypted Text: " + decryptedText);
            } else if (choice == 0)
            {
                System.out.println("Exiting...");
                System.exit(0);
            }
            else 
            {
                System.out.println("Invalid choice.");
            }
        }
     }
      catch (Exception e) {
            System.out.println("Error, Wrong Key");;
        }
    }
}