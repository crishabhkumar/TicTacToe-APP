package com.rishabhkumar.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final List<int[]> combinationList = new ArrayList();

    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

    private LinearLayout playerOneLayout,playerTwoLayout;
    private TextView playerOneName,playerTwoName;
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        playerOneLayout = findViewById(R.id.playerOneLayout);
        playerTwoLayout = findViewById(R.id.playerTwoLayout);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);


        combinationList.add(new int[] {0,1,2});
        combinationList.add(new int[] {3,4,5});
        combinationList.add(new int[] {6,7,8});
        combinationList.add(new int[] {0,3,6});
        combinationList.add(new int[] {1,4,7});
        combinationList.add(new int[] {2,5,8});
        combinationList.add(new int[] {3,6,9});


        final String getPlayerOneName = getIntent().getStringExtra("PlayerOne");
        final String getPlayerTwoName = getIntent().getStringExtra("PlayerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        image1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(0)){
                    performAction((ImageView)v, 0);
                }

            }
        });
        image2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(1)){
                    performAction((ImageView)v, 1);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(2)){
                    performAction((ImageView)v, 2);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(3)){
                    performAction((ImageView)v, 3);
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(4)){
                    performAction((ImageView)v, 4);
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(5)){
                    performAction((ImageView)v, 5);
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(6)){
                    performAction((ImageView)v, 6);
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(7)){
                    performAction((ImageView)v, 7);
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(8)){
                    performAction((ImageView)v, 8 );

                }
            }
        });


//        playerOneLayout.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//
//            }
//        });
//
//        playerTwoLayout.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//
//            }
//        });


    }

    private void performAction(ImageView imageview, int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = playerTurn;

        if(playerTurn == 1){
            imageview.setImageResource(R.drawable.cross);
            if(checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this, playerOneName.getText().toString() + "has won the game.", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(totalSelectedBoxes == 9){
                WinDialog winDialog = new WinDialog(MainActivity.this, "It is a draw.", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else{
            imageview.setImageResource(R.drawable.zero);
            if(checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this, playerTwoName.getText().toString() + "has won the game.", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(selectedBoxPosition == 9){
                WinDialog winDialog = new WinDialog(MainActivity.this, "It is a draw.", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else{
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }

    }



    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if(playerTurn == 1){
            playerOneLayout.setBackgroundResource(R.drawable.round_black_blue_border);
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
        else{
            playerTwoLayout.setBackgroundResource(R.drawable.round_black_blue_border);
            playerOneLayout.setBackgroundResource(R.drawable.round_back_dark_blue);

        }
    }

    private boolean checkPlayerWin(){
        boolean response = false;

        for(int i = 0; i< combinationList.size();i++){
            final int[] combination = combinationList.get(i);
            if(boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn
            && boxPositions[combination[2]] == playerTurn ){
                response = true;
            }
        }
        return response;
    }


    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition] == 0){
            response = true;
        }
        return response;
    }

    public void restartMatch(){
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectedBoxes = 1;
        image1.setImageResource(R.drawable.transparent);
        image2.setImageResource(R.drawable.transparent);
        image3.setImageResource(R.drawable.transparent);
        image4.setImageResource(R.drawable.transparent);
        image5.setImageResource(R.drawable.transparent);
        image6.setImageResource(R.drawable.transparent);
        image7.setImageResource(R.drawable.transparent);
        image8.setImageResource(R.drawable.transparent);
        image9.setImageResource(R.drawable.transparent);


    }

}