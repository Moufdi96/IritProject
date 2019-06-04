package moufdi.taha.com.topquiz.model;

public class User {
    private String mFirstName;

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String toString(){
        return "First name"+"   "+mFirstName;
    }
}
