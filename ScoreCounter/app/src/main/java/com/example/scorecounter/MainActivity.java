package com.example.scorecounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        TextView result = findViewById(R.id.result);

        if (savedInstanceState!=null && savedInstanceState.containsKey("KEY")){
            count = savedInstanceState.getInt("KEY");
            result.setText(String.valueOf(count));
        }



//        recognize the button to click or listen

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                result.setText(String.valueOf(count));
            }

        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                result.setText(String.valueOf(count));
            }
        });
//        based on button update the value
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY",count);
    }
}

//when you create an application you get one activity by default
//each activity will have one java file and one xml file
//xml file will have the design
//java file displays the sml file to the user and also provide logical supports to the design