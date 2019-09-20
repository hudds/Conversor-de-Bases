package br.com.conversordebases.model;

import android.util.Log;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class NumberDAO {

    private static BigInteger numero;
    private final ArrayList<ConversorTextWatcher> textWatchers = new ArrayList<>();

    public NumberDAO(ConversorTextWatcher ... textWatchers){
        this.textWatchers.addAll(Arrays.asList(textWatchers));
    }

    public NumberDAO(Collection<ConversorTextWatcher> textWatchers){
        this.textWatchers.addAll(textWatchers);
    }

    public NumberDAO(){
    }

    public void addAll(Collection<ConversorTextWatcher> collection){
        textWatchers.addAll(collection);
    }

    public void addAll(ConversorTextWatcher ... textWatchers){
        this.textWatchers.addAll(Arrays.asList(textWatchers));
    }

    public void updateValues(CharSequence value, Integer radix){
        if(radix == null){
            return;
        }
        String text = value.toString().toLowerCase();
        boolean invalidNumber = false;
        try {
            numero = new BigInteger(text, radix);
            Log.i("MeuDebug", "Criou bigInteger");

            for (ConversorTextWatcher editTextHolder : textWatchers) {
                {
                    Log.i("MeuDebug", "Fazendo loop");
                    if (!text.equals(editTextHolder.getText())) {
                        editTextHolder.setText(numero);
                        Log.i("MeuDebug", "Setando texto");
                    }
                }

            }
        } catch (NumberFormatException e){
            Log.i("MeuDebug", "Caiu no catch");
            e.printStackTrace();
            invalidNumber = true;
            for (ConversorTextWatcher editTextHolder : textWatchers) {
                if (text.isEmpty()) {
                    if (!text.equals(editTextHolder.getText())) {
                        editTextHolder.setText("");
                    }
                }
            }
        }
    }

    public static BigInteger getNumero() {
        return numero;
    }
}
