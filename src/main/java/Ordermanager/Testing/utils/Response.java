package Ordermanager.Testing.utils;

public class Response {
    private String message;
    private Boolean success;
    private Object object;

    public Response(String message, Boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}


