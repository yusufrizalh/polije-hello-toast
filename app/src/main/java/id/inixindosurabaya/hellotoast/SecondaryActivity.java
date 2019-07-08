package id.inixindosurabaya.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    // GLOBAL VARIABLES
    private TextView txt_display_2;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        // memunculkan icon back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // mengenali semua komponen dalam layout
        txt_display_2 = findViewById(R.id.txt_display_2);
        btn_back = findViewById(R.id.btn_back);

        // event handling untuk txt_display_2
        Intent myIntent_2 = getIntent();
        String msg_2 = myIntent_2.getStringExtra(Intent.EXTRA_TEXT);
        txt_display_2.setText(msg_2);

        // event handling btn_back
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondaryActivity.this,
                        MainActivity.class));
                finish();   // reset counter menjadi 0 (nilai awal)
            }
        });

    }

    // event handling back button
    public void onBackPressed() {
        startActivity(new Intent(SecondaryActivity.this,
                MainActivity.class));
        finish();   // reset counter menjadi 0 (nilai awal)
    }

    // memunculkan simbol <-
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
