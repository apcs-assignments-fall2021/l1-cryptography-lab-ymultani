import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        char x = ch;
        if (x < 65 && x >= 0) {
            return x;
        } else if (x >= 91 && x < 97) {
            return x;
        } else if (x > 122) {
            return x;
        } else {
            for (int t = 1; t <= key; t++) {
                x++;
                if (x == (char) (123)) {
                    x = 'a';

                } else if (x == (char) (91)) {
                    x = 'A';
                }
            }
            return x;
        }
    }

    public static char decryptCaesarLetter(char ch, int key) {
        char x = ch;
        if (x < 65 && x>= 0){
            return x;
        }
        else if(x >= 91 && x < 97){
            return x;
        }
        else if (x >122){
            return x;
        }
        else{
            for(int t = 1; t <= key;t++){
                x--;
                if(x == 64){
                    x = 'Z';
                }
                else if(x == 96){
                    x ='z';
                }
            }
            return x;
        }
    }
    public static String encryptVigenere(String message, String key) {
        String new_string = "";
        int key_index = 0;
        for(int i = 0; i< message.length(); i++){
            char message_index = message.charAt(i);
            char shifter = key.charAt(key_index);
            char x = encryptCaesarLetter(message_index,shifter-65);
            if (x < 65 || (x>90 && x <97)|| x>122){
                key_index = key_index;
            }
            else{
                key_index++;
            }
            if (key_index == key.length()){
                key_index = 0;
            }
            new_string += x;
        }
        return new_string;
    }

    public static String decryptVigenere(String message, String key) {
        String new_string = "";
        int key_index = 0;
        for(int i = 0; i< message.length(); i++){
            char message_index = message.charAt(i);
            char shifter = key.charAt(key_index);
            char x = decryptCaesarLetter(message_index,shifter-65);
            if (x < 65 || (x>90 && x <97)|| x>122){
                key_index = key_index;
            }
            else{
                key_index++;
            }
            if (key_index == key.length()){
                key_index = 0;
            }
            new_string += x;
        }
        return new_string;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Encrypting 'a' by 5 should give 'f', and got: " + encryptCaesarLetter('a', 5));
        System.out.println("Encrypting 'y' by 8 should give 'g', and got: " + encryptCaesarLetter('y', 8));
        System.out.println("Encrypting 'A' by 4 should give 'E', and got: " + encryptCaesarLetter('A', 4));
        System.out.println("Encrypting 'Z' by 3 should give 'C', and got: " + encryptCaesarLetter('Z', 3));
        System.out.println("Encrypting '#' by 5 should give '#', and got: " + encryptCaesarLetter('#', 5));
        System.out.println();
        System.out.println("Decrypting 'f' by 5 should give 'a', and got: " + decryptCaesarLetter('f', 5));
        System.out.println("Decrypting 'g' by 8 should give 'y', and got: " + decryptCaesarLetter('g', 8));
        System.out.println("Decrypting 'E' by 4 should give 'A', and got: " + decryptCaesarLetter('E', 4));
        System.out.println("Decrypting 'C' by 3 should give 'Z', and got: " + decryptCaesarLetter('C', 3));
        System.out.println("Decrypting '#' by 5 should give '#', and got: " + decryptCaesarLetter('#', 5));

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
