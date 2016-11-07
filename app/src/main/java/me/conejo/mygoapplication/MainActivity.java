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
        textInfo = (TextView) findViewById(R.id.textinfo);

        btnOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                clickDirect();
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

    public static void clickCallback() {
        textInfo.setText("Calling GO that will call Java...");
        Mygolibrary.helloCallback("Chai tea");
    }

    public static void changeText(String text) {
        textInfo.setText(text);
    }

}
