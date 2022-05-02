package com.tranining.nx2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tranining.nx2.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    HospitalRepository hospitalRepository;
    
     public HospitalServiceImpl(HospitalRepository hospitalRepository) {
		this.hospitalRepository = hospitalRepository;
	}

    @Override
    public List<Hospital> getAllHospitals() {

        List<Hospital> hospitals = hospitalRepository.findAll();
        return hospitals;
    }

    @Override
    @Cacheable(value="hospital")
    public Hospital getHospitalById(Long id) {

        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            return hospital.get();
        }
        return null;
    }

    @Override
    @Cacheable(value="hospital",key="#hospital")
    public Hospital save(Hospital hospital) {
        Hospital result = hospitalRepository.save(hospital);
        return result;
    }

    @Override
    @CachePut(value="hospital", key="#hospital")
    public Hospital update(Hospital hospital) {
        Hospital result = hospitalRepository.save(hospital);
        return result;
    }

    @Override
    @CacheEvict(value="hospital", key="#hospital")
    public Hospital delete(Long id) {
    	 Optional<Hospital> hospital = hospitalRepository.findById(id);
         if (hospital.isPresent()) {
        	 hospitalRepository.deleteById(id);
        	 return hospital.get();
         } 
         return null;
       
    }

	public HospitalRepository getHospitalRepository() {
		return hospitalRepository;
	}

	public void setHospitalRepository(HospitalRepository hospitalRepository) {
		this.hospitalRepository = hospitalRepository;
	}
    
    
}
