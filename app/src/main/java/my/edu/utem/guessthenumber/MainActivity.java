package my.edu.utem.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView noGenerate;
    EditText noUser;
    Button tekaNo;
    Button butangNew;
    TextView mesej;
    double randomNo;
    int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noGenerate = findViewById(R.id.generatedNo);
        noUser = findViewById(R.id.userNo);
        tekaNo = findViewById(R.id.buttonGuess);
        mesej = findViewById(R.id.alertTextView);
        butangNew = findViewById(R.id.buttonBaru);
        butangNew.setVisibility(View.GONE);
        initializeGame();
    }

    private void initializeGame() {
        randomNo = Math.random() * 100;
        counter = 0;
        noGenerate.setText("Guess a number");
        noUser.setText("");
        butangNew.setVisibility(View.GONE);
        //  mesej.setText("");
    }

    public void guessPressed(View view) {
        int getUserNo, randInt;
        double randNo = randomNo;

        butangNew.setVisibility(View.GONE);

        randInt = (int) randNo;
        getUserNo = Integer.parseInt(String.valueOf(noUser.getText()));
        if (noUser.getText().toString().equals("")) {
            mesej.setText("Please input your answer");
            //  Toast.makeText(MainActivity.this, "Please input your answer", Toast.LENGTH_LONG).show();
        }

        if (counter < 3) {
            if (getUserNo == randInt) {
                //  noGenerate.setText("CONGRATULATION!!! You Guess Right" );
                mesej.setText("CONGRATULATION!!! You Guess Right " + "You got at attempt: " + Integer.toString(counter + 1));
                initializeGame();
            } else {
                noGenerate.setText("Try again: " + "Attempt " + Integer.toString(counter + 1) + " " + Integer.toString(randInt));
                counter++;
                mesej.setText("");
            }
        } else {
            noGenerate.setText("You used all your attempt");
            tekaNo.setVisibility(View.GONE);
            butangNew.setVisibility(View.VISIBLE);
        }

    }

    public void baruPressed(View view) {
        tekaNo.setVisibility(View.VISIBLE);
        initializeGame();

    }


}

