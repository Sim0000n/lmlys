package team.area237.lmlys.utils;

public class ResponseWrapper<T> {
    private String status = ResponseStatus.OK.getValue();

    private String message = "success";

    private T data;

    public ResponseWrapper(ResponseStatus responseStatus, String message, T data) {
        this.status = responseStatus.getValue();
        this.message = message;
        this.data = data;
    }
    public ResponseWrapper(ResponseStatus responseStatus, String message) {
        this.status = responseStatus.getValue();
        this.message = message;
    }
    public ResponseWrapper(ResponseStatus responseStatus, T data) {
        this.status = responseStatus.getValue();
        this.data = data;
    }
    public ResponseWrapper(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
