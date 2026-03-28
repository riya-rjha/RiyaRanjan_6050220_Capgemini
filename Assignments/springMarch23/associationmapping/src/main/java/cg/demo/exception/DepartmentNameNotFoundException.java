package cg.demo.exception;

public class DepartmentNameNotFoundException extends RuntimeException {
    public DepartmentNameNotFoundException(String msg) {
        super(msg);
    }
}