package com.example.projectsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectsqlite.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {
    EditText etNombre, etTelefono, etCorreoElectronico;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        etNombre = (EditText)findViewById(R.id.etName);
        etTelefono = (EditText)findViewById(R.id.etPhone);
        etCorreoElectronico = (EditText)findViewById(R.id.etEmail);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertarContacto(etNombre.getText().toString(),
                        etTelefono.getText().toString(),
                        etCorreoElectronico.getText().toString());
                if(id > 0) {
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiar() {
        etNombre.setText("");
        etTelefono.setText("");
        etCorreoElectronico.setText("");
    }
}