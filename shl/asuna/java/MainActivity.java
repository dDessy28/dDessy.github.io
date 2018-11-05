package org.chall_reverse_android;

import android.app.Activity;
import android.os.Bundle;
import org.chall_reverse_android.Inject;
import org.chall_reverse_android.LoadMe;
import org.chall_reverse_android.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inject.SHL(this);
        LoadMe.getKey(this);

    }

}
