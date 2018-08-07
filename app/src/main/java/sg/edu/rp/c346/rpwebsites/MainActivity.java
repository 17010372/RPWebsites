package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvCat;
    TextView tvSubCat;
    Spinner spn1;
    Spinner spn2;
    Button btnGo;

    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCat = findViewById(R.id.textViewCat);
        tvSubCat = findViewById(R.id.textViewSubCat);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        alCategory = new ArrayList<>();
        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i) {
                    case 0:
                        alCategory.clear();
                        String[] evenNumbers = getResources().getStringArray(R.array.main);

                        //Convert Array to List and add to the ArrayList
                        alCategory.addAll(Arrays.asList(evenNumbers));
                        spn2.setAdapter(aaCategory);
                        break;

                    case 1:
                        alCategory.clear();
                        String[] oddNumber = getResources().getStringArray(R.array.course);

                        //Convert Array to List and add to the ArrayList
                        alCategory.addAll(Arrays.asList(oddNumber));
                        spn2.setAdapter(aaCategory);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "";
                int pos1 = spn1.getSelectedItemPosition();
                int pos = spn2.getSelectedItemPosition();
                if(pos1 == 0) {
                    if (pos == 0) {
                        url = "https://www.rp.edu.sg/";
                    }
                    else {
                        url = "https://www.rp.edu.sg/student-life";
                    }
                }
                else{
                    if (pos == 0) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    }
                    else {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    }
                }
                Intent intent = new Intent(getBaseContext(), WebPageActivity.class);
                intent.putExtra("link", url);
                startActivity(intent);
            }
        });


    }
}