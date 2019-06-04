package moufdi.taha.com.topquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private TextView tx;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tx=(TextView)findViewById(R.id.activity_game_question_text);
        btn1= (Button) findViewById(R.id.activity_game_answer1_btn);
        btn2=(Button)findViewById(R.id.activity_game_answer2_btn);
        btn3=(Button)findViewById(R.id.activity_game_answer3_btn);
        btn4=(Button)findViewById(R.id.activity_game_answer4_btn);


    }
}
