package com.rishabhkumar.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText playerOne = findViewById(R.id.playerFirst);
        final EditText playerTwo = findViewById(R.id.playerSecond);
        final EditText startGameBtn = findViewById(R.id.startGameBtn);

        startGameBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v){
                        final String getPlayerOneName = playerOne.getText().toString();
                        final String getPlayerTwoName = playerTwo.getText().toString();

                        if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                            Toast.makeText(AddPlayers.this,"Please enter player names",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Intent intent = new Intent(AddPlayers.this,MainActivity.class);
                            intent.putExtra("PlayerOne",getPlayerOneName);
                            intent.putExtra("PlayerTwo",getPlayerTwoName);
                            startActivity(intent);
                        }
                    }
                }
        );

    }
}