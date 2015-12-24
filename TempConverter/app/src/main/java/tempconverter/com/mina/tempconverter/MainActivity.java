package tempconverter.com.mina.tempconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {
    private TextView showTitel;
    private TextView Temp;
    private Button Buttoncel;
    private Button Buttonfar;
    private TextView get;
    DecimalFormat round=new DecimalFormat("0.0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTitel =(TextView) findViewById(R.id.TitelView);
        Temp =(TextView) findViewById(R.id.Tempt);
        Buttoncel=(Button)findViewById(R.id.Buttonc);
        Buttonfar=(Button) findViewById(R.id.Buttonf);
        get=(TextView) findViewById(R.id.GetTemp);
        Buttoncel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String EditText=Temp.getText().toString();
                if(EditText.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter text", Toast.LENGTH_LONG).show();
                }
                else {
                    double editint=Double.parseDouble(EditText);
                    double c =Convertc(editint);
                    get.setText(round.format(c));
                }
                Buttonfar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String EditText=Temp.getText().toString();
                        if(EditText.isEmpty()){
                            Toast.makeText(getApplicationContext(),"Enter text", Toast.LENGTH_LONG).show();
                        }
                        else {
                            double editint=Double.parseDouble(EditText);
                            double c=convertf(editint);
                            get.setText(round.format(c));
                        }
                    }
                });
            }
        });
    }
    public double Convertc(double editint){
        double result;
        result=(editint -32)* 5/9;
        return result;
    }
    public double convertf(double editint){
        double result;
        result=(editint *9/5) +32;
        return result;
    }
}
