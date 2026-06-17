package com.stickytechnologies.hospitalmanagement.CommandLinerunner;

import com.stickytechnologies.hospitalmanagement.Repository.repository.BedsRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.DepartmentRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.WardRepository;
import com.stickytechnologies.hospitalmanagement.entity.Department;
import com.stickytechnologies.hospitalmanagement.entity.Ward;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@RequiredArgsConstructor
public class WardInitializer implements CommandLineRunner {
    private final WardRepository wardRepository;
    private final DepartmentRepository departmentRepository;
    private final BedsRepository bedsRepository;
    @Override
    public void run(String... args) throws Exception {

        if(wardRepository.count()>0)return;

        Department cardio=departmentRepository.findById(2L).orElseThrow(()-> new RuntimeException("Department Not found"));

        Department neuro=departmentRepository.findById(1L).orElseThrow(()-> new RuntimeException("Department Not found"));

        Department Onco=departmentRepository.findById(3L).orElseThrow(()-> new RuntimeException("Department Not found"));

        Department Radio=departmentRepository.findById(4L).orElseThrow(()-> new RuntimeException("Department Not found"));

        Department Optha=departmentRepository.findById(5L).orElseThrow(()-> new RuntimeException("Department Not found"));

        Department Pulmon=departmentRepository.findById(6L).orElseThrow(()-> new RuntimeException("Department Not found"));



        Ward cardioward=new Ward();

        cardioward.setId("maxCw@2");

        cardioward.setWardtype("CardioICU");

        cardioward.setFloor(Math.toIntExact(cardio.getId()));


        cardioward.setWardname("Cardiac Intensive Care Unit");

        wardRepository.save(cardioward);


        Ward neuroward=new Ward();

        neuroward.setId("maxNu@1");

        neuroward.setWardtype("NeuroICU");

        neuroward.setFloor(Math.toIntExact(neuro.getId()));

        neuroward.setWardname("Neuro Intensive Care Unit");

        wardRepository.save(neuroward);


        Ward Oncoward=new Ward();

        Oncoward.setId("maxOn@3");

        Oncoward.setWardtype("OncoWard");

        Oncoward.setFloor(Math.toIntExact(Onco.getId()));

        Oncoward.setWardname("Oncology Care Unit");

        wardRepository.save(Oncoward);



        Ward Radioward=new Ward();

        Radioward.setId("maxRd@4");

        Radioward.setWardtype("RadioWard");

        Radioward.setFloor(Math.toIntExact(Radio.getId()));

        Radioward.setWardname("Radiology Care Unit");

        wardRepository.save(Radioward);



        Ward Opthaward=new Ward();

        Opthaward.setId("maxOp@5");

        Opthaward.setWardtype("OpthaWard");

        Opthaward.setFloor(Math.toIntExact(Optha.getId()));

        Opthaward.setWardname("Ophthalmology Care Unit");

        wardRepository.save(Opthaward);


        Ward PulmonWard=new Ward();

        PulmonWard.setId("maxPu@6");

        PulmonWard.setWardtype("PulmoWard");

        PulmonWard.setFloor(Math.toIntExact(Pulmon.getId()));

        PulmonWard.setWardname("Pulmonology Care Unit");

        wardRepository.save(PulmonWard);
    }
}
