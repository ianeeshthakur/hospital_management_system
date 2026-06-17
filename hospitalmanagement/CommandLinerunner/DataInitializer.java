package com.stickytechnologies.hospitalmanagement.CommandLinerunner;

import com.stickytechnologies.hospitalmanagement.Repository.repository.DepartmentRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.DoctorRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.NurseRepository;
import com.stickytechnologies.hospitalmanagement.entity.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public void run(String... args) throws Exception {
        Integer cardionurses=nurseRepository.countByDepartmentId(2L);

        Integer neuronurses=nurseRepository.countByDepartmentId(1L);

        Integer onconurses=nurseRepository.countByDepartmentId(3L);

        Integer radionurses=nurseRepository.countByDepartmentId(4L);

        Integer Opthanurses=nurseRepository.countByDepartmentId(5L);

        Integer pulmonurses=nurseRepository.countByDepartmentId(6L);

        Integer uronurses=nurseRepository.countByDepartmentId(7L);

        Integer cardiodoctors=doctorRepository.countBycardioDepartmentId(2L);

        Integer neurodoctors=doctorRepository.countBycardioDepartmentId(1L);

        Integer radiodoctors=doctorRepository.countBycardioDepartmentId(4L);

        Integer oncodoctors=doctorRepository.countBycardioDepartmentId(3L);

        Integer Opthadoctors=doctorRepository.countBycardioDepartmentId(5L);

        Integer Pulmodoctors=doctorRepository.countBycardioDepartmentId(6L);

        Integer UroDoctors=doctorRepository.countBycardioDepartmentId(7L);



        Department cardio=departmentRepository.findById(2L).orElseThrow(()->new RuntimeException("Not found"));

        cardio.setTotal_nurses(cardionurses);

        cardio.setTotal_doctors(cardiodoctors);

        departmentRepository.save(cardio);





        Department neuro=departmentRepository.findById(1L).orElseThrow(()->new RuntimeException("Not found"));

        neuro.setTotal_nurses(neuronurses);

        neuro.setTotal_doctors(neurodoctors);

        departmentRepository.save(neuro);




        Department onco=departmentRepository.findById(3L).orElseThrow(()->new RuntimeException("Not found"));

        onco.setTotal_nurses(onconurses);

        onco.setTotal_doctors(oncodoctors);

        departmentRepository.save(onco);




        Department radio=departmentRepository.findById(4L).orElseThrow(()->new RuntimeException("Not found"));

        radio.setTotal_nurses(radionurses);

        radio.setTotal_doctors(radiodoctors);

        departmentRepository.save(radio);

        Department Optha=departmentRepository.findById(5L).orElseThrow(()->new RuntimeException("Not found"));

        Optha.setTotal_nurses(Opthanurses);

        Optha.setTotal_doctors(Opthadoctors);

        departmentRepository.save(Optha);



        Department Pulmo=departmentRepository.findById(6L).orElseThrow(()->new RuntimeException("Not found"));

        Pulmo.setTotal_nurses(pulmonurses);

        Pulmo.setTotal_doctors(Pulmodoctors);

        departmentRepository.save(Pulmo);

        Department Urology=departmentRepository.findById(7L).orElseThrow(()->new RuntimeException("Not found"));

        Urology.setTotal_nurses(uronurses);

        Urology.setTotal_doctors(UroDoctors);

        departmentRepository.save(Urology);



    }
}
