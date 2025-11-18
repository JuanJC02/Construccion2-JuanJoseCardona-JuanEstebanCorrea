package app.adapter.out;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;
import app.infrastructure.entity.AppointmentEntity;
import app.infrastructure.mapper.AppointmentMapper;
import app.infrastructure.repository.jpa.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AppointmentAdapter implements AppointmentPort {

    private AppointmentRepository repository;
    private AppointmentMapper mapper;

    @Autowired
    public AppointmentAdapter(AppointmentRepository repository, AppointmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Appointment> findByPatientDocument(String patientDocument) throws Exception {
        Long doc = Long.parseLong(patientDocument);

        List<AppointmentEntity> list = repository.findAll()
                .stream()
                .filter(a -> a.getPatientDocument().equals(doc))
                .collect(Collectors.toList());

        return list.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Appointment findAppointmentByDocument(Long document) throws Exception {
        Optional<AppointmentEntity> opt = repository.findAll()
                .stream()
                .filter(a -> a.getPatientDocument().equals(document))
                .findFirst();

        return opt.map(mapper::toDomain).orElse(null);
    }

    @Override
    public Appointment findAppointmentById(Long appointmentID) throws Exception {
        Optional<AppointmentEntity> opt = repository.findById(appointmentID);

        if (opt.isEmpty()) {
            return null;
        }

        return mapper.toDomain(opt.get());
    }

    @Override
    public void save(Appointment appointment) throws Exception {
        if (appointment == null) {
            throw new Exception("la cita es nula");
        }

        AppointmentEntity entity = mapper.toEntity(appointment);
        repository.save(entity);
    }
}
