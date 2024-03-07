package co.galeano.pitagorasgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PerimeterActivity extends AppCompatActivity {
    private EditText editNumber;
    private AppCompatButton btn_Calcular;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perimeter);

        initComponent();
        initListener();
    }

    private void initComponent() {
        editNumber = findViewById(R.id.editNumber);
        btn_Calcular = findViewById(R.id.btn_Calcular);
        tvResult = findViewById(R.id.tvResult);
    }

    private void initListener() {
        btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editNumber.getText().toString();
                if (!inputText.isEmpty()) {
                    double radius = Double.parseDouble(inputText);
                    calculatePerimeter(radius);
                }else {
                    tvResult.setText("Error");
                }
            }
        });
    }

    private void calculatePerimeter (double radius) {
        if (radius > 0) {
            double perimeter = 2 * Math.PI * radius;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedResult = decimalFormat.format(perimeter);
            tvResult.setText(String.valueOf(formattedResult));
        } else {
            tvResult.setText("Error");
        }
    }
}