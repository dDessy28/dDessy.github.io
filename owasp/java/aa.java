package com.dessy.OWASPkeyGen;

//build date : 21-10-2018
//by : dessy :)

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;

public class aa {

  public static String encode() {
    byte[] by = new byte[0];
    try {
      byte[] getKey = secretStr();
      by = getKey;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new String(by);
  }
  
  public static String owaspBase64() {
    return new String(Base64.decode("5UJiFctbmgbDoLXmpL12mkno8HT4Lv8dlat8FxR2GOc=", 0));
  }

  public static byte[] secretStr()
      throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
          IllegalBlockSizeException, BadPaddingException {
    byte[] bArr = myByte();
    byte[] bArr2 = Base64.decode("5UJiFctbmgbDoLXmpL12mkno8HT4Lv8dlat8FxR2GOc=", 0);
    Key secretKeySpec = new SecretKeySpec(bArr, "AES/ECB/PKCS7Padding");
    Cipher instance = Cipher.getInstance("AES");
    instance.init(2, secretKeySpec);
    return instance.doFinal(bArr2);
  }
  
  public static byte[] myByte() {
        String str = "8d127684cbc37c17616d806cf50473cc";
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
  }
}
