package service.specificimplementation;

import javax.servlet.http.HttpServletRequest;
import service.genericimplementation.TableGenericServiceImplementation;

public class PedidoSpecificServiceImplementation extends TableGenericServiceImplementation {
    
    public PedidoSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
