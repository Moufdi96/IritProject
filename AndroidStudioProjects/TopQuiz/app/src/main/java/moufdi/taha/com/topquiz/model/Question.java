package moufdi.taha.com.topquiz.model;

import java.util.ArrayList;

public class Question {
   private String mQuestion;
   private ArrayList<String> mChoiceList;
   private int mAnswerIndex;

    public Question(String mQuestion,ArrayList<String> mChoiceList,int mAnswerIndex){
        this.setQuestion(mQuestion);
        this.setChoiceList(mChoiceList);
        this.setAnswerIndex(mAnswerIndex);
    }

    public void setQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setChoiceList(ArrayList<String> mChoiceList) {
        this.mChoiceList = mChoiceList;
    }

    public void setAnswerIndex(int mAnswerIndex) {
        this.mAnswerIndex = mAnswerIndex;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public ArrayList<String> getChoiceList() {
        return mChoiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }
}
