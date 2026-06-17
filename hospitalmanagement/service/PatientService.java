package com.stickytechnologies.hospitalmanagement.service;

import com.stickytechnologies.hospitalmanagement.CommandLinerunner.DoctorInitializer;
import com.stickytechnologies.hospitalmanagement.Repository.repository.*;
import com.stickytechnologies.hospitalmanagement.dtos.Response.AppointmentDto;
import com.stickytechnologies.hospitalmanagement.dtos.Response.ProfileDto;
import com.stickytechnologies.hospitalmanagement.dtos.Response.ResponseDto;
import com.stickytechnologies.hospitalmanagement.entity.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final BedsRepository bedsRepository;
    private final AppointmentRepo appointmentRepo;
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    private final LoginRepository loginRepository;
private final DoctorInitializer doctorInitializer;
    @Transactional
    public Patient savepatient(Patient patient) {

        Beds b = bedsRepository.findFirstByOccupiedFalseOrderByBednoAsc();
        if (b == null) {
            throw new RuntimeException("Beds Not Available");
        }
        b.setOccupied(true);
        b.setPatient(patient);
        patient.setBeds(b);
        return patientRepository.save(patient);

    }

    public List<ResponseDto> getallpatients() {
        return patientRepository.findAll().stream().
                map(patient -> modelMapper.map(patient, ResponseDto.class)).toList();
    }

    public ResponseDto getpatientByid(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient Doesn't exists"));
        return modelMapper.map(patient, ResponseDto.class);
    }

    @Transactional
    public ResponseDto dischargepatient(Long id) {
        Patient found = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient Not Found"));
        found.setDischarged(true);

        Beds beds = found.getBeds();
        if (beds != null) {
            beds.setOccupied(false);
            beds.setPatient(null);
        }
        found.setBeds(null);

        return modelMapper.map(found, ResponseDto.class);

    }

    public Patient updatepatient(Patient patient, Long id) {
        Patient p = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("patient doesn't exist"));
        p.setName(patient.getName());
        p.setEmail(patient.getEmail());
        p.setGender(patient.getGender());
        p.setBirthdate(patient.getBirthdate());
        return patientRepository.save(p);

    }

    public AppointmentDto appointmentpatient(AppointmentPatients patient) {


        if ("heart".equalsIgnoreCase(patient.getDisease())) {
            Doctors doctors = doctorRepository.findFirstByOccupiedFalseAndCardioDepartmentName("cardiology");


            if (doctors == null) {
                throw new RuntimeException("No cardiac doctors available");
            }

            patient.setDoctors(doctors);
            doctors.setPatints(patient);
            doctors.setOccupied(true);
        }
        if ("brain".equalsIgnoreCase(patient.getDisease())) {
            Doctors doctors = doctorRepository.findFirstByOccupiedFalseAndCardioDepartmentName("neurology");

            if (doctors == null) {
                throw new RuntimeException("No cardiac doctors available");
            }

            patient.setDoctors(doctors);
            doctors.setPatints(patient);
            doctors.setOccupied(true);
        }
        AppointmentPatients saved = appointmentRepo.save(patient);
        AppointmentDto dto = new AppointmentDto();
        dto.setName(saved.getName());
        dto.setDoctorName(saved.getDoctors().getDoctorname());
        dto.setId((int) saved.getId());
        dto.setEmail(saved.getEmail());


        return dto;
    }

    public Doctors loginInfo(Doctors d) {
        Doctors result = doctorRepository.findByPasswordAndId(d.getPassword(), d.getId());
        if (result == null) {
            throw new RuntimeException("Credentials Not Valid");
        }
        LoginRecords login = new LoginRecords();
        login.setName(result.getDoctorname());


        LocalTime now=LocalTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm:ss a");
String formattedTime=now.format(formatter);

login.setLogin_time(formattedTime);
        loginRepository.save(login);
        return result;
    }

    public Doctors addCardioDoctor(Doctors d) {
        Doctors doctors=new Doctors();
        doctors.setDoctorname(d.getDoctorname());
        doctors.setDesignation(d.getDesignation());
        doctors.setCardioDepartment(d.getCardioDepartment());
    }

//    public List<Doctors> viewdoctors() {
//
//    }
}