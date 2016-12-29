package logic;

public class ReportUser extends Report {

    int userId;

    //--- Methods ---
    public ReportUser(int userId, String motive) {
        this.userId = userId;
        super.motive = motive;
    }
}
