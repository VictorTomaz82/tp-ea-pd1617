package logic;

public class ReportUser extends Report {

    User user;

    //--- Methods ---
    public ReportUser(User user, String motive) {
        this.user = user;
        super.motive = motive;
    }
}
