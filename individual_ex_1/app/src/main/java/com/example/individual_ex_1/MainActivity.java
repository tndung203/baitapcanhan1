package com.example.individual_ex_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name, ID, cla;
    RadioGroup rg;
    RadioButton rb;
    Button btn;
    CheckBox emb;
    CheckBox elec;
    CheckBox tele;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.editName);
        ID = findViewById(R.id.editID);
        cla = findViewById(R.id.editClass);
        btn = findViewById(R.id.btnSub);
        emb = findViewById(R.id.cbemb);
        elec = findViewById(R.id.cbelec);
        tele = findViewById(R.id.cbtele);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first_act = new Intent(MainActivity.this, activity_2.class);
                String name_str = name.getText().toString();
                String id_str = ID.getText().toString();
                String cla_str = cla.getText().toString();
                rg = findViewById(R.id.radiobtn);
                int selectedID = rg.getCheckedRadioButtonId();
                rb = findViewById(selectedID);
                Bundle mybundle = new Bundle();
                mybundle.putString("name", name_str);
                mybundle.putString("id", id_str);
                mybundle.putString("class", cla_str);
                mybundle.putString("year", rb.getText().toString());
                if (emb.isChecked()) {
                    mybundle.putString("pro", emb.getText().toString());
                }
                if (elec.isChecked()) {
                    mybundle.putString("pro", elec.getText().toString());
                }
                if (tele.isChecked()) {
                    mybundle.putString("pro", tele.getText().toString());
                }
                first_act.putExtra("mypackage", mybundle);
                startActivity(first_act);
            }

    });

    }
}