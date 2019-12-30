package com.example.grapoffline;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32;
    private EditText input_function, from_x, to_x;
    private Spinner spinner;
    private int brackets = 0, moduls = 0, flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decart);
        input_function = (EditText) findViewById(R.id.input_function);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b10 = (Button) findViewById(R.id.button10);
        b11 = (Button) findViewById(R.id.button11);
        b12 = (Button) findViewById(R.id.button12);
        b13 = (Button) findViewById(R.id.button13);
        b14 = (Button) findViewById(R.id.button14);
        b15 = (Button) findViewById(R.id.button15);
        b16 = (Button) findViewById(R.id.button16);
        b17 = (Button) findViewById(R.id.button17);
        b18 = (Button) findViewById(R.id.button18);
        b19 = (Button) findViewById(R.id.button19);
        b20 = (Button) findViewById(R.id.button20);
        b21 = (Button) findViewById(R.id.button21);
        b22 = (Button) findViewById(R.id.button22);
        b23 = (Button) findViewById(R.id.button23);
        b24 = (Button) findViewById(R.id.button24);
        b25 = (Button) findViewById(R.id.button25);
        b26 = (Button) findViewById(R.id.button26);
        b27 = (Button) findViewById(R.id.button27);
        b28 = (Button) findViewById(R.id.button28);
        b29 = (Button) findViewById(R.id.button29);
        b30 = (Button) findViewById(R.id.button30);
        b31 = (Button) findViewById(R.id.button31);
        b32 = (Button) findViewById(R.id.button32);
        from_x = (EditText) findViewById(R.id.from_x);
        to_x = (EditText) findViewById(R.id.to_x);
        spinner = (Spinner) findViewById(R.id.spinner);

        b7.setOnLongClickListener(this);
        b8.setOnLongClickListener(this);
        b9.setOnLongClickListener(this);
        b10.setOnLongClickListener(this);
        b11.setOnLongClickListener(this);
        b31.setOnLongClickListener(this);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);
        b17.setOnClickListener(this);
        b18.setOnClickListener(this);
        b19.setOnClickListener(this);
        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        b23.setOnClickListener(this);
        b24.setOnClickListener(this);
        b25.setOnClickListener(this);
        b26.setOnClickListener(this);
        b27.setOnClickListener(this);
        b28.setOnClickListener(this);
        b29.setOnClickListener(this);
        b30.setOnClickListener(this);
        b31.setOnClickListener(this);
        b32.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_Cartesian:
                flag = 0;
                b5.setText(R.string.x);
                item.setChecked(true);
                return true;
            case R.id.action_Polar:
                item.setChecked(true);
                flag = 1;
                input_function.setHint(R.string.alpha);
                b5.setText(R.string.alpha);
                return true;
            case R.id.action_Parametric:
                item.setChecked(true);
                flag = 2;
                return true;
            case R.id.action_About:
                Intent intent2 = new Intent(MainActivity.this, About.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        switch (v.getId()) {
            case R.id.button7:
                popupMenu.inflate(R.menu.menu_log);
                break;
            case R.id.button8:
                popupMenu.inflate(R.menu.menu_sin);
                break;
            case R.id.button9:
                popupMenu.inflate(R.menu.menu_cos);
                break;
            case R.id.button10:
                popupMenu.inflate(R.menu.menu_tg);
                break;
            case R.id.button11:
                popupMenu.inflate(R.menu.menu_ctg);
                break;
        }


        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        input_function.append(item.getTitle() + "(");
                        brackets++;
                        return true;
                    case R.id.menu2:
                        input_function.append(item.getTitle() + "(");
                        brackets++;
                        return true;
                    case R.id.menu3:
                        input_function.append(item.getTitle() + "(");
                        brackets++;
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.button31) {
            input_function.setText("");
            brackets = 0;
            moduls = 0;
        } else showPopupMenu(v);
        return true;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                input_function.append(getText(R.string.pi));
                break;
            case R.id.button2:
                input_function.append(getText(R.string.exp));
                break;
            case R.id.button3:
                input_function.append(getText(R.string.module));
                moduls++;
                break;
            case R.id.button4:
                input_function.append(getText(R.string.degree) + "(");
                brackets++;
                break;
            case R.id.button5:
                if (flag == 0) input_function.append(getText(R.string.x));
                else if (flag == 1) input_function.append(getText(R.string.alpha));
                break;
            case R.id.button6:
                input_function.append(getText(R.string.square) + "(");
                brackets++;
                break;
            case R.id.button7:
                input_function.append(getText(R.string.log) + "(");
                brackets++;
                break;
            case R.id.button8:
                input_function.append(getText(R.string.sin) + "(");
                brackets++;
                break;
            case R.id.button9:
                input_function.append(getText(R.string.cos) + "(");
                brackets++;
                break;
            case R.id.button10:
                input_function.append(getText(R.string.tg) + "(");
                brackets++;
                break;
            case R.id.button11:
                input_function.append(R.string.ctg + "(");
                brackets++;
                break;
            case R.id.button12:
                input_function.append(getText(R.string._1));
                break;
            case R.id.button13:
                input_function.append(getText(R.string._2));
                break;
            case R.id.button14:
                input_function.append(getText(R.string._3));
                break;
            case R.id.button15:
                input_function.append(getText(R.string.division));
                break;
            case R.id.button16:
                input_function.append(getText(R.string._4));
                break;
            case R.id.button17:
                input_function.append(getText(R.string._5));
                break;
            case R.id.button18:
                input_function.append(getText(R.string._6));
                break;
            case R.id.button19:
                input_function.append(getText(R.string.multiplication));
                break;
            case R.id.button20:
                input_function.append(getText(R.string._7));
                break;
            case R.id.button21:
                input_function.append(getText(R.string._8));
                break;
            case R.id.button22:
                input_function.append(getText(R.string._9));
                break;
            case R.id.button23:
                input_function.append(getText(R.string.minus));
                break;
            case R.id.button24:
                input_function.append(getText(R.string._0));
                break;
            case R.id.button25:
                input_function.append(getText(R.string.space));
                break;
            case R.id.button26:
                input_function.append(getText(R.string.dot));
                break;
            case R.id.button27:
                input_function.append(getText(R.string.plus));
                break;
            case R.id.button28:
                input_function.append(getText(R.string.left_bracket));
                brackets++;
                break;
            case R.id.button29:
                if (brackets > 0) {
                    input_function.append(getText(R.string.right_bracket));
                    brackets--;
                }
                break;
            case R.id.button30:
                input_function.append(getText(R.string.equivalent));
                break;
            case R.id.button31:
                if (input_function.getText().length() != 0) {
                    if (input_function.getText().toString().substring(input_function.getText().length() - 1).equals("(")) {
                        brackets--;
                    }
                    if (input_function.getText().toString().substring(input_function.getText().length() - 1).equals(")")) {
                        brackets++;
                    }
                    if (input_function.getText().toString().substring(input_function.getText().length() - 1).equals("|")) {
                        moduls--;
                    }
                    input_function.setText(input_function.getText().delete(input_function.length() - 1, input_function.length()));
                }
                input_function.setSelection(input_function.length());
                break;
            case R.id.button32:
                Toast toast;
                if (brackets == 0 & moduls % 2 == 0) {
                    if (Integer.parseInt(from_x.getText().toString()) < Integer.parseInt(to_x.getText().toString())) {
                        Intent intent3 = new Intent(MainActivity.this, Graph.class);
                        intent3.putExtra("Input function", input_function.getText().toString() + "+0");
                        intent3.putExtra("Flag", flag);
                        intent3.putExtra("From", Integer.parseInt(from_x.getText().toString()));
                        intent3.putExtra("To", Integer.parseInt(to_x.getText().toString()));
                        intent3.putExtra("Color", spinner.getSelectedItem().toString());
                        startActivity(intent3);
                        break;
                    } else {
                        toast = Toast.makeText(getApplicationContext(), "Некорректный интервал", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    }
                } else {
                    toast = Toast.makeText(getApplicationContext(), "Отсуствует закрывающая скобка", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }

        }
    }
}
