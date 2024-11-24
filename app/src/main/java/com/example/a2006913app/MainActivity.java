package com.example.a2006913app;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Server svr;
    Node currentNd;
    Button button1, button2;
    TextView tb1,tb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button5);
        tb1 = findViewById(R.id.textView);
        tb2 = findViewById(R.id.textView2);
        final MediaPlayer buttonSnd = MediaPlayer.create(this, R.raw.button_press);

        Resources rsc = getResources();
        InputStream inpStream = rsc.openRawResource(R.raw.storymap1);

        try {
            svr = new Server(inpStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        currentNd = svr.getNode(0);
        tb1.setText(currentNd.getDescription());//filling in the apps fields from just plain text
        tb2.setText(currentNd.getQuestion());

        button1.setOnClickListener(new View.OnClickListener() {   //When Yes is pressed
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                buttonSnd.start();
                yesNoPressed(0);//submitting answer as yes/no 0/1
            }

        });


        button2.setOnClickListener(new View.OnClickListener() {  //When No is Pressed
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                buttonSnd.start();
                yesNoPressed(1);//submitting answer as yes/no 0/1
            }
        });
    }


    private void yesNoPressed(int yesNo){
        int nextID = svr.getNextNode(yesNo, currentNd); //finding next nodes ID based off a yes/no
        currentNd = svr.getNode(nextID); //Changing node to the next node

        tb1.setText(currentNd.getDescription());//updating the app with new questions
        tb2.setText(currentNd.getQuestion());
    }
}
