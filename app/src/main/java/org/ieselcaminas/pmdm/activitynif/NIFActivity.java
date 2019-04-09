package org.ieselcaminas.pmdm.activitynif;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NIFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_nif_layout);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String s = extras.getString("name");
        TextView name = findViewById(R.id.greetingLabel);
        name.setText(s);

        Button button = findViewById(R.id.buttonOk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText editTextNif = findViewById(R.id.editTextNif);
                Dni dni = null;
                try {
                    dni = new Dni(editTextNif.getText().toString());
                    intent.putExtra("nif", dni.toFormattedString());
                    setResult(RESULT_OK, intent);
                    finish();
                } catch (NIFException e) {
                    createDialog().show();
                }
            }
        });
    }
    private Dialog createDialog() {
        return new AlertDialog.Builder(this).setTitle("ERROR").setMessage("Please enter a correct NIF").create();
    }
}