public class MyException extends Exception {
    private String msg;

    MyException() {}

    MyException(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


}
