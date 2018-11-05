package org.chall_reverse_android;
 
// mohon maaf flag nya saya load dari sini, karna saya sudah mencoba bnyak cara untuk mengambil return char array dari class Apk asli. tapi gagal :)

public class secret_flag {
    private static char[] asuna = new char[]{'_', 'a', 's', 'u', 'n', 'a', '_', '<', '3', '_', 'm', 'e', '_'};
 
    public static String getFlag() {
        return String.valueOf(asuna);
    }
}
