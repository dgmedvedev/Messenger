package demo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivedMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_message);

        TextView textViewReceivedMessage = findViewById(R.id.textViewReceivedMessage);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("message");

        textViewReceivedMessage.setText(msg);
    }
}