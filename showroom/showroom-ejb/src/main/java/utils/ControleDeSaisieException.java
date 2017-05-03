
package utils;


public class ControleDeSaisieException extends Exception {

    String msg;

    public ControleDeSaisieException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
