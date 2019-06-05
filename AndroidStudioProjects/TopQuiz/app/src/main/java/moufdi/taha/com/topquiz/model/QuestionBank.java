package moufdi.taha.com.topquiz.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private ArrayList<Question> mQuestionBank;
    private int mNextQuestionIndex;

    public QuestionBank(ArrayList<Question> mQuestionBank){
        mNextQuestionIndex=0;
        this.setmQuestionBank(mQuestionBank);
        Collections.shuffle(mQuestionBank);

    }

    public void setmQuestionBank(ArrayList<Question> mQuestionBank) {
        this.mQuestionBank = mQuestionBank;
    }

   /* public void setmNextQuestionIndex(int mNextQuestionIndex) {
        this.mNextQuestionIndex = mNextQuestionIndex;
    }*/

    public ArrayList<Question> getmQuestionBank() {
        return mQuestionBank;
    }

    public int getmNextQuestionIndex() {
        if(this.mNextQuestionIndex==mQuestionBank.size())
            this.mNextQuestionIndex=0;
        return mNextQuestionIndex;
    }

    public Question getQuestion(){
        return mQuestionBank.get(mNextQuestionIndex++);
    }


}
