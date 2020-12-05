package studsluzba.coders;


/**
 * Šifarnik koji nema vrednost, samo šifru, mesto,smer,tipSK,drzave
 *
 * @author bojanads
 */
public class SimpleCode extends AbstractCode {


    public SimpleCode(String code) {
        super(code);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String toString() {
        return getCode();
    }


}
