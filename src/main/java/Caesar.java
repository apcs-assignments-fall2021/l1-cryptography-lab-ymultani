import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String new_string = "";
        for(int i = 0; i < message.length();i++){
            char x = message.charAt(i);
            if((x <65)||(x> 91 && x<97)|| x>122){
                new_string += x;
            }
            else if((x =='x')||(x =='y')||(x=='z')||(x == 'X')||(x=='Y')||(x=='Z')){
                x = (char)(x-23);
                new_string += x;
            }
            else {
                x = (char)(x+3);
                new_string += x;
            }

        }

        return new_string;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String new_string = "";
        for (int i = 0; i <message.length();i++){
            char x = message.charAt(i);
            if((x <65)||(x> 91 && x<97)|| x>122){
                new_string += x;
            }
            else if((x =='a')||(x =='b')||(x=='c')||(x == 'A')||(x=='B')||(x=='C')){
                x = (char)(x+23);
                new_string += x;
            }
            else {
                x = (char)(x-3);
                new_string += x;
            }
        }
        return new_string;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String new_string = "";
        for (int i = 0; i < message.length(); i++) {
            char x = message.charAt(i);
            if (x < 65 && x>= 0) {
                new_string += x;
            }
            else if(x >= 91 && x < 97){
                new_string += x;
            }
            else if (x >122){
                new_string += x;
            }
            else{
                for(int t = 1; t <= key; t++){
                    x++;
                    if (x == (char)(123)){
                        x= 'a';

                    }
                    else if(x == (char)(91)){
                        x = 'A';
                    }
                }
                new_string += x;
            }
        }
        return new_string;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String new_string = "";
        for (int i = 0; i < message.length(); i++){
            char x = message.charAt(i);
            if (x < 65 && x>= 0) {
                new_string += x;
            }
            else if(x >= 91 && x < 97){
                new_string += x;
            }
            else if (x >122){
                new_string += x;
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
                new_string += x;
            }
        }
        return new_string;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your shift key: ");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
