package com.example.zhugejiao.psychoanalysis;

import android.app.Application;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button buttonYes;
    private Button buttonNO;
    private TextView textviewQuestion;
    private int count = 0;
    private int index = 0;
    private String[] judgementQuestions;
    private String[] judgementResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonYes = (Button) findViewById(R.id.buttonYes);
        buttonNO = (Button) findViewById(R.id.buttonNo);
        textviewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "+1", Toast.LENGTH_SHORT).show();
                count++;
                nextQuestion();


            }
        });
        buttonNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();

            }
        });
        initalDate();
    }

    private void nextQuestion() {
        if(index<judgementQuestions.length) {
            textviewQuestion.setText(judgementQuestions[index]);
            index++;
        }else{
            buttonYes.setVisibility(View.INVISIBLE);
            buttonNO.setVisibility(View.INVISIBLE);
            Toast.makeText(this,count+"",Toast.LENGTH_SHORT).show();
            textviewQuestion.setText(judgementResults[(count-1)/5]);
        }

    }

    private void initalDate() {
        judgementQuestions = getApplication().getResources().getStringArray(R.array.judgements);
        judgementResults = getApplication().getResources().getStringArray(R.array.judgeemnt_result);
        count = 0;
        nextQuestion();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
