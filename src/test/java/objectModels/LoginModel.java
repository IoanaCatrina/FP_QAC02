package objectModels;

public class LoginModel {
    private AccountModel account;
    private String loginError;

    public LoginModel() {
    }

    public LoginModel(String username, String password, String loginError) {
        this.account = new AccountModel(username, password);
        this.loginError = loginError;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public String getLoginError() {
        return loginError;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError;
    }

    @Override
    public String toString() {
        return "LoginModel value: {\n " +
                "account=" + account +
                ", loginError='" + loginError + '\'' +
                '}';
    }
}
