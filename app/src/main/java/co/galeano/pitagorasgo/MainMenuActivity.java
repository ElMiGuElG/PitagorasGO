package co.galeano.pitagorasgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.animation.content.Content;

public class MainMenuActivity extends AppCompatActivity {

    //----- Declaration of variables  -----
    private CardView viewFunction;
    private CardView viewArea;
    private CardView viewPerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        initComponent();
        initListener();
    }

    private void initComponent() {
        viewFunction = findViewById(R.id.viewFunction);
        viewArea = findViewById(R.id.viewArea);
        viewPerimeter = findViewById(R.id.viewPerimeter);
    }

    private void initListener() {
        viewFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FunctionsActivity.class);
                startActivity(intent);
            }
        });
        viewArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AreaActivity.class);
                startActivity(intent);
            }
        });

        viewPerimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PerimeterActivity.class);
                startActivity(intent);
            }
        });
    }
}