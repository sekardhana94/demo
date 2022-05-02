package com.tranining.nx2.service;

import java.util.List;

import com.tranining.nx2.entity.Hospital;
import com.tranining.nx2.entity.Patient;

public interface PatientService {
    List<Patient> getAllPatients();

    List<Patient> getAllPatientsByHospital(Long id);

    Patient getPatientById(Long id);

    Patient save(Patient hospital);

    Patient update(Patient hospital);

    void delete(Long id);
}
