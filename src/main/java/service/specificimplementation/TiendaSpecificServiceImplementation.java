package service.specificimplementation;

import javax.servlet.http.HttpServletRequest;
import service.genericimplementation.TableGenericServiceImplementation;

public class TiendaSpecificServiceImplementation extends TableGenericServiceImplementation{
    
    public TiendaSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
