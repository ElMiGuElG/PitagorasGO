package co.galeano.pitagorasgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class FunctionsActivity extends AppCompatActivity {
    private EditText editNumber;
    private Spinner spinnerFunction;
    private AppCompatButton btn_Calcular;
    private TextView tvResultSen;
    private TextView tvResultCos;
    private TextView tvResultTan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);

        initComponent();
        initSpinner();
        initListener();

    }

    private void initComponent() {
        editNumber = findViewById(R.id.editNumber);
        spinnerFunction = findViewById(R.id.spinnerFunction);
        btn_Calcular = findViewById(R.id.btn_Calcular);
        tvResultSen = findViewById(R.id.tvResultSen);
        tvResultCos = findViewById(R.id.tvResultCos);
        tvResultTan = findViewById(R.id.tvResultTan);
    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options, R.layout.spinner_item);
        spinnerFunction.setAdapter(adapter);
    }

    private void initListener() {
        btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editNumber.getText().toString();
                if (!inputText.isEmpty()) {
                    double degrees = Double.parseDouble(inputText);
                    calculateTrigFunctions(degrees);
                } else {
                    tvResultSen.setText("Error");
                    tvResultCos.setText("Error");
                    tvResultTan.setText("Error");
                }
            }
        });
    }

    private void calculateTrigFunctions(double value) {
        if (value > 0) {
            String selected = spinnerFunction.getSelectedItem().toString();

            if (selected.equals("Grados")) {
                value = Math.toRadians(value);
            }
            double sinValue = Math.sin(value);
            double cosValue = Math.cos(value);
            double tanValue = Math.tan(value);

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedSin = decimalFormat.format(sinValue);
            String formattedCos = decimalFormat.format(cosValue);
            String formattedTan = decimalFormat.format(tanValue);

            tvResultSen.setText(formattedSin);
            tvResultCos.setText(formattedCos);
            tvResultTan.setText(formattedTan);
        } else {
            tvResultSen.setText("Error");
            tvResultCos.setText("Error");
            tvResultTan.setText("Error");
        }
    }
}
