package logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    String messageId;
    User sender;
    User recipient;
    String title;
    String body;
    Date time;
    DateFormat dateFormat;

    //--- Methods ---
    
    //Constructor without Body
    public Message(User sender, User recipient, String title, String body, Date time) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.body = body;
        this.time = time;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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

//    public void setTime(Date time) {
//        this.time = time;
//    }
}
