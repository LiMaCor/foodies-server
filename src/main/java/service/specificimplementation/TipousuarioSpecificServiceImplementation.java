package service.specificimplementation;

import service.genericimplementation.TableGenericServiceImplementation;
import javax.servlet.http.HttpServletRequest;

public class TipousuarioSpecificServiceImplementation extends TableGenericServiceImplementation {

    public TipousuarioSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
