package logic;

public class ReportItem extends Report {

    int itemId;

    //--- Methods ---
    public ReportItem(int itemId, String motive) {
        this.itemId = itemId;
        super.motive = motive;
    }

}
