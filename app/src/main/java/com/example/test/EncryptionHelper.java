package com.example.test;



import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionHelper {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static final String SAMPLE_KEY = "jXn2r5u8x/A?D(G-";
    private String key;

    public EncryptionHelper() {
        this.key =SAMPLE_KEY;
    }

    public boolean encryptFile(File inputFile) {
        if (inputFile.getAbsolutePath().contains(".en"))
            return true;
        else {
            File outputFile = new File(inputFile.getAbsolutePath() + ".en");
            return doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
        }
    }

    public boolean decryptFile(File inputFile) {
        if (inputFile.getAbsolutePath().contains(".en")) {
            File outputFile = new File(Environment.getExternalStorageDirectory()+"/asdfgh.mp4");
            return doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
        } else {
            return true;
        }
    }

    private boolean doCrypto(int cipherMode, String key, File inputFile, File outputFile) {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            return false;
        }
        return outputFile.canRead();
    }

}