package com.example.tictacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0; //0-> circle,1-> cross
   int[] gameState={2,2,2,2,2,2,2,2,2}; //for white space
    int[][] winning = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean isGameActive = true;

    public void dropIn(View view) {
        ImageView img = (ImageView) view;
        int tappedimg = Integer.parseInt(img.getTag().toString());
        gameState[tappedimg] = activePlayer;

        if (isGameActive) {
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.yellow_circle);
                activePlayer = 1;
            } else {
                img.setImageResource(R.drawable.cross);
                activePlayer = 0;

            }
            img.setTranslationY(-500);
            img.animate().translationYBy(500).setDuration(300);

            for (int[] winning : winning) {
                if (gameState[winning[0]] == gameState[winning[1]] && gameState[winning[1]] == gameState[winning[2]] && gameState[winning[0]] != 2) {
                    // someone has won!
                    //Toast.makeText(this, "Someone has Won!", Toast.LENGTH_SHORT).show();
                    isGameActive = false;
                    if (activePlayer == 0) {
                        Toast.makeText(this, "Cross Wins !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, " Circle Wins !", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}