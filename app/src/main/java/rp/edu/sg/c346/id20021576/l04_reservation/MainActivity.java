package rp.edu.sg.c346.id20021576.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etSize;
    TimePicker tp;
    DatePicker dp;
    RadioGroup rgSmokeArea;
    RadioButton rbSmoke;
    RadioButton rbNoSmoke;
    Button btnReserve;
                Button btnReset;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);

                    etName = findViewById(R.id.etName);
                    etPhone = findViewById(R.id.etPhone);
                    etSize = findViewById(R.id.etSize);
                    tp = findViewById(R.id.timePicker);
                    dp = findViewById(R.id.datePicker);
                    rgSmokeArea = findViewById(R.id.rgSmokeArea);
                    rbSmoke = findViewById(R.id.rbSmoke);
                    rbNoSmoke = findViewById(R.id.rbNoSmoke);
                    btnReserve = findViewById(R.id.btnReserve);
                    btnReset = findViewById(R.id.btnReset);

                    tp.setCurrentHour(19);
                    tp.setCurrentMinute(30);
                    dp.updateDate(2020, 5, 1);

                    btnReserve.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String name = etName.getText().toString();
                            String phone = etPhone.getText().toString();
                            String size = etSize.getText().toString();
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                int year = dp.getYear();
                int month = dp.getMonth() + 1;
                int day = dp.getDayOfMonth();
                String pref = "";
                String newMin = "";
                if (rbSmoke.isChecked()) {
                    pref = "Smoking Area";
                } else if (rbNoSmoke.isChecked()) {
                    pref = "No Smoking Area";
                } else {
                    pref = "None";
                }

                if (min < 11){
                    newMin = "0"+ Integer.toString(min);
                } else {
                    newMin = Integer.toString(min);
                }

                Toast.makeText(MainActivity.this, "Name: "+name+
                        "\nPhone Number: "+phone+
                        "\nGroup Size: "+size+
                        "\nDate: "+day+"/"+month+"/"+year+
                        "\nTime: "+hour+":"+newMin+
                        "\nPreference: "+pref, Toast.LENGTH_LONG).show();

            }
    });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etName.getText().clear();
                etPhone.getText().clear();
                etSize.getText().clear();
                rgSmokeArea.clearCheck();
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 5, 1);

            }
});
    }
}