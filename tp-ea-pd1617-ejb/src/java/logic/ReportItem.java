package logic;

public class ReportItem extends Report {

    Item item;

    //--- Methods ---
    public ReportItem(Item item, String motive) {
        this.item = item;
        super.motive = motive;
    }

}
