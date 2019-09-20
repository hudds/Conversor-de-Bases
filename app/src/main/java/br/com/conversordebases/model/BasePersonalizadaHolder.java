package br.com.conversordebases.model;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class BasePersonalizadaHolder {

    private final EditText base;
    private final ConversorTextWatcher conversorTextWatcher;

    public BasePersonalizadaHolder(ConversorTextWatcher conversorTextWatcher, EditText base){
        this.base = base;
        this.conversorTextWatcher = conversorTextWatcher;

        this.base.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    conversorTextWatcher.setRadix(null);
                } else {
                    try {
                        conversorTextWatcher.setRadix(Integer.valueOf(charSequence.toString()));
                    } catch(NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }



    public void setEmptyText(){
        base.setText("");
    }

    public String getText(){
        return base.getText().toString().toLowerCase();
    }
}
