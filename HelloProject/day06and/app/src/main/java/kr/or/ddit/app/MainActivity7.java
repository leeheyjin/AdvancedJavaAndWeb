package kr.or.ddit.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {
    EditText startEt;
    EditText endEt;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        startEt = findViewById(R.id.startEt);
        endEt = findViewById(R.id.endEt);
        resultTv = findViewById(R.id.resultTv);

        Button button = findViewById(R.id.printButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myStar();
            }
        });
    }

    private void myStar() {
        int startNum = Integer.parseInt(startEt.getText().toString());
        int endNum = Integer.parseInt(endEt.getText().toString());
        String txt = "";
        for (int i = startNum; i <= endNum; i++) {
            txt += getStar(i);
        }
        resultTv.setText(txt);
    }

    private String getStar(int count) {
        String result = "";
        for (int i = 0; i <= count; i++) {
            result += "*";
        }
        result += "\n";
        return result;
    }
}