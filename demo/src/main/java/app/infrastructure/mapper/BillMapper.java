package app.infrastructure.mapper;

import app.domain.model.Bill;
import app.infrastructure.entity.BillEntity;
import org.springframework.stereotype.Component;

@Component
public class BillMapper {

    public static BillEntity toEntity(Bill bill) {
        BillEntity entity = new BillEntity();

        entity.setPatientName(bill.getPatientName());
        entity.setPatientLastName(bill.getPatientLastName());
        entity.setPatientAge(bill.getPatientAge());
        entity.setPatientDocument(bill.getPatientDocument());
        entity.setTreatingPhysicianDocument(bill.getTreatingPhysicianDocument());
        entity.setCompanyName(bill.getCompanyName());
        entity.setPolicyNumber(bill.getPolicyNumber());
        entity.setPolicyExpirationDate(bill.getPolicyExpirationDate());

        return entity;
    }

    public static Bill toDomain(BillEntity entity) {
        Bill bill = new Bill();

        bill.setPatientName(entity.getPatientName());
        bill.setPatientLastName(entity.getPatientLastName());
        bill.setPatientAge(entity.getPatientAge());
        bill.setPatientDocument(entity.getPatientDocument());
        bill.setTreatingPhysicianDocument(entity.getTreatingPhysicianDocument());
        bill.setCompanyName(entity.getCompanyName());
        bill.setPolicyNumber(entity.getPolicyNumber());
        bill.setPolicyExpirationDate(entity.getPolicyExpirationDate());

        return bill;
    }
}
