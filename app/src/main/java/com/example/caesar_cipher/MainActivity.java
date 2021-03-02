package com.example.caesar_cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText text, key;
        TextView ctext;
        Button b1, b2;
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        text = findViewById(R.id.text);
        key = findViewById(R.id.key);
        ctext = findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text.getText().toString().isEmpty() && !key.getText().toString().isEmpty())
                {
                    Cipher c = new Cipher(Integer.parseInt(key.getText().toString()));
                    String data = c.encryption(text.getText().toString().toUpperCase());
                    ctext.setText("Encryption: \n" + data);
                }
                else
                    Toast.makeText(getApplicationContext(),"Please enter data",Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!text.getText().toString().isEmpty() && !key.getText().toString().isEmpty())
                {
                    Cipher c = new Cipher(Integer.parseInt(key.getText().toString()));
                    String data = c.decryption(text.getText().toString().toUpperCase());
                    ctext.setText("Decryption: \n" + data);
                }
                else
                    Toast.makeText(getApplicationContext(),"Please enter data",Toast.LENGTH_LONG).show();
            }
        });


    }
}

class Cipher
{
    int key;
    Cipher(int key)
    {
        this.key = key;
    }

    String encryption(String data)
    {
        String codeword = "";
        for(int i=0;i<data.length();i++)
        {
            char ch = data.charAt(i);
            ch += key;
            if((int)ch > 90)
                ch -= 26;

            codeword += ch;
        }
        return codeword;
    }

    String decryption(String codeword)
    {
        String data = "";
        for(int i=0;i<codeword.length();i++)
        {
            char ch = codeword.charAt(i);
            ch -= key;
            if((int)ch < 65)
                ch += 26;

            data += ch;
        }
        return data;
    }
}