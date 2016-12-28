
package logic;

public enum Response{

    // --- Values ---
    
    VISITOR("Visitante"),
    ADMIN("Admin"),
    
    LOGIN_SUCCESS("Login realizado com sucesso!\nBemvindo "),
    LOGIN_FAIL("Username e/ou password estao incorrectos."),
    PASSWORD_CHANGED("Mudanca de password realizada com sucesso."),
    
    ASK_ACCOUNT_SENT("Pedido de conta realizado com sucesso.\nA conta ainda necessita de ser validada pelo administrador."),
    ASK_SUSPENSION_SENT("O pedido de suspensao foi realizado com sucesso."),
    ASK_REACTIVATION_SENT("O pedido de reactivacao da conta foi realizado com sucesso."),
    
    BALANCE1("\nTem "),
    BALANCE2("€ na sua conta."),
    
    BALANCE_ADDED1("Adicionados "),
    BALANCE_ADDED2("€ a sua conta."),
    
    CATEGORY("A categoria \""),
        
    CATEGORY_ADDED("A categoria foi adicionada com sucesso."),
    CATEGORY_CHANGED("A categoria foi alterada com sucesso."),
    
    MESSAGE_SENT("Mensagem enviada!"),

    USER("O utilizador \""),
    USER_ALREDY_EXISTS("O username ja existe."),
    USER_SUSPENDED("O utilizador foi suspendido com sucesso."),
    USER_ALREADY_SUSPENDED("O utilizador ja se encontra suspendido."),
    
    USER_REACTIVATED("O utilizador foi reactivado com sucesso."),
    USER_ALREADY_ACTIVE("O utilizador ja se encontra activo."),
    USER_NACTIVE("O utilizador nao esta activo."),
    
    //check this
    USER_NEVER_ACTIVATED("O utilizador nunca foi activado."),
       
    ITEM("O item \""),
      
    NEXIST("\" nao existe."),
    EXISTS("\" ja existe."),
    
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
