package com.example.listy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView kresylista;
    ArrayList<String> kresy;
    ArrayAdapter<String> adapter;
    Button dodaj;
    private EditText wejscie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kresylista = findViewById(R.id.kresy);
        kresy = new ArrayList<>();
        kresy.add("Ovatrax");
        kresy.add("Port city of Guixu");
        kresy.add("kwiecień 2027");
        kresy.add("czerwiec 2039");
         adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,kresy);
         kresylista.setAdapter(adapter);
         kresylista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 kresy.remove(i);
                 adapter.notifyDataSetChanged();
             }
         });
         dodaj = findViewById(R.id.zmiana);
         dodaj.setOnClickListener(view -> dodanie());
         wejscie = findViewById(R.id.wejscie);
    }

    private void dodanie() {
        kresy.add(wejscie.getText().toString());
        adapter.notifyDataSetChanged();

    }
}