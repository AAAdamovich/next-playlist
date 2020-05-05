/*  Antony Adamovich, Cheuk Cheung, Louis Cumberland, Tim McGowan
*   NextPlaylist.java for Next-Playlist SE Project 
*   West Chester University - CSC 402 - Dr. Richard G. Epstein
*   Created: 4-MAY-2020
*   Please see https://github.com/AAAdamovich/next-playlist for version tracking
*   This file largely created by Sergey Kargopolov and posted on:
*       http://www.appsdeveloperblog.com/encrypt-user-password-example-java/
*/

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordUtils {
    
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static final String SALT_FILE = "salt.txt";
    private static final String USER_FILE = "secret1.txt";
    private static final String PASS_FILE = "secret2.txt";
    
    
     public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }

    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static String generateSecurePassword(String password, String salt) {
        String returnValue = null;

        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
 
        returnValue = Base64.getEncoder().encodeToString(securePassword);
 
        return returnValue;
    }
    
    public static boolean verifyUser(String user)
    {
        try{
            Scanner saltReader = new Scanner(new File(SALT_FILE));
            Scanner userReader = new Scanner(new File(USER_FILE));
            // Generate New secure password with the same salt
            String secure = generateSecurePassword(user, saltReader.nextLine());
        
            // Check if two passwords are equal
            return secure.equalsIgnoreCase(userReader.nextLine());
        }
        catch(FileNotFoundException e){
            // !! No error handling !!
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean verifyPassword(String password)
    {
        try{
            Scanner saltReader = new Scanner(new File(SALT_FILE));
            Scanner passReader = new Scanner(new File(PASS_FILE));
            // Generate New secure password with the same salt
            String secure = generateSecurePassword(password, saltReader.nextLine());
        
            // Check if two passwords are equal
            return secure.equalsIgnoreCase(passReader.nextLine());
        }
        catch(FileNotFoundException e){
            // !! No error handling !!
            e.printStackTrace();
            return false;
        }
    }
    
    public static void saveLogin(String user, String password){
        // Generate Salt. The generated value can be stored in DB. 
        String salt = getSalt(30);
        
        try{
            BufferedWriter fileOutput = new BufferedWriter(new FileWriter(new File(SALT_FILE)));
            fileOutput.write(salt);
            fileOutput.close();
            
            fileOutput = new BufferedWriter(new FileWriter(new File(USER_FILE)));
            fileOutput.write(PasswordUtils.generateSecurePassword(user, salt));
            fileOutput.close();
            
            fileOutput = new BufferedWriter(new FileWriter(new File(PASS_FILE)));
            fileOutput.write(PasswordUtils.generateSecurePassword(password, salt));
            fileOutput.close();
        }
        catch(IOException e){
            // !! No error handling !!
            e.printStackTrace();
        }
    }
}