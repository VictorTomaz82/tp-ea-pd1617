package logic;

import java.util.Date;

public class Supension {

    String motive;
    Date time;

    //--- Methods ---
    public Supension(String motive, Date time) {
        this.motive = motive;
        this.time = time;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
