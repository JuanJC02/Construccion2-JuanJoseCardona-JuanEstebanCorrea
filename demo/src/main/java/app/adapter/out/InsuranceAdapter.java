package app.adapter.out;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;
import org.springframework.stereotype.Component;

@Component
public class InsuranceAdapter implements InsurancePort{
    
    

    @Override
    public void save(Insurance insurance) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Insurance findById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
