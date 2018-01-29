package service.specificimplementation;

import javax.servlet.http.HttpServletRequest;
import service.genericimplementation.TableGenericServiceImplementation;

public class TicketSpecificServiceImplementation extends TableGenericServiceImplementation{
    
    public TicketSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
