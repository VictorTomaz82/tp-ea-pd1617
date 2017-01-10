package logic;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable{
    
    private static final long serialVersionUID = 1L;

    int messageId;
    
    String sender;
    String recipient;
    String title;
    String body;
    Date date;
    DateFormat dateFormat;
    boolean checked;

    //--- Methods ---
    public Message(String sender, String recipient, String title, String body, Date date) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.body = body;
        this.date = date;
        dateFormat = new SimpleDateFormat(Response.DATE_FORMAT.toString());
        checked = false;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
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

    public Date getDate() {
        return date;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getGenericInformation() {
        if (!checked) {
            return messageId + "> Data: " + dateFormat.format(date) + " De:" + sender + " Titulo: " + title + "Estado: Não Lida";
        } else {
            return messageId + "> Data: " + dateFormat.format(date) + " De:" + sender + " Titulo: " + title + "Estado: Lida";
        }

    }

    @Override
    public String toString() {
        checked = true;
        return messageId + "> Data: " + dateFormat.format(date) + " De:" + sender + " Para:" + recipient + " | Titulo: " + title + " \n \t" + body;
    }

//    public void setTime(Date time) {
//        this.time = time;
//    }
}
