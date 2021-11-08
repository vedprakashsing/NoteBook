package io.app.notebook;

import static android.content.ContentValues.TAG;

import android.util.Log;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {

    private String key = "Bar12345Bar12345"; // 128 bit key
    private Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    Cipher cipher;

    {
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public byte[] encrypted(String password) {

        // Create key and cipher
        try {

            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            Log.d(TAG, "encrypted: "+encrypted);
            String encryptedString=encrypted.toString();
            Log.d(TAG, "encrypted: "+encryptedString);
            return encrypted;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (BadPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decrypted(byte[] encryptedPassword){

          try{
              cipher.init(Cipher.DECRYPT_MODE, aesKey);
              Log.d(TAG, "decrypted: "+encryptedPassword);
              String decrypted = new String(cipher.doFinal(encryptedPassword));
              Log.d(TAG, "decrypted: "+decrypted);
              return decrypted;
          } catch (InvalidKeyException e) {
              e.printStackTrace();
          } catch (BadPaddingException e) {
              e.printStackTrace();
          } catch (IllegalBlockSizeException e) {
              e.printStackTrace();
          }
          return "nahi hua";
    }
}
