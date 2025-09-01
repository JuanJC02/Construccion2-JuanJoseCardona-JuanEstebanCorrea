package app.domain.usecase;

import app.domain.model.Insurance;
import app.domain.model.User;
import app.domain.services.CreateInsurance;

public class CreateInsuranceUseCse {

    private CreateInsurance createInsurance;

    public void execute(User actor, Insurance insurance) throws Exception {
        createInsurance.registerInsurance(actor, insurance);
    }
}
