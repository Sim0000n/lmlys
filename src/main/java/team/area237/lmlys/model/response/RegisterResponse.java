package team.area237.lmlys.model.response;

public class RegisterResponse {
    //0:success, 1:fail
    private int status;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
