package logic;

public class ReportUser extends Report {

    String userId;

    //--- Methods ---
    public ReportUser(String userId, String motive) {
        this.userId = userId;
        super.motive = motive;
    }
}
