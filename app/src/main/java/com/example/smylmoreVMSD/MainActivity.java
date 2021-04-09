package com.example.smylmoreVMSD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int pin1, pin2, pin3, pin4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// Declaring via Array List
                ArrayList<String> number = new ArrayList<String>();
                number.add("1");
                number.add("2");
                number.add("3");
                number.add("4");
                number.add("5");
                number.add("6");
                number.add("7");
                number.add("8");
                number.add("9");
                number.add("");
                number.add("0");
               // number.add("X");

        //Printing GridView by ArrayAdapter
                ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.listview, number);
                GridView gridView = (GridView) findViewById(R.id.number);
                gridView.setAdapter(itemsAdapter);


        setpin1Value(gridView);

    }

    public void setpin1Value(GridView gridView){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                pin1 = 0;
                if(position<10){ pin1= position + 1;}
                else if(position==11){ pin1 = 0;}
//                else if(position==12){
//                    pin1 = 0; pin2 = 0; pin3 = 0; pin4 = 0;
//                    setPinTextValue(pin1,pin2,pin3,pin4);
//                }
                pin2=0; pin3=0; pin4=0;
                setPinTextValue(pin1,pin2,pin3,pin4);
                setpin2Value(gridView);
            }
        });
    }

    public void setpin2Value(GridView gridView){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if(position<10){ pin2= position + 1;}
                else if(position==11){ pin2 = 0;}
//                else if(position==12){
//                    pin1 = 0; pin2 = 0; pin3 = 0; pin4 = 0;
//                    setpin1Value(gridView);
//                    setPinTextValue(pin1,pin2,pin3,pin4);
//
//                }
                pin3=0; pin4=0;
                setPinTextValue(pin1,pin2,pin3,pin4);
                setpin3Value(gridView);
            }
        });
    }

    public void setpin3Value(GridView gridView){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if(position<10){ pin3= position + 1;}
                else if(position==11){ pin3 = 0;}
                pin4=0;
                setPinTextValue(pin1,pin2,pin3,pin4);
                setpin4Value(gridView);
            }
        });
    }

    public void setpin4Value(GridView gridView){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if(position<10){ pin4= position + 1;}
                else if(position==11){ pin4 = 0;}
//                else if(position==12){
//                    pin1 = 0; pin2 = 0; pin3 = 0; pin4 = 0;
//                    setpin3Value(gridView);
//                    setPinTextValue(pin1,pin2,pin3,pin4);
//                }
                setPinTextValue(pin1,pin2,pin3,pin4);
                validation(pin1,pin2,pin3,pin4,gridView);
            }
        });
    }


    private void setPinTextValue(int pin1,int pin2,int pin3,int pin4){
                ArrayList<Integer> pin = new ArrayList<Integer>();
                pin.add(pin1);
                pin.add(pin2);
                pin.add(pin3);
                pin.add(pin4);

        ArrayAdapter<Integer> pinTextView = new ArrayAdapter<Integer>(this, R.layout.listview, pin);
        GridView gridView = (GridView) findViewById(R.id.pin);
        gridView.setAdapter(pinTextView);
    }

    public void validation(int pin1,int pin2,int pin3,int pin4, GridView gridView){
        if(pin1 == 1 && pin2 == 7 && pin3==0 && pin4 ==3){
            Toast.makeText(MainActivity.this, "Correct Pin", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, home.class));
            pin1=0; pin2=0; pin3=0; pin4=0;
            setPinTextValue(pin1,pin2,pin3,pin4);
            setpin1Value(gridView);
            }
        else{
            Toast.makeText(MainActivity.this, "Wrong Pin" + pin1 + pin2 + pin3+ pin4, Toast.LENGTH_SHORT).show();
            pin1=0; pin2=0; pin3=0; pin4=0;
            setPinTextValue(pin1,pin2,pin3,pin4);
            setpin1Value(gridView);
        }
    }
}