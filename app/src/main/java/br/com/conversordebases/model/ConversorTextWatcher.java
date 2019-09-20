package br.com.conversordebases.model;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.math.BigInteger;

public class ConversorTextWatcher implements TextWatcher {
    private Integer radix;
    private EditText editText;
    private final NumberDAO numberDAO;

    public ConversorTextWatcher(EditText editText, Integer radix, NumberDAO numberDAO){
        this.radix = radix;
        this.editText = editText;
        this.editText.addTextChangedListener(this);
        this.numberDAO = numberDAO;
    }

    public ConversorTextWatcher(EditText editText, NumberDAO numberDAO){
        this.editText = editText;
        this.editText.addTextChangedListener(this);
        this.numberDAO = numberDAO;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(editText.hasFocus()) {
            numberDAO.updateValues(charSequence, radix);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
    }


    public void setText(BigInteger number){
        if(radix == null){
            return;
        }
        editText.setText(number.toString(radix).toUpperCase());
    }


    public void setText(String value){
        editText.setText(value);
    }

    public int getRadix() {
        return radix;
    }

    public void setRadix(Integer radix) {
        this.radix = radix;
        String valorAtual = editText.getText().toString();
        BigInteger numero = numberDAO.getNumero();
        if (valorAtual.isEmpty()){
            if(numero != null) {
                editText.setText(numero.toString(this.radix));
            }

        } else {
            numberDAO.updateValues(valorAtual, radix);
        }
    }

    public String getText(){
        return editText.getText().toString().toLowerCase();
    }

}
