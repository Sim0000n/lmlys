package team.area237.lmlys.model.response;

public class LoginResponse {
    //0:login success, 1:wrong password, 2:username invalid
    private int status;

    private String username = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
