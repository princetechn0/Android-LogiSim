package com.example.logicsimulator;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;


public class LogicSimulator extends Activity implements View.OnClickListener {
    Point size;
    Bitmap blankBitmap;
    ImageView gameView;
    GridAndMenu gridAndMenu;
    TouchProcessor touchProcessor;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializer();
        toast = Toast.makeText(this,
                "Welcome to our App. For a Quick Introduction on How to Use it, Click Intro on the Bottom Right!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.play:
                gridAndMenu.doButtonTouch(0);
                break;
            case R.id.sub:
                gridAndMenu.doButtonTouch(1);
                break;
            case R.id.wire:
                gridAndMenu.doButtonTouch(2);
                break;
            case R.id.and:
                gridAndMenu.doButtonTouch(3);
                break;
            case R.id.or:
                gridAndMenu.doButtonTouch(4);
                break;
            case R.id.not:
                gridAndMenu.doButtonTouch(5);
                break;
            case R.id.sw:
                gridAndMenu.doButtonTouch(6);
                break;
            case R.id.led:
                gridAndMenu.doButtonTouch(7);
                break;
            case R.id.toggle:
                gridAndMenu.doButtonTouch(8);
                break;
            case R.id.intro:
                mediaPlayer();
                break;
            case R.id.save:
                gridAndMenu.doButtonTouch(10);
                break;
            case R.id.aButton:
                gridAndMenu.doButtonTouch(11);
                break;
            case R.id.bButton:
                gridAndMenu.doButtonTouch(12);
                break;
            case R.id.cButton:
                gridAndMenu.doButtonTouch(13);
                break;
            case R.id.undo:
                gridAndMenu.doButtonTouch(14);
                break;
            case R.id.redo:
                gridAndMenu.doButtonTouch(15);
                break;
            case R.id.nand:
                gridAndMenu.doButtonTouch(16);
                break;
            case R.id.xor:
                gridAndMenu.doButtonTouch(17);
                break;
            case R.id.clear:
                gridAndMenu.doButtonTouch(18);
                break;
            case R.id.random:
                gridAndMenu.doButtonTouch(19);
                break;
            default:
                toast = Toast.makeText(this, "NOT WORKING", Toast.LENGTH_SHORT);
        }
        gridAndMenu.updateScreen();
    }


    public void createButtons() {
        Button playButton = findViewById(R.id.play);
        playButton.setOnClickListener(this);

        Button subButton = findViewById(R.id.sub);
        subButton.setOnClickListener(this);

        Button wireButton = findViewById(R.id.wire);
        wireButton.setOnClickListener(this);

        Button andButton = findViewById(R.id.and);
        andButton.setOnClickListener(this);

        Button orButton = findViewById(R.id.or);
        orButton.setOnClickListener(this);

        Button notButton = findViewById(R.id.not);
        notButton.setOnClickListener(this);

        Button switchButton = findViewById(R.id.sw);
        switchButton.setOnClickListener(this);

        Button ledButton = findViewById(R.id.led);
        ledButton.setOnClickListener(this);

        Button toggleButton = findViewById(R.id.toggle);
        toggleButton.setOnClickListener(this);

        Button introButton = findViewById(R.id.intro);
        introButton.setOnClickListener(this);

        Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(this);

        Button AButton = findViewById(R.id.aButton);
        AButton.setOnClickListener(this);

        Button BButton = findViewById(R.id.bButton);
        BButton.setOnClickListener(this);

        Button CButton = findViewById(R.id.cButton);
        CButton.setOnClickListener(this);

        Button undoButton = findViewById(R.id.undo);
        undoButton.setOnClickListener(this);

        Button redoButton = findViewById(R.id.redo);
        redoButton.setOnClickListener(this);

        Button nandButton = findViewById(R.id.nand);
        nandButton.setOnClickListener(this);

        Button xorButton = findViewById(R.id.xor);
        xorButton.setOnClickListener(this);

        Button clearButton = findViewById(R.id.clear);
        clearButton.setOnClickListener(this);

        Button randomButton = findViewById(R.id.random);
        randomButton.setOnClickListener(this);
    }

    //Create our objects
    void setObjects() {
        blankBitmap = Bitmap.createBitmap(size.x, size.y,
                Bitmap.Config.ARGB_8888);
        gameView = findViewById(R.id.gridView);
        gridAndMenu = new GridAndMenu(this,size.x, blankBitmap);
        touchProcessor = new TouchProcessor(gridAndMenu);
    }

    void getResolution() {
        Display display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
    }

    void initializer() {
        getResolution();
        setContentView(R.layout.button_menu);
        createButtons();
        setObjects();
        gridAndMenu.updateScreen();
        gameView.setImageBitmap(blankBitmap);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // Has the player removed their finger from the screen?
        if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
            gameView.setImageBitmap(blankBitmap);
            touchProcessor.processTouch(motionEvent);
            if(gridAndMenu.introducing){
                mediaPlayer();
            }else
                gridAndMenu.updateScreen();
        }
        return true;
    }


    //Plays Intro Video
    void mediaPlayer(){
        setContentView(R.layout.activity_main);
        final VideoView wview = findViewById(R.id.videoview);
        String videoPath = "android.resource://"+ getPackageName()+ "/" + R.raw.fd;
        Uri uri = Uri.parse(videoPath);
        wview.setVideoURI(uri);
        wview.start();
        wview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                //write your code after complete video play
                wview.setVisibility(View.GONE);
                initializer();
                //Disable introducing
                gridAndMenu.introducing=false;
            }
        });
        //Exit Button
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //write your code after complete video play
                wview.setVisibility(View.GONE);
                initializer();
                //Disable introducing
                gridAndMenu.introducing=false;
            }
        });
    }

}