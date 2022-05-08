package com.gemini.morser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }

  @Override
  protected void onStart() {
    Button convertButton = (Button) findViewById(R.id.convert);
    TextView inputText = (TextView) findViewById(R.id.input);
    TextView outputText = (TextView) findViewById(R.id.output);
    Convert_Morse convert = new Convert_Morse();
    ImageView tapButton = (ImageView) findViewById(R.id.sender_button);
    TextView liveView = (TextView) findViewById(R.id.Live_View);


    Time time = new Time();
// Listener for the button to convert the presses to morse with pauses between each letter

    tapButton.setOnClickListener(new View.OnClickListener() {


                                   String input = " ";
                                   long startTime = System.currentTimeMillis();
                                   String morseSet = "";

                                   @Override
                                   // add the delay between each  press
                                   public void onClick(View v) {
                                     // start the timer

                                     long timeElapsed = System.currentTimeMillis() - startTime;
                                     System.out.println(timeElapsed);
                                     if (timeElapsed < 800) {
                                       input = input + ".";
                                       startTime = System.currentTimeMillis();

                                     } else if (timeElapsed < 1000) {
                                       input = input + "-";
                                       startTime = System.currentTimeMillis();
                                     } else {
                                       if (input.contains(" ") && input.length() > 3) {
                                         String value = convert.convert(input.split(" ")[(input.split(" ").length - 1)]);

                                         if (value.length() > 0) {
                                           morseSet = morseSet + value;
                                         }
                                         ;


                                       }

                                       input = input + " ";

                                       startTime = System.currentTimeMillis();


                                     }


                                     outputText.setText(input);

                                     System.out.println(morseSet);


                                   }  // end of onClick


                                 } // end of listener
    ); // end of tapButton.setOnClickListener


    convertButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Start the next activity
        convert.setMessage(inputText.getText().toString());
        outputText.setText(convert.convert(inputText.getText().toString()));

      }
    });
    super.onStart();


  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  /**
   * Called when the user taps the Send button
   */
  public void sendMessage(View view) {
    // Do something in response to button
  }
}
