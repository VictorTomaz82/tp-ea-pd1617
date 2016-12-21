package logic;

import java.util.Date;

public class Message {

    User sender;
    User recipient;
    String title;
    String body;
    Date time;

    //--- Methods ---
    
    //Constructor without Body
    public Message(User sender, User recipient, String title, Date time) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.time = time;
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
