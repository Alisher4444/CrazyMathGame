package creatingnew.kz.crazymathematician;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MultiGameLevel1 extends AppCompatActivity {



    private static final int REQUEST_CODE_PLAY = 1;
    private TextView equationTextView;
    private EditText answerEditText;
    private Button submitButton;
    private int a,b;
    private  int count = 0;
    private TextView scorePlayer1;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game_level1);
        equationTextView = (TextView)findViewById(R.id.equationTextView);
        answerEditText = (EditText) findViewById(R.id.answerEditText);
        submitButton = (Button)findViewById(R.id.submitButton);
        scorePlayer1 = (TextView)findViewById(R.id.scorePlayer1);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                onSubmitClick();

            }
        });
        a=10;
        b=10;
        equationTextView.setText(a + "X" + b);
        scorePlayer1.setText(""+score);

    }
    private void onSubmitClick(){
        int answer = Integer.parseInt(answerEditText.getText().toString());

        int value = 0;
        //Intent returnIntent = new Intent();


        if (answer == a * b) {
            score = count;
            Random random = new Random();
            a = random.nextInt(9) + 1;
            b = random.nextInt(9) + 1;
            equationTextView.setText(a + "X" + b);
            //returnIntent.putExtra("result", value);
            if(count==5){
                Intent intent = new Intent(this,Level2Activity.class);
                startActivity(intent);
            }
           // setResult(RESULT_OK, returnIntent);
        } else if (answer != a * b) {
            finish();

        }

    }
}