package com.example.smart_phone_application_assignment_02;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class all_are_here extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView seekValue;
    private RatingBar ratingBar;
    private TextView ratingText;
    private TextView seasonsText;
    private Switch switchSeasons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_are_here);


        CheckBox checkBox1 = findViewById(R.id.p1);
        CheckBox checkBox2 = findViewById(R.id.p2);
        CheckBox checkBox3 = findViewById(R.id.p3);
        CheckBox checkBox4 = findViewById(R.id.p4);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        seekBar = findViewById(R.id.seekBar);
        seekValue = findViewById(R.id.seekValue);

        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.rating);

        switchSeasons = findViewById(R.id.switchSeasons);
        seasonsText = findViewById(R.id.seasonsText);


        switchSeasons.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                seasonsText.setVisibility(TextView.VISIBLE);
            } else {
                seasonsText.setVisibility(TextView.GONE);
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekValue.setText("Progress: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // RatingBar change listener
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                ratingText.setText("Rating: " + rating)
        );


        checkBox1.setOnClickListener(view -> {
            if (checkBox1.isChecked()) {
                Toast.makeText(all_are_here.this, "Selected: Tanguwar Haor", Toast.LENGTH_SHORT).show();
            }
        });


        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedCity = selectedRadioButton.getText().toString();
            Toast.makeText(all_are_here.this, "Selected City: " + selectedCity, Toast.LENGTH_SHORT).show();
        });
    }
}
