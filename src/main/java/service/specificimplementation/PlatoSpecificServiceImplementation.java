package service.specificimplementation;

import javax.servlet.http.HttpServletRequest;
import service.genericimplementation.TableGenericServiceImplementation;

public class PlatoSpecificServiceImplementation extends TableGenericServiceImplementation {
    
    public PlatoSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
