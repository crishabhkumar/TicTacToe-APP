package com.rishabhkumar.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinDialog extends Dialog {

    private final String message;
    private final MainActivity mainActivity;

    public WinDialog(@NonNull Context context,String msg,MainActivity mnAct) {
        super(context);
        this.message = msg;
        this.mainActivity = mnAct;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);
        
        final TextView messageTextBtn = findViewById(R.id.messageTextBtn);
        final Button startAgainBtn = findViewById(R.id.startAgainBtn);

        messageTextBtn.setText(message);


        startAgainBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mainActivity.restartMatch();
                dismiss();
            }
        });

    }
}
