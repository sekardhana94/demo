package com.tranining.nx2.service;

import java.util.List;

import com.tranining.nx2.entity.Hospital;

public interface HospitalService {

    List<Hospital> getAllHospitals();

    Hospital getHospitalById(Long id);

    Hospital save(Hospital hospital);

    Hospital update(Hospital hospital);

    Hospital delete(Long id);
}
