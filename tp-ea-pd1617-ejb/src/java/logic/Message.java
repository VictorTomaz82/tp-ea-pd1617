package logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    int messageId;
    User sender;
    User recipient;
    String title;
    String body;
    Date time;
    DateFormat dateFormat;
    boolean checked;

    //--- Methods ---
    public Message(User sender, User recipient, String title, String body, Date time) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.body = body;
        this.time = time;
        dateFormat = new SimpleDateFormat(Response.DATE_FORMAT.toString());
        checked = false;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getTime() {
        return time;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getGenericInformation() {
        if (!checked) {
            return messageId + "> Data: " + dateFormat.format(time) + " De:" + sender + " Titulo: " + title + "Estado: Não Lida";
        } else {
            return messageId + "> Data: " + dateFormat.format(time) + " De:" + sender + " Titulo: " + title + "Estado: Lida";
        }

    }

    @Override
    public String toString() {
        checked = true;
        return messageId + "> Data: " + dateFormat.format(time) + " De:" + sender + " Para:" + recipient + " | Titulo: " + title + " \n \t" + body;
    }

//    public void setTime(Date time) {
//        this.time = time;
//    }
}
