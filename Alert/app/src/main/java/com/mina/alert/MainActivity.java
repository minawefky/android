package com.mina.alert;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{
    private Button show;
    private AlertDialog.Builder alertdilog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=(Button) findViewById(R.id.ShowDialog);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertdilog=new AlertDialog.Builder(MainActivity.this);
                alertdilog.setTitle(getResources().getString(R.string.dilogt));
                alertdilog.setMessage(getResources().getString(R.string.dilogm));
                alertdilog.setCancelable(false);
                alertdilog.setPositiveButton(getResources().getString(R.string.quit), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Exit our activity
                        MainActivity.this.finish();
                    }
                });
                alertdilog.setNeutralButton(getResources().getString(R.string.contine), new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertD=alertdilog.create();
                alertD.show();
            }
        });
    }
}
