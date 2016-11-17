package creatingnew.kz.crazymathematician;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PLAY = 1;
    private TextView equationTextView;
    private EditText answerEditText;
    private Button submitButton;
    private int a,b;
    private  int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        equationTextView = (TextView)findViewById(R.id.equationTextView);
        answerEditText = (EditText) findViewById(R.id.answerEditText);
        submitButton = (Button)findViewById(R.id.submitButton);

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

    }
    private void onSubmitClick(){
        int answer = Integer.parseInt(answerEditText.getText().toString());

        int value = 0;
        Intent returnIntent = new Intent();


            if (answer == a * b) {
                value = count;
                Random random = new Random();
                a = random.nextInt(9) + 1;
                b = random.nextInt(9) + 1;
                equationTextView.setText(a + "X" + b);
                returnIntent.putExtra("result", value);
                if(count==5){
                    Intent intent = new Intent(this,Level2Activity.class);
                    startActivityForResult(intent, REQUEST_CODE_PLAY);
                }
                setResult(RESULT_OK, returnIntent);
            } else if (answer != a * b) {
                finish();

            }





    }
}
