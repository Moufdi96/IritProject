package moufdi.taha.com.topquiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView mGreetingText;
    private Button mPlayButton;
    private EditText mNameImput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGreetingText=(TextView)findViewById(R.id.activity_main_greeting_text);
        mPlayButton=(Button)findViewById(R.id.main_activity_play_btn);
        mNameImput=(EditText)findViewById(R.id.main_activity_name_input);
        mPlayButton.setEnabled(false);
        mNameImput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length()!=0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivity=new Intent(MainActivity.this,GameActivity.class);
                startActivity(gameActivity);
            }
        });


    }

}