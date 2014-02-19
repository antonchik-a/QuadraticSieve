package com.antonchik.quadsieve;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.antonchik.quadsieve.ecm.ecm;
import org.w3c.dom.Text;

import java.math.BigInteger;

public class TestSieve extends Activity {
    TextView p;
    TextView q;
    EditText big_integer;
    ecm factorizator;
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Init();
    }
    public void Init()
    {
        big_integer=(EditText)findViewById(R.id.big_integer);
        p=(TextView)findViewById(R.id.p);
        p.setVisibility(View.GONE);
        q=(TextView)findViewById(R.id.q);
        q.setVisibility(View.GONE);
        factorizator= new ecm();
        factorizator.init();
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                p.setText("");
                q.setText("");
                BigInteger[] p_and_q= factorizator.getFactors(new BigInteger(big_integer.getText().toString()),new BigInteger[]{new BigInteger("1"),new BigInteger("1")},new int[10]);
                long first=p_and_q[0].longValue();
                long second=p_and_q[1].longValue();
                p.setText(String.valueOf(first));
                q.setText(String.valueOf(second));
                p.setVisibility(View.VISIBLE);
                q.setVisibility(View.VISIBLE);
                }
                catch (Exception ex)
                {

                }
            }
        });
    }
}
