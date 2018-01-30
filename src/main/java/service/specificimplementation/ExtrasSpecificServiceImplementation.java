package service.specificimplementation;

import javax.servlet.http.HttpServletRequest;
import service.genericimplementation.TableGenericServiceImplementation;

public class ExtrasSpecificServiceImplementation extends TableGenericServiceImplementation{
    
    public ExtrasSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
