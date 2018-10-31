package com.dessy.OWASPkeyGen;

//build date : 21-10-2018
//by : dessy :)

import android.app.AlertDialog;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.webkit.WebView;
import com.dessy.OWASPkeyGen.aa;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String html2 = "";
    try {
      String oriBase64 = "5UJiFctbmgbDoLXmpL12mkno8HT4Lv8dlat8FxR2GOc=";
      String oriKeyChiper = "8d127684cbc37c17616d806cf50473cc";
      String keySpec = new String(aa.myByte());
      String owasp = aa.encode();
      String owBase64 = aa.owaspBase64();
      html2 = "<html><body><b>OWASP keyGen (UnCrackable level 1)<br>For Educational Purposes Only!!!<br>// Made by dessy :)</b><br><br>Cipher : " + oriKeyChiper + "<br>Base64 : " + oriBase64 + "<br>byte[] KeySpec : " + keySpec + "<br>byte[] Base64 : " + owBase64 + "<br><br>Generate Secret String : <b>" + owasp + "<b></body></html>";
      AlertDialog.Builder alert = new AlertDialog.Builder(this);
      alert.setTitle("UnCrackable level 1 keyGen \nMade by dessy :)");
      alert.setMessage("For Educational Purposes Only!" + "\nGenerate Key : "+ owasp);
      alert.create();
      alert.show();
      Toast.makeText(this, "Secret String : " + owasp, 1).show();
    } catch (Exception e) {
      e.printStackTrace();
    }
    String mime = "text/html";
    String encoding = "utf-8";
    WebView myWebView = new WebView(this);
    myWebView.getSettings().setJavaScriptEnabled(true);
    myWebView.loadDataWithBaseURL(null, html2, mime, encoding, null);
    setContentView(myWebView);
  }
}
