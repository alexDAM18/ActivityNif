package org.ieselcaminas.pmdm.activitynif;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNif = findViewById(R.id.buttonNIF);
        buttonNif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NIFActivity.class);
                EditText editTextName = findViewById(R.id.editTextName);
                intent.putExtra("name", editTextName.getText().toString());
                startActivityForResult(intent, 1234);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK) {
            Bundle extras = data.getExtras();
            String res = extras.getString("nif");
            TextView nif = findViewById(R.id.textViewNif);
            nif.setText(res);
        }
    }
}