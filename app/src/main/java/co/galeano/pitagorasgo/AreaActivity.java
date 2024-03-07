package co.galeano.pitagorasgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class AreaActivity extends AppCompatActivity {
    private EditText editNumber;
    private AppCompatButton btn_Calcular;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

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
                    calculateArea(radius);
                }else {
                    tvResult.setText("Error");
                }
            }
        });
    }

    private void calculateArea (double radius) {
        if (radius > 0) {
            double area = Math.PI * Math.pow(radius, 2);;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedResult = decimalFormat.format(area);
            tvResult.setText(String.valueOf(formattedResult));
        } else {
            tvResult.setText("Error");
        }
    }
}