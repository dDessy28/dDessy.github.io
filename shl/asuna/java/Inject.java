package org.chall_reverse_android;

// SHL chall android reverse
// build date 30 oct 2018
// Loader : invoke-static {p0}, Lorg/chall_reverse_android/Inject;->SHL()V

import android.content.Context;
import android.util.Log;
import org.chall_reverse_android.Alert;
import org.chall_reverse_android.secret_flag;
import org.chall_reverse_android.str_kedua;
import org.chall_reverse_android.str_ketiga;
import org.chall_reverse_android.str_pertama;


public class Inject {
  public static void SHL(Context ctx) {
    str_pertama aa = new str_pertama();
    str_kedua bb = new str_kedua();
    str_ketiga cc = new str_ketiga();
    secret_flag flag = new secret_flag();
    String getFullFlag = aa.generateFlag() + bb.StringAnu() + String.valueOf(flag.asuna) + cc.test();
    Alert.build(ctx, getFullFlag); // bisa di hapus jika hanya menggunakan Log :)
    Log.d("SHLFlag", getFullFlag);
  }
}
