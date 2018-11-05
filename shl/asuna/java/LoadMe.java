package org.chall_reverse_android;

// SHL chall android reverse
// build date 30 oct 2018
// Loader : invoke-static {p0}, Lorg/chall_reverse_android/LoadMe;->getKey()V

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.chall_reverse_android.Alert;
import org.chall_reverse_android.challenges;
import org.chall_reverse_android.secret_flag;


public class LoadMe {
  public static void getKey(Context ctx) {
    challenges chall = new challenges();
    secret_flag flag = new secret_flag();
    String key = chall.anu();
    String flg = String.valueOf(flag.asuna);
    try {
      String full = new String(Base64.decode(key.getBytes(), Base64.DEFAULT), "UTF-8");
      String replaced = full.replace("*REDACTED*", flg);
      Alert.build(ctx, replaced); // bisa di hapus jika hanya menggunakan Log :)
      Log.d("SHLFlag2", replaced);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
