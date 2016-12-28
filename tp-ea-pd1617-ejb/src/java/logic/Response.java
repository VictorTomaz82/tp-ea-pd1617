
package logic;

public enum Response{

    // --- Values ---
    LOGIN_SUCCESS("Login Successful!\nWelcome "),
    LOGIN_FAIL("Username and/or password is incorrect."),
    PASSWORD_CHANGED("The password was successfully changed."),
    
    ASK_ACCOUNT_SENT("Account request successfull.\nThe account still needs to be activated by the admin please wait for the activation."),
    ASK_SUSPENSION_SENT("The suspension request was successfully sent."),
    ASK_REACTIVATION_SENT("The reactivation request was successfully sent."),
    
    BALANCE1("\nYou have "),
    BALANCE2("€ in your account."),
    
    BALANCE_ADDED1("Successfully added "),
    BALANCE_ADDED2("€ to your account."),
    
    CATEGORY("The category \""),
        
    CATEGORY_ADDED("The category was successfully added."),
    CATEGORY_CHANGED("The category was successfully changed."),
    
    MESSAGE_SENT("The message was successfully sent"),

    USER("The user \""),
    USER_ALREDY_EXISTS("This username already exists."),
    USER_SUSPENDED("The user was successfully suspended."),
    USER_ALREADY_SUSPENDED("The user is already suspended."),
    
    USER_REACTIVATED("The user was successfully reactivated."),
    USER_ALREADY_ACTIVE("The user is already active."),
    USER_NACTIVE("The user isn't active."),
    USER_NEVER_ACTIVATED("The user was never activated."),
       
    ITEM("The item \""),
      
    NEXIST("\" doesn't exist."),
    EXISTS("\" already exists."),
    
    //Placeholder variable
    LAST("");

private String str;

    // --- Methods ---
    Response(final String str) {
        this.str = str;
    }

//    public String getValue() {
//        return value;
//    }

    @Override
    public String toString() {
        return str;
    }
}
