package com.mina.readandwrite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {
    private EditText editText;
    private Button savebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.txtsave);
        savebtn=(Button)findViewById(R.id.saveb);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.equals("")){
                    Toast.makeText(MainActivity.this, "enter some text", Toast.LENGTH_SHORT).show();
                }
                else {
                    WriteTofile(editText.getText().toString());
                }
            }
        });
        if (openfile() != null){
            editText.setText(openfile());
        }else {

        }

    }
        public void WriteTofile(String s){
        try {
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(openFileOutput("hello.txt",MODE_PRIVATE));
            outputStreamWriter.write(s);
            outputStreamWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String openfile(){
        String result="";
        try {
            InputStream inputStream=openFileInput("hello.txt");
            if(inputStream!=null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String temp="";
                StringBuilder stringBuilder=new StringBuilder();
                while (( (temp = bufferedReader.readLine()) != null)) {
                    stringBuilder.append(temp);
                }
                result=stringBuilder.toString();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    }

