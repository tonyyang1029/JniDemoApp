/**
 * https://blog.csdn.net/qq_38315190/article/details/83583317
 */

package com.ty.android.jnidemoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTV   = null;
    private Button   mBtn1 = null;
    private Button   mBtn2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTV = findViewById(R.id.ID_MAIN_TV);
        mTV.setText("Press button to read");

        mBtn1 = findViewById(R.id.ID_MAIN_BTN1);
        mBtn1.setText("Read String");
        mBtn1.setOnClickListener(this);

        mBtn2 = findViewById(R.id.ID_MAIN_BTN2);
        mBtn2.setText("Clear String");
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ID_MAIN_BTN1:
                mTV.setText(NativeTestLib.readStr());
                break;
            case R.id.ID_MAIN_BTN2:
                mTV.setText("Press button to read");
                break;
            default:
                Log.e("JniDemoApp", "Unrecognized view!!");
        }
    }
}

class NativeTestLib {
    static {
        System.loadLibrary("nativetestlib");
    }
    public static native String readStr();
}