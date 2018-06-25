package calculator.a1311511032.mobileprogramming.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText textInput;
    TextView labelResult;
    Double integerBefore;
    DecimalFormat df = new DecimalFormat("###.#");
    String Action = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = (EditText) findViewById(R.id.textInput);
        labelResult = (TextView) findViewById(R.id.labelResult);
        integerBefore = 0.0;

        Button buttonTambah = (Button) findViewById(R.id.buttonTambah);
        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTambah();
            }
        });

        Button buttonKurang = (Button) findViewById(R.id.buttonKurang);
        buttonKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKurang();
            }
        });

        Button buttonKali = (Button) findViewById(R.id.buttonKali);
        buttonKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKali();
            }
        });

        Button buttonBagi = (Button) findViewById(R.id.buttonBagi);
        buttonBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBagi();
            }
        });

        Button buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onReset();
            }
        });

        textInput.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if (!textInput.getText().toString().isEmpty()) {
                        if (Action == "tambah") {
                            Double Value = Double.parseDouble(textInput.getText().toString());
                            textInput.setText("");
                            if (integerBefore <= 0) {
                                labelResult.setText(df.format(Value).toString());
                            } else {
                                labelResult.setText(df.format(new Double(integerBefore + Value)).toString());
                            }

                            Action = "";
                            integerBefore = new Double(integerBefore + Value);
                        } else if (Action == "kurang") {
                            Double Value = Double.parseDouble(textInput.getText().toString());
                            textInput.setText("");
                            if (integerBefore <= 0) {
                                labelResult.setText(df.format(Value).toString());
                            } else {
                                labelResult.setText(df.format(new Double(integerBefore - Value)).toString());
                            }

                            Action = "";
                            integerBefore = new Double(integerBefore - Value);
                        } else if (Action == "kali") {
                            Double Value = Double.parseDouble(textInput.getText().toString());
                            textInput.setText("");
                            if (integerBefore <= 0) {
                                labelResult.setText(df.format(Value).toString());
                            } else {
                                labelResult.setText(df.format(new Double(integerBefore * Value)).toString());
                            }

                            Action = "";
                            integerBefore = new Double(integerBefore * Value);
                        } else if (Action == "bagi") {
                            Double Value = Double.parseDouble(textInput.getText().toString());
                            textInput.setText("");
                            if (integerBefore <= 0) {
                                labelResult.setText(df.format(Value).toString());
                            } else {
                                labelResult.setText(df.format(new Double(integerBefore / Value)).toString());
                            }

                            Action = "";
                            integerBefore = new Double(integerBefore / Value);
                        }
                    }
                    return true;
                } else {
                    if (Action == "") {
                        integerBefore = 0.0;
                    }
                }
                return false;
            }
        });
    }

    private void onTambah() {
        Action = "tambah";
        if (!textInput.getText().toString().isEmpty()) {
            Double Value = Double.parseDouble(textInput.getText().toString());
            textInput.setText("");
            if (integerBefore <= 0) {
                labelResult.setText(df.format(Value).toString());
            } else {
                labelResult.setText(df.format(new Double(integerBefore + Value)).toString());
            }

            integerBefore = Value;
        }
    }
    private void onKurang() {
        Action = "kurang";
        if (!textInput.getText().toString().isEmpty()) {
            Double Value = Double.parseDouble(textInput.getText().toString());
            textInput.setText("");
            if (integerBefore <= 0) {
                labelResult.setText(df.format(Value).toString());
            } else {
                labelResult.setText(df.format(new Double(integerBefore - Value)).toString());
            }

            integerBefore = Value;
        }
    }
    private void onKali() {
        Action = "kali";
        if (!textInput.getText().toString().isEmpty()) {
            Double Value = Double.parseDouble(textInput.getText().toString());
            textInput.setText("");
            if (integerBefore <= 0) {
                labelResult.setText(df.format(Value).toString());
            } else {
                labelResult.setText(df.format(new Double(integerBefore * Value)).toString());
            }

            integerBefore = Value;
        }
    }
    private void onBagi() {
        Action = "bagi";
        if (!textInput.getText().toString().isEmpty()) {
            Double Value = Double.parseDouble(textInput.getText().toString());
            textInput.setText("");
            if (integerBefore <= 0) {
                labelResult.setText(df.format(Value).toString());
            } else {
                labelResult.setText(df.format(new Double(integerBefore / Value)).toString());
            }

            integerBefore = Value;
        }
    }
    private void onReset() {
        textInput.setText("");
        labelResult.setText("");
    }
}
