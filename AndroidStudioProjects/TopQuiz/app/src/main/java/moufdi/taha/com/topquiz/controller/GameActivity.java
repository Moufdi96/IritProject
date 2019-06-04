package moufdi.taha.com.topquiz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import moufdi.taha.com.topquiz.R;
import moufdi.taha.com.topquiz.model.Question;
import moufdi.taha.com.topquiz.model.QuestionBank;

public class GameActivity extends AppCompatActivity {
    private TextView mtx;
    private Button mbtn1;
    private Button mbtn2;
    private Button mbtn3;
    private Button mbtn4;
    private QuestionBank mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mtx=(TextView)findViewById(R.id.activity_game_question_text);
        mbtn1= (Button) findViewById(R.id.activity_game_answer1_btn);
        mbtn2=(Button)findViewById(R.id.activity_game_answer2_btn);
        mbtn3=(Button)findViewById(R.id.activity_game_answer3_btn);
        mbtn4=(Button)findViewById(R.id.activity_game_answer4_btn);
        mQuestionBank=this.generateQuestion();

    }

    private QuestionBank generateQuestion(){
        Question mQuestion1,mQuestion2,mQuestion3,mQuestion4;
        ArrayList<Question> mQuestionList;

        ArrayList<String> mChoixList1=new ArrayList<>();
        mChoixList1.add("aaaaaaaaa");
        mChoixList1.add("bbbbbbbbb");
        mChoixList1.add("ccccccccc");
        mChoixList1.add("ddddddddd");

        ArrayList<String> mChoixList2=new ArrayList<>();
        mChoixList2.add("aaaaaaaaa");
        mChoixList2.add("bbbbbbbbb");
        mChoixList2.add("ccccccccc");
        mChoixList2.add("ddddddddd");

        ArrayList<String> mChoixList3=new ArrayList<>();
        mChoixList3.add("aaaaaaaaa");
        mChoixList3.add("bbbbbbbbb");
        mChoixList3.add("ccccccccc");
        mChoixList3.add("ddddddddd");

        ArrayList<String> mChoixList4=new ArrayList<>();
        mChoixList4.add("aaaaaaaaa");
        mChoixList4.add("bbbbbbbbb");
        mChoixList4.add("ccccccccc");
        mChoixList4.add("ddddddddd");

        mQuestion1=new Question("qqqqqqq",mChoixList1,1);
        mQuestion2=new Question("qqqqqqq",mChoixList2,2);
        mQuestion3=new Question("qqqqqqq",mChoixList3,3);
        mQuestion4=new Question("qqqqqqq",mChoixList4,0);
        mQuestionList=new ArrayList<>();
        mQuestionList.add(mQuestion1);
        mQuestionList.add(mQuestion2);
        mQuestionList.add(mQuestion3);
        mQuestionList.add(mQuestion4);


        return  new QuestionBank(mQuestionList);

    }
}
