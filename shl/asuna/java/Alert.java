package org.chall_reverse_android;

// SHL chall Android reverse
// build date 30 oct 2018
// Custom Alert Dialog Builder
// for Inject.class & LoadMe.class

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import org.chall_reverse_android.Alert;


public class Alert {
  
  public static void build(final Context ctx, final String msg) {
    AlertDialog.Builder ad = new AlertDialog.Builder(ctx);
    ad.setTitle("SHL Inject Class");
    ad.setMessage(msg);
    ad.setPositiveButton("Salin Flag", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        ClipboardManager cm = (ClipboardManager)ctx.getSystemService(ctx.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", msg);
        cm.setPrimaryClip(clip);
        Toast.makeText(ctx, "flag di salin :)", 1).show();
      }
    });
    ad.create();
    ad.show();
  }
}