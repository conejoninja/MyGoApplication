package me.conejo.mygoapplication;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import go.mygolibrary.Mygolibrary;

public class MainActivity extends Activity {

    Button btnOne;
    Button btnTwo;
    Button btnError;
    static TextView textInfo;
    static GoCallback gocb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gocb = new GoCallback();
        Mygolibrary.registerJavaCallback(gocb);


        btnOne = (Button) findViewById(R.id.btnone);
        btnTwo = (Button) findViewById(R.id.btntwo);
        btnError = (Button) findViewById(R.id.btnerror);
        textInfo = (TextView) findViewById(R.id.textinfo);

        btnOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                clickDirect();
            }
        });

        btnError.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                clickWithError();
            }
        });

        btnTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                clickCallback();
            }
        });

    }


    public static void clickDirect() {
        textInfo.setText("Calling GO directly...");
        String res = Mygolibrary.hello("Java Cup");
        textInfo.setText(res);
    }

    public static void clickWithError() {
        textInfo.setText("Calling GO with error != nil...");
        try {
            String res = Mygolibrary.helloWithError("Apple Juice");
            textInfo.setText(res);
        } catch  (Exception e) { // If error != nil in Go, will enter the catch
            textInfo.setText("Exception: " + e.toString());
        }
    }

    public static void clickCallback() {
        textInfo.setText("Calling GO that will call Java...");
        Mygolibrary.helloCallback("Chai Tea");
    }

    public static void changeText(String text) {
        textInfo.setText(text);
    }

}
