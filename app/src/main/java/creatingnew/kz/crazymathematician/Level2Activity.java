package creatingnew.kz.crazymathematician;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Level2Activity extends AppCompatActivity {
    private TextView equationTextView;
    private EditText answerEditText;
    private Button submitButton;
    private int a,b;
    private  int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        equationTextView = (TextView) findViewById(R.id.equationTextView);
        answerEditText = (EditText) findViewById(R.id.answerEditText);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                onSubmitClick();

            }
        });
        a = 100;
        b = 100;
        equationTextView.setText(a + "X" + b);

    }

    private void onSubmitClick() {
        int answer = Integer.parseInt(answerEditText.getText().toString());

        int value = 0;
        Intent returnIntent = new Intent();


        if (answer == a * b) {
            value = count;
            Random random = new Random();
            a = random.nextInt(90) + 10;
            b = random.nextInt(90) + 10;
            equationTextView.setText(a + "X" + b);
            returnIntent.putExtra("result", value);
            setResult(RESULT_OK, returnIntent);
        } else if (answer != a * b) {
            finish();

        }


    }
}