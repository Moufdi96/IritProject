package moufdi.taha.com.topquiz.controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import moufdi.taha.com.topquiz.R;
import moufdi.taha.com.topquiz.model.Question;
import moufdi.taha.com.topquiz.model.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTexteQuestion;
    private Button mbtn1;
    private Button mbtn2;
    private Button mbtn3;
    private Button mbtn4;
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    private int mScore=0;
    private int mNumberOfQuestions=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mTexteQuestion=(TextView)findViewById(R.id.activity_game_question_text);
        mbtn1= (Button) findViewById(R.id.activity_game_answer1_btn);
        mbtn2=(Button)findViewById(R.id.activity_game_answer2_btn);
        mbtn3=(Button)findViewById(R.id.activity_game_answer3_btn);
        mbtn4=(Button)findViewById(R.id.activity_game_answer4_btn);
        mQuestionBank=this.generateQuestions();
        mCurrentQuestion=mQuestionBank.getQuestion();
        mbtn1.setTag(0);
        mbtn2.setTag(1);
        mbtn3.setTag(2);
        mbtn4.setTag(3);
        mbtn1.setOnClickListener(this);
        mbtn2.setOnClickListener(this);
        mbtn3.setOnClickListener(this);
        mbtn4.setOnClickListener(this);
        displayQuestion(mCurrentQuestion);
    }

    private QuestionBank generateQuestions(){
        Question mQuestion1,mQuestion2,mQuestion3,mQuestion4;
        ArrayList<Question> mQuestionList;

        ArrayList<String> mChoixList1=new ArrayList<>();
        mChoixList1.add("Andy Rubin");
        mChoixList1.add("Steve Wozniak");
        mChoixList1.add("Jake Wharton");
        mChoixList1.add("Paul Smith");

        ArrayList<String> mChoixList2=new ArrayList<>();
        mChoixList2.add("1958");
        mChoixList2.add("1962");
        mChoixList2.add("1967");
        mChoixList2.add("1969");

        ArrayList<String> mChoixList3=new ArrayList<>();
        mChoixList3.add("42");
        mChoixList3.add("101");
        mChoixList3.add("742");
        mChoixList3.add("666");

        ArrayList<String> mChoixList4=new ArrayList<>();
        mChoixList4.add("aaaaaaaaa");
        mChoixList4.add("bbbbbbbbb");
        mChoixList4.add("ccccccccc");
        mChoixList4.add("ddddddddd");

        mQuestion1=new Question("Who is the creator of Android?",mChoixList1,0);
        mQuestion2=new Question("When did the first man land on the moon?",mChoixList2,3);
        mQuestion3=new Question("What is the house number of The Simpsons?",mChoixList3,2);
        mQuestion4=new Question("qqqqqqq4",mChoixList4,0);
        mQuestionList=new ArrayList<>();
        mQuestionList.add(mQuestion1);
        mQuestionList.add(mQuestion2);
        mQuestionList.add(mQuestion3);
        mQuestionList.add(mQuestion4);


        return  new QuestionBank(mQuestionList);
    }

    public void displayQuestion(Question question){
        mTexteQuestion.setText(question.getQuestion());
        mbtn1.setText(question.getChoiceList().get(0));
        mbtn2.setText(question.getChoiceList().get(1));
        mbtn3.setText(question.getChoiceList().get(2));
        mbtn4.setText(question.getChoiceList().get(3));
    }

    @Override
    public void onClick(View v) {
        int answerIndex=(int)v.getTag();
        if(answerIndex==mCurrentQuestion.getAnswerIndex()) {
            Toast.makeText(this, "Correct bravo!", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(this, "Wrong !", Toast.LENGTH_SHORT).show();
        }

        if (--mNumberOfQuestions == 0) {
            // No question left, end the game
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("well done !");
        builder.setMessage("your score is"+mScore);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create();
        builder.show();
    }
}
