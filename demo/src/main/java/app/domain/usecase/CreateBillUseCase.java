
package app.domain.usecase;

import app.domain.model.Bill;
import app.domain.model.User;
import app.domain.services.CreateBill;

public class CreateBillUseCase {
    
    private CreateBill createBill;
    
    public void execute(User actor, Bill bill) throws Exception {
        createBill.registerBill(actor, bill);
    }
}
