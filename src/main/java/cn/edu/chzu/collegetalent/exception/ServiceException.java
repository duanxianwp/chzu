package cn.edu.chzu.collegetalent.exception;

/**
 * @auther: chzu
 * @date: Created in 2019/1/17 13:07
 * @description:
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -7167467302684781087L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}