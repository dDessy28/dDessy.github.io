package org.chall_reverse_android;

// SHL chall android reverse
// build date 30 oct 2018
// Load Class from another app
// DexClassLoader

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Environment;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chall_reverse_android.R;
import org.chall_reverse_android.secret_flag;

public class MainActivity extends Activity {

  AlertDialog.Builder pd;
  String flag = secret_flag.getFlag();
  DexClassLoader classLoader;
  String[] cls = {"pertama", "kedua", "ketiga"};
  String[] cl = {"generateFlag", "StringAnu", "test"};
  StringBuilder sb = new StringBuilder();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String apkPath = Environment.getExternalStorageDirectory() + "/shl/apk/reverse.apk";
    LoadApk(apkPath);
    setContentView(R.layout.activity_main);
  }

  public void LoadApk(String apkPath) {
    pd = new AlertDialog.Builder(this);
    pd.setCancelable(false);
    pd.create();
    File dexOpt = this.getDir("dexOpt", MODE_PRIVATE);
    classLoader =
        new DexClassLoader(
            apkPath, dexOpt.getAbsolutePath(), null, DexClassLoader.getSystemClassLoader());
    try {
      for (int i = 0; i < cls.length || i < cl.length; i++) {

        Class<?> classToLoad =
            (Class<?>) classLoader.loadClass("org.chall_reverse_android.str_" + cls[i]);
        Object instance = classToLoad.newInstance();
        Method method = classToLoad.getMethod(cl[i]);
        method.setAccessible(false);
        String sg = (String) method.invoke(instance);
        sb.append(sg);
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      pd.setMessage(e.getMessage());
      pd.show();
    } catch (ClassNotFoundException e2) {
      e2.printStackTrace();
      pd.setMessage(e2.getMessage());
      pd.show();
    } catch (NoSuchMethodException e3) {
      e3.printStackTrace();
      pd.setMessage(e3.getMessage());
      pd.show();
    } catch (InvocationTargetException e4) {
      e4.printStackTrace();
      pd.setMessage(e4.getMessage());
      pd.show();
    } catch (InstantiationException e5) {
      e5.printStackTrace();
      pd.setMessage(e5.getMessage());
      pd.show();
    }
    
    // Fail... :(
    try {
      Class<?> flg = (Class<?>) classLoader.loadClass("org.chall_reverse_android.secret_flag");
      Field fl = flg.getDeclaredField("asuna");
      String fullFlag = sb.toString().replace("__", "_" + flag + "_");
      pd.setMessage(fullFlag);
      pd.setCancelable(true);
      pd.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // gagal :D
  }
}
