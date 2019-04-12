package com.example.automobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayTXT;
    private EditText name, color, engine, cost, year;
    private Button carCreate, dieselCreate;
    private int arrayCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameID);
        color = findViewById(R.id.colorID);
        engine = findViewById(R.id.engineID);
        cost = findViewById(R.id.purchaseID);
        year = findViewById(R.id.yearID);
        carCreate = findViewById(R.id.carID);
        dieselCreate = findViewById(R.id.dieselID);
        displayTXT = findViewById(R.id.displayID);

        carCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Validate()){
                    return;
                }
                String carname = name.getText().toString();
                int date = Integer.parseInt(year.getText().toString());
                String colour = color.getText().toString();
                double eng = Double.parseDouble(engine.getText().toString());
                double price = Double.parseDouble(cost.getText().toString());
                arrayCount++;
                String heading = "This is vehicle no." + arrayCount + "\n";
                String content = "Manufacture: " + carname + "| Year: "+date+ " | Color: " + colour + " " +
                                 "\n" +"Price: " + price + " | Engine Size" + eng+"\n"+"\n" ;
                displayTXT.append(heading + content);
            }
        });
    }
    private boolean Validate() {
        if (TextUtils.isEmpty(name.getText().toString())) {
            name.setError("Please enter name");
            name.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(year.getText().toString())) {
            year.setError("Please enter year");
            year.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(color.getText().toString())) {
            color.setError("Please enter color");
            color.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(engine.getText().toString())) {
            engine.setError("Please enter engine size");
            engine.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(cost.getText().toString())) {
            cost.setError("Please enter purchase");
            cost.requestFocus();
            return false;
        }
        return true;
    }
}
