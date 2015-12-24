package com.mina.secondtry;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private ImageView buchview;
    private ImageView motzview;
    private TextView buchn;
    private TextView motzn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buchview =(ImageView) findViewById(R.id.buchimg);
        motzview =(ImageView) findViewById(R.id.motzimg);
        buchn =(TextView) findViewById(R.id.textView);
        motzn=(TextView) findViewById(R.id.textView2);
        buchview.setOnClickListener(this);
        motzview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.buchimg:
            Intent intent=new Intent(MainActivity.this,second.class);
            intent.putExtra("buch","buch is an amazing");
            intent.putExtra("name", "buch");
            startActivity(intent);
            break;
        case R.id.motzimg:
            Intent intent1=new Intent(MainActivity.this,second.class);
            intent1.putExtra("motz","motz is sucks");
            intent1.putExtra("name","motz");
            startActivity(intent1);
            break;
    }

    }
}
