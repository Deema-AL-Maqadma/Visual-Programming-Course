package javafx.lec11;

public class Student {

    Integer id;
    String fn, ln, mobile;

    public Student() {
    }

    public Student(Integer id, String fn, String ln, String mobile) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
