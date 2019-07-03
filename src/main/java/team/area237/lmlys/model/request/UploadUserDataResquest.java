package team.area237.lmlys.model.request;

public class UploadUserDataResquest {
    //若为空，则不包含对应的项
    private String email;
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
