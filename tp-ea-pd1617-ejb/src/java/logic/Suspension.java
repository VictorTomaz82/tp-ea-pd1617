package logic;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Suspension implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    int suspensionId;

    String motive;
    Date time;
    DateFormat dateFormat;

    //--- Methods ---
    public Suspension(String motive, Date time) {
        this.motive = motive;
        this.time = time;
        dateFormat = new SimpleDateFormat(Response.DATE_FORMAT.toString());
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

    @Override
    public String toString() {
        return "Data: "+dateFormat.format(time)+" Motivo:"+motive;
    }
    
    

}
