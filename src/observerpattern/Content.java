package observerpattern;

public class Content<T> {
    String status = null;

    T msg = null;
    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public T getMsg(){
        return this.msg;
    }

    public void setMsg(T msg){
        this.msg = msg;
    }

    public Content(String status){
        this.status = status;
    }
}
