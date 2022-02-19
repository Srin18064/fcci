package com.devoloper.uibasics3; //6:56

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.nio.file.FileSystemNotFoundException;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbHarry, cbSpider, cbJoker;
    private RadioGroup rgMaritalStatus;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbHarry = findViewById(R.id.cbHarry);
        cbSpider = findViewById(R.id.cbSpider);
        cbJoker = findViewById(R.id.cbJoker);

        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);

        progressBar = findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i<10; i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();

        int checkedButton = rgMaritalStatus.getCheckedRadioButtonId();
        switch (checkedButton) {
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbRelationShip:
                Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.rbRelationShip:
                        Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });


        if (cbHarry.isChecked()) {
            Toast.makeText(MainActivity.this, "You have watched harry potter, Yay", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "You need to Watch the HarryPotter", Toast.LENGTH_SHORT).show();
        }

        cbHarry.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    Toast.makeText(MainActivity.this, "You have watched harry potter, Yay", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "You need to Watch the HarryPotter", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}