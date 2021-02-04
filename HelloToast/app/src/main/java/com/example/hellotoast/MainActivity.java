package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button button ;
    private String count;
    public static final   String c="count";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Question1","La deuxième activité est ajoutée en tant que classe Java, le fichier de présentation (layout) XML est créé et le fichier AndroidManifest.xml est modifié pour déclarer une deuxième activité");
        Log.d("Question2","La deuxième activité n'apparaît plus lorsque vous essayez de la démarrer avec une intention (Intent) explicite.");
        Log.d("Question3","new Intent(Context context, Class<?> class)");
        Log.d("Question4","Comme extra d'intention (Intent)");
        Log.d("Question5","Obtenez l'intention (Intent) avec laquelle l'activité a été lancée");
        mShowCount = (TextView) findViewById(R.id.show_count);
        button=(Button)findViewById((R.id.button_toast));
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.show_count);
                count = textView.getText().toString();
                setMessageToSend();
            }



        });

    }
    private void setMessageToSend() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(c, count);
        startActivity(intent);
    }


    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}