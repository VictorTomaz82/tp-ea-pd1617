package logic;

public class ReportItem extends Report {

    String itemId;

    //--- Methods ---
    public ReportItem(String itemId, String motive) {
        this.itemId = itemId;
        super.motive = motive;
    }

}
