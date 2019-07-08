package id.inixindosurabaya.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*
        ini adalah komentar banyak baris
        Tuliskan semua komponen yang ada dalam layout
    */
    // GLOBAL VARIABLES
    private Button btn_toast, btn_counter, btn_send;
    private TextView txt_display;
    private int myCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mengenali komponen dalam layout
        txt_display = findViewById(R.id.txt_display);
        btn_toast = findViewById(R.id.btn_toast);
        btn_counter = findViewById(R.id.btn_counter);
        btn_send = findViewById(R.id.btn_send);

        // memberi event handling pada komponen btn_toast
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // perintah memunculkan toast
                Toast.makeText(MainActivity.this,
                        "Anda mengklik tombol Toast!",
                        Toast.LENGTH_LONG).show();
            }
        });

        // memberi event handling pada komponen btn_counter
        btn_counter.setOnClickListener(this);
        // memberi event handling pada komponen btn_send
        btn_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btn_counter) {
            // perintah untuk counter
            myCount++;
            if (txt_display != null) {
                txt_display.setText(Integer.toString(myCount));
            }
        }
        else if (view == btn_send) {
            // perintah untuk send
            String data = txt_display.getText().toString();
            // mengirim data dari main activity menuju secondary activity
            Intent myIntent = new Intent(MainActivity.this,
                    SecondaryActivity.class);
            // carry the data
            myIntent.putExtra(Intent.EXTRA_TEXT, data);
            startActivity(myIntent);
        }
    }
}
