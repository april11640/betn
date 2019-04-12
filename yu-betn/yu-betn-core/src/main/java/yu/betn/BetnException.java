package yu.betn;

/**
 * Created by zsp on 2019/4/11.
 */
public class BetnException extends RuntimeException {

    public BetnException(){
        super();
    }

    public BetnException(String msg) {
        super(msg);
    }

    public BetnException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BetnException(Throwable cause) {
        super(cause);
    }

}
