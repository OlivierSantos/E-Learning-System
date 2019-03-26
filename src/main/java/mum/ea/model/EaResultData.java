package mum.ea.model;

public class EaResultData<T> extends EaResult {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
