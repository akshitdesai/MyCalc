package com.codestromer.mycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView _bin,_oct,_dec,_hex;
    private String dis_bin="",dis_oct="",dis_dec="",dis_hex="";
    private String current_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _bin=(TextView) findViewById(R.id.bin);
        _dec=(TextView) findViewById(R.id.dec);
        _oct=(TextView) findViewById(R.id.oct);
        _hex=(TextView) findViewById(R.id.hex);

        _bin.setText(dis_bin);
        _dec.setText(dis_dec);
        _oct.setText(dis_oct);
        _hex.setText(dis_hex);
    }

    private void updateScreen(){
        _bin.setText(dis_bin);
        _dec.setText(dis_dec);
        _oct.setText(dis_oct);
        _hex.setText(dis_hex);
    }

    public String tobin(String d){

        int n=Integer.parseInt(d),rem;

        if(n==0)        return "0";
        String ne="";
        int[] binaryNum = new int[32];

        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }

        for (int j = i - 1; j >= 0; j--)
            ne+=Integer.toString(binaryNum[j]);
        return ne;
    }
    public void onClickNumber(View v){
        Button b=(Button) v;

        if (dis_dec != null && dis_dec.length() >1 && b.getText().equals("~"))
            dis_dec = dis_dec.substring(0, dis_dec.length() - 1);
        else if( b.getText().equals("~")==false)
            dis_dec += b.getText();
        else if(dis_dec != null)
            dis_dec = "0";
        dis_bin=Integer.toBinaryString(Integer.parseInt(dis_dec));
        dis_hex=Integer.toHexString(Integer.parseInt(dis_dec));
        dis_oct=Integer.toOctalString(Integer.parseInt(dis_dec));
        updateScreen();
    }
}