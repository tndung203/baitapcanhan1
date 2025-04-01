package com.example.individual_ex_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_2 extends AppCompatActivity {
    TextView text;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        text = findViewById(R.id.txtPara);
        back = findViewById(R.id.btnback);
        Intent myintent = getIntent();
        Bundle mybundle = myintent.getBundleExtra("mypackage");
        String name_str = mybundle.getString("name");
        String id_str = mybundle.getString("id");
        String cla_str = mybundle.getString("class");
        String year_str = mybundle.getString("year");
        String pro = mybundle.getString("pro");
        String res = String.format("Họ và tên: %s%nMSSV: %s%nLớp: %s%nSinh viên năm: %s%nChuyên ngành: %s", name_str, id_str, cla_str, year_str, pro);
        text.setText(res);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}