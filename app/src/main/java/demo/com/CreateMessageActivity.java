package demo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    private EditText editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_create);

        editTextMsg = findViewById(R.id.editTextMessage);
        Button buttonSend = findViewById(R.id.buttonSend);
        Button buttonSendOut = findViewById(R.id.buttonSendOut);

        buttonSend.setOnClickListener(view -> {
            String msg = editTextMsg.getText().toString();
            Intent intent = new Intent(this, ReceivedMessageActivity.class);
            intent.putExtra("message", msg); // вложили в intent данные
            startActivity(intent);
        });

        buttonSendOut.setOnClickListener(view -> {
            String msg = editTextMsg.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, msg); // вложили в intent данные
            // дополнительный intent, чтобы невозможно было по умолчанию выбрать приложение
            Intent chosenIntent = Intent.createChooser(intent, getString(R.string.chooser_title));
            startActivity(chosenIntent);
        });
    }
}