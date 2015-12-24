package com.mina.secondtry;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class second extends Activity {
    private ImageView img;
    private TextView bio;
    private Bundle extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        img=(ImageView) findViewById(R.id.imageView);
        bio=(TextView) findViewById(R.id.bio);
        extra =getIntent().getExtras();
        if(extra!=null){
            String name=extra.getString("name");
            show(name);
        }
    }
    public void  show(String name){
        if(name.equals("buch")){
            String bi=extra.getString("buch");
            img.setImageDrawable(getResources().getDrawable(R.drawable.bach_profile));
            bio.setText(bi);
        }
        else if(name.equals("motz")){
            String bi2=extra.getString("motz");
            img.setImageDrawable(getResources().getDrawable(R.drawable.mozart_profile));
            bio.setText(bi2);
        }
    }
}
