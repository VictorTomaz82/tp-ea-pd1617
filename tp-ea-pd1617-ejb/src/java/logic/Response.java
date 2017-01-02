package logic;

public enum Response {

    // --- Values ---
    VISITOR("Visitante"),
    ADMIN("Admin"),
    LOGIN_SUCCESS("Login realizado com sucesso!\nBemvindo "),
    LOGIN_FAIL("Username e/ou password estao incorrectos."),
    LOUGOUT_SUCCESS("Logout realizado com sucesso."),
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
    MESSAGE_NOWNER("A Mensagem nao existe ou sem permissoes de leitura."),
    USER("O utilizador \""),
    USER_ALREDY_EXISTS("O username ja existe."),
    USER_SUSPENDED("O utilizador foi suspendido com sucesso."),
    USER_ALREADY_SUSPENDED("O utilizador ja se encontra suspendido."),
    USER_INFORMATION_CHANGED("Os dados do utilizador foram alterados com sucesso."),
    USER_ACTIVATE("O utilizador foi activado com sucesso."),
    USER_REACTIVATED("O utilizador foi reactivado com sucesso."),
    USER_ALREADY_ACTIVE("O utilizador ja se encontra activo."),
    USER_NACTIVE("O utilizador nao esta activo."),
    //check this
    USER_NEVER_ACTIVATED("O utilizador nunca foi activado."),
    ITEM("O item \""),
    ITEM_SUCCESS("\" foi adicionado com sucesso."),
    ITEM_REMOVED("\" foi removido com sucesso."),
    ITEM_CLOSED("O periodo de licitacoes ja acabou."),
    ITEM_ALREADY_FOLLOWING("\" ja se encontra nos seus items a seguir"),
    ITEM_ALREADY_PAYED("\" ja foi pago."),
    ITEM_WON("\nParabens o item e seu."),
    ITEM_PAY("\" foi pago com sucesso."),
    ITEM_FOLLOW_ADD("\" foi adicionado com sucesso nos seus items a seguir."),
    ITEM_BID_CLOSED("O item \"."),
    ITEM_BID_SUCCESS("A licitacao foi realizada com sucesso."),
    ITEM_LOW_BID1("Ja existe uma licitacao do mesmo valor ou superior.\nA licitacao actual e de "),
    ITEM_LOW_BID2("€."),
    DENUNCE_SUCCESS("Denuncia realizada com sucesso."),
    DENUNCE_USER("Denuncias de utilizadores:\n"),
    DENUNCE_ITEM("Denuncias de items:\n"),
    NEXIST("\" nao existe."),
    EXISTS("\" ja existe."),
    NEWS_NEW_USER(" - Novo utilizador registado: "),
    NEWS_NEW_USER_ACTIVATED(" - Novo utilizador ativado: "),
    NEWS_SUSPENDED_USER(" foi suspendido por \""),
    NEWS_ASK_REACTIVATION(" pediu reactivacao da conta."),
    NEWS_ASK_REACTIVATED(" foi reativado."),
    NEWS_ITEM_SOLD1(" - O item "),
    NEWS_ITEM_SOLD2(" foi vendido por "),
    CURRENCY("€"),
    INSUFICIENT_BALANCE("Nao possui saldo suficiente."),
    NOTHING("A informacao pedida nao existe de momento"),
    DATE_FORMAT("dd/MM/yyyy HH:mm:ss"),
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
