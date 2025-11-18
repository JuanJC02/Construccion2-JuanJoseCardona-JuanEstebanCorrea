package app.infrastructure.mapper;

import app.infrastructure.entity.PatientEntity;
import app.infrastructure.entity.EmergencyContactEntity;
import app.domain.model.Patient;
import app.domain.model.EmergencyContact;
import app.infrastructure.entity.EmergencyContactEntity;
import app.infrastructure.entity.PatientEntity;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientEntity toEntity(Patient domain) {
        if (domain == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setGender(domain.getGender());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAge(domain.getAge());
        entity.setUsername(domain.getUsername());
        entity.setPassword(domain.getPassword());
        entity.setName(domain.getName());
        entity.setLastName(domain.getLastName());
        entity.setDocument(domain.getDocument());
        entity.setEmail(domain.getEmail());
        entity.setPhonenumber(domain.getPhonenumber());
        entity.setAddress(domain.getAddress());
        entity.setRole(domain.getRole());
        entity.setPolicyNumber(domain.getPolicyNumber());

        return entity;
    }

    public Patient toDomain(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        Patient domain = new Patient();
        domain.setGender(entity.getGender());
        domain.setBirthDate(entity.getBirthDate());
        domain.setAge(entity.getAge());
        domain.setUsername(entity.getUsername());
        domain.setPassword(entity.getPassword());
        domain.setName(entity.getName());
        domain.setLastName(entity.getLastName());
        domain.setDocument(entity.getDocument());
        domain.setEmail(entity.getEmail());
        domain.setPhonenumber(entity.getPhonenumber());
        domain.setAddress(entity.getAddress());
        domain.setRole(entity.getRole());
        domain.setPolicyNumber(entity.getPolicyNumber());

        return domain;
    }
}
