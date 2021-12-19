package com.example.auxhall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

import android.annotation.SuppressLint;
import android.content.ClipDescription;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vanniktech.emoji.EmojiEditText;
import com.vanniktech.emoji.EmojiPopup;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton keyboardButton;
    LinearLayout mainLayout, hideKeyBoardButton;
    LinearLayout stickersButton, emojisButton, gifsButton, avatarsButton;
    LinearLayout stickerLayout, emojisLayout, gifsLayout, avatarsLayout;
    EmojiEditText etEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyboardButton = findViewById(R.id.floating_action_button);
        mainLayout = findViewById(R.id.mainLayoutID);
        hideKeyBoardButton = findViewById(R.id.hideKeyBoardButtonID);


        keyboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_up);
                mainLayout.startAnimation(bottomUp);
                keyboardButton.setVisibility(View.GONE);
                mainLayout.setVisibility(View.VISIBLE);
            }
        });

        hideKeyBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_down);
                mainLayout.startAnimation(bottomUp);
                keyboardButton.setVisibility(View.VISIBLE);
                mainLayout.setVisibility(View.GONE);
            }
        });

        stickersButton = findViewById(R.id.stickersButtonID);
        emojisButton = findViewById(R.id.emojisButtonID);
        gifsButton = findViewById(R.id.gifsButtonID);
        avatarsButton = findViewById(R.id.avatarsButtonID);

        emojisLayout = findViewById(R.id.emojisLayoutID);
        stickerLayout = findViewById(R.id.stickerLayoutID);
        gifsLayout = findViewById(R.id.gifsLayoutID);
        avatarsLayout = findViewById(R.id.avatarsLayoutID);

        stickersButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                stickerLayout.setVisibility(View.VISIBLE);
                emojisLayout.setVisibility(View.GONE);
                gifsLayout.setVisibility(View.GONE);
                avatarsLayout.setVisibility(View.GONE);

                stickersButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.light_grey));
                emojisButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                gifsButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                avatarsButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            }
        });

        emojisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerLayout.setVisibility(View.GONE);
                emojisLayout.setVisibility(View.VISIBLE);
                gifsLayout.setVisibility(View.GONE);
                avatarsLayout.setVisibility(View.GONE);

                stickersButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                emojisButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.light_grey));
                gifsButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                avatarsButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                /*LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View myView = inflater.inflate(R.layout.activity_main, null);
                emojisLayout.addView(myView);

                final EmojiPopup emojiPopup = EmojiPopup.Builder.fromRootView(findViewById(R.id.emojisLayoutID)).build(etEmoji);
                emojiPopup.toggle(); // Toggles visibility of the Popup.
                emojiPopup.dismiss(); // Dismisses the Popup.
                emojiPopup.isShowing();*/
            }
        });

        gifsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerLayout.setVisibility(View.GONE);
                emojisLayout.setVisibility(View.GONE);
                gifsLayout.setVisibility(View.VISIBLE);
                avatarsLayout.setVisibility(View.GONE);

                stickersButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                emojisButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                gifsButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.light_grey));
                avatarsButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            }
        });

        avatarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerLayout.setVisibility(View.GONE);
                emojisLayout.setVisibility(View.GONE);
                gifsLayout.setVisibility(View.GONE);
                avatarsLayout.setVisibility(View.VISIBLE);

                stickersButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                emojisButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                gifsButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                avatarsButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.light_grey));
            }
        });

        EditText editText = new androidx.appcompat.widget.AppCompatEditText(this) {
            @Override
            public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
                final InputConnection ic = super.onCreateInputConnection(editorInfo);
                EditorInfoCompat.setContentMimeTypes(editorInfo, new String[]{"image/png"});

                final InputConnectionCompat.OnCommitContentListener callback =
                        new InputConnectionCompat.OnCommitContentListener() {
                            @Override
                            public boolean onCommitContent(InputContentInfoCompat inputContentInfo,
                                                           int flags, Bundle opts) {
                                // read and display inputContentInfo asynchronously
                                if (BuildCompat.isAtLeastNMR1() && (flags &
                                        InputConnectionCompat.INPUT_CONTENT_GRANT_READ_URI_PERMISSION) != 0) {
                                    try {
                                        inputContentInfo.requestPermission();
                                    } catch (Exception e) {
                                        return false; // return false if failed
                                    }
                                }

                                // read and display inputContentInfo asynchronously.
                                // call inputContentInfo.releasePermission() as needed.

                                return true;  // return true if succeeded
                            }
                        };
                return InputConnectionCompat.createWrapper(ic, editorInfo, callback);
            }
        };
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {
        String[] mimeTypes = EditorInfoCompat.getContentMimeTypes(editorInfo);


        boolean gifSupported = false;
        for (String mimeType : mimeTypes) {
            if (ClipDescription.compareMimeTypes(mimeType, "image/gif")) {
                gifSupported = true;
            }
        }

        if (gifSupported) {
            // the target editor supports GIFs. enable corresponding content
        } else {
            // the target editor does not support GIFs. disable corresponding content
        }
    }

    /**
     * Commits a GIF image
     *
     * @param contentUri Content URI of the GIF image to be sent
     * @param imageDescription Description of the GIF image to be sent
     */
    public static void commitGifImage(Uri contentUri, String imageDescription) {
        InputContentInfoCompat inputContentInfo = new InputContentInfoCompat(
                contentUri,
                new ClipDescription(imageDescription, new String[]{"image/gif"}),
                null
        );
        InputConnection inputConnection = getCurrentInputConnection();
        EditorInfo editorInfo = getCurrentInputEditorInfo();
        Int flags = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            flags |= InputConnectionCompat.INPUT_CONTENT_GRANT_READ_URI_PERMISSION;
        }
        InputConnectionCompat.commitContent(
                inputConnection, editorInfo, inputContentInfo, flags, null);
    }


}