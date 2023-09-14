import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ImgEncryptionDecryption {
    public static void main(String[] args) {
        try {
            BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("IMAGE ENCRYPTION/DECRYPTION");
                System.out.println("Choose an option:");
                System.out.println("1. Image Encryption");
                System.out.println("2. Image Decryption");
                System.out.println("0. Exit Program");
                int choice = Integer.parseInt(scanner.readLine());
                Scanner scan = new Scanner(System.in);
                if (choice == 1) {
                    System.out.print("Enter Encryption Key: ");
                    int key = scan.nextInt();
                    scan.nextLine(); // Consume the newline character
                    System.out.print("Enter the path of the image to Encrypt: ");
                    String imagePath = scan.nextLine();

                    try (FileInputStream fis = new FileInputStream(imagePath)) {
                        byte[] data = new byte[fis.available()];
                        fis.read(data);

                        int i = 0;
                        for (byte b : data) {
                            data[i] = (byte) (b ^ key);
                            i++;
                        }

                        try (FileOutputStream fos = new FileOutputStream(imagePath)) {
                            fos.write(data);
                        }
                        System.out.println("Encryption Done: "+imagePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (choice == 2) {
                    System.out.print("Enter Decryption Key (Same as Encryption Key): ");
                    int key = scan.nextInt();
                    scan.nextLine(); // Consume the newline character
                    System.out.print("Enter the path of the image to Decrypt: ");
                    String imagePath = scan.nextLine();

                    try (FileInputStream fis = new FileInputStream(imagePath)) {
                        byte[] data = new byte[fis.available()];
                        fis.read(data);

                        int i = 0;
                        for (byte b : data) {
                            data[i] = (byte) (b ^ key);
                            i++;
                        }

                        try (FileOutputStream fos = new FileOutputStream(imagePath)) {
                            fos.write(data);
                        }
                        System.out.println("Decryption Done:"+imagePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (choice == 0) {
                    System.out.println("Exiting...");
                    System.exit(0);
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
