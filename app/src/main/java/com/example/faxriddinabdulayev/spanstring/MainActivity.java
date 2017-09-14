package com.example.faxriddinabdulayev.spanstring;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SpannableString styledString
                = new SpannableString("Big text "     // index 0 - 8
                + "Bold text style\n\n"          // index 9 - 24
                + "Underlined text "    // index 26 - 41
                + "Italic text style\n\n"        // index 42 - 59
                + "Strikethrough text " // index 60 - 78
                + "Text with Color\n\n"       // index 79 - 95
                + "Highlighted text "   // index 96 - 113
                + "L Superscript text\n\n" // "Superscript" index 115 - 132
                + "L Subscript "   // "Subscript" index 135 - 145
                + "Url text\n\n"           //  index 146 - 154
                + "Clickable string\n\n"   // index 155 - 172
                + "The program is intended for everybody who wants to learn how to create Android applications");   // index 173 - 265

        // make the text twice as large
        styledString.setSpan(new RelativeSizeSpan(2f), 0, 8, 0);

        // make text bold
        styledString.setSpan(new StyleSpan(Typeface.BOLD), 9, 24, 0);

        // underline text
        styledString.setSpan(new UnderlineSpan(), 26, 41, 0);

        // make text italic
        styledString.setSpan(new StyleSpan(Typeface.ITALIC), 42, 59, 0);

        styledString.setSpan(new StrikethroughSpan(), 60, 78, 0);

        // change text color
        styledString.setSpan(new ForegroundColorSpan(Color.GREEN), 79, 95, 0);

        // highlight text
        styledString.setSpan(new BackgroundColorSpan(Color.CYAN), 96, 113, 0);

        // superscript
        styledString.setSpan(new SuperscriptSpan(), 115, 132, 0);

        // make the superscript text smaller
        styledString.setSpan(new RelativeSizeSpan(0.5f), 135, 145, 0);

        //url
        styledString.setSpan(new URLSpan("http://www.google.com"), 146, 154, 0);

        // clickable text
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                // We display a Toast. You could do anything you want here.
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();

            }
        };

        styledString.setSpan(clickableSpan, 155, 172, 0);

        styledString.setSpan(new ImageSpan(this, R.mipmap.ic_launcher), 185, 186, 0);


        TextView textView = new TextView(this);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(18);
        textView.setBackgroundColor(Color.WHITE);
        textView.setText(styledString);


        setContentView(textView);

    }
}
