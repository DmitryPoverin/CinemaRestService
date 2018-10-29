package cinema.service.model;

public class Message {
    public Message(String message, int code, Object data) {
        this.message = message;
        Code = code;
        this.data = data;
    }

    public Message(String message, int code) {
        this.message = message;
        Code = code;
    }

    private String message;
    private int Code;

    public Object getData() {
        return data;
    }

    private Object data;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
