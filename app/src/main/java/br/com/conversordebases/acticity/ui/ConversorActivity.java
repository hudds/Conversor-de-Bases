package br.com.conversordebases.acticity.ui;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.conversordebases.R;
import br.com.conversordebases.model.BasePersonalizadaHolder;
import br.com.conversordebases.model.ConversorTextWatcher;
import br.com.conversordebases.model.NumberDAO;

public class ConversorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);
        setTitle("Conversor de Bases Numéricas");

        NumberDAO numberDAO = new NumberDAO();

        ConversorTextWatcher decimal = new ConversorTextWatcher((EditText) findViewById(R.id.editText_decimal), 10, numberDAO);
        ConversorTextWatcher binario = new ConversorTextWatcher((EditText) findViewById(R.id.editText_binario), 2, numberDAO);
        ConversorTextWatcher octal = new ConversorTextWatcher((EditText) findViewById(R.id.editText_octal), 8, numberDAO);
        ConversorTextWatcher hexadecimal = new ConversorTextWatcher((EditText) findViewById(R.id.editText_hexadecimal), 16, numberDAO);
        ConversorTextWatcher numeroPersonalizada1 = new ConversorTextWatcher((EditText) findViewById(R.id.editText_numero_base_personalizado_1), numberDAO);
        ConversorTextWatcher numeroPersonalizada2 = new ConversorTextWatcher((EditText) findViewById(R.id.editText_numero_base_personalizado_2), numberDAO);

        BasePersonalizadaHolder basePersonalizada1 = new BasePersonalizadaHolder(numeroPersonalizada1, findViewById(R.id.editText_base_personalizado_1));
        BasePersonalizadaHolder basePersonalizada2 = new BasePersonalizadaHolder(numeroPersonalizada2, findViewById(R.id.editText_base_personalizado_2));

        numberDAO.addAll(decimal, binario, hexadecimal, octal, numeroPersonalizada1, numeroPersonalizada2);

    }

}
