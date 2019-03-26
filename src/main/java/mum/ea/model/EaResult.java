package mum.ea.model;

import mum.ea.enums.StatusCode;
import mum.ea.helper.JsonHelper;

public class EaResult {

    private StatusCode statusCode;
    private String message;

    public EaResult makeSuccess(){
        this.statusCode= StatusCode.SUCCESS;
        return this;
    }

    public boolean isSuccess(){
        return this.statusCode== StatusCode.SUCCESS;
    }

    public String asJson(){
        return JsonHelper.toJson(this);
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
