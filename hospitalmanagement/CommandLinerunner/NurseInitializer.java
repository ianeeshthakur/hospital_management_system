package com.stickytechnologies.hospitalmanagement.CommandLinerunner;

import com.stickytechnologies.hospitalmanagement.Repository.repository.DepartmentRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.NurseRepository;
import com.stickytechnologies.hospitalmanagement.entity.Department;
import com.stickytechnologies.hospitalmanagement.entity.Nurses;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(5)
@RequiredArgsConstructor
public class NurseInitializer implements CommandLineRunner {
    private final NurseRepository nurseRepository;
    private final DepartmentRepository departmentRepository;

    List<String> cardionurselist = List.of(
            "Priya Sharma",
            "Anjali Verma",
            "Sunita Patel",
            "Rekha Singh",
            "Meena Kumari",
            "Pooja Nair",
            "Kavita Rao",
            "Deepa Mishra",
            "Anita Joshi",
            "Shalini Gupta"
    );
    List<String> neuronurselist = List.of(
            "Sneha Iyer",
            "Ritu Sharma",
            "Pallavi Nair",
            "Divya Menon"
    );

    List<String> opthalmnurselist = List.of(
            "Neha Gupta",
            "Smita Joshi",
            "Rashmi Patel",
            "Leena Verma"
    );

    List<String> pulmonnurselist = List.of(
            "Geeta Singh",
            "Usha Rani",
            "Mamta Sharma",
            "Kiran Bala"
    );

    List<String> radionurselist = List.of(
            "Sunita Mishra",
            "Archana Rao",
            "Meera Nair",
            "Priti Kumari"
    );

    List<String> onconurselist = List.of(
            "Ananya Pillai",
            "Roshni Sharma",
            "Kavitha Nair",
            "Sudha Menon"
    );

    List<String> shifts=List.of("Morning","Evening","Night");

    @Override
    public void run(String... args) throws Exception {
        if(nurseRepository.count()>0) return;

        Department cardiology=departmentRepository.findById(2L).orElseThrow(()->new IllegalArgumentException("not found"));

        Department neurology=departmentRepository.findById(1L).orElseThrow(()->new IllegalArgumentException("not found"));

        Department oncology=departmentRepository.findById(3L).orElseThrow(()->new IllegalArgumentException("not found"));

        Department radiology=departmentRepository.findById(4L).orElseThrow(()->new IllegalArgumentException("not found"));

        Department opthalmology=departmentRepository.findById(5L).orElseThrow(()->new IllegalArgumentException("not found"));

        Department pulmonology=departmentRepository.findById(6L).orElseThrow(()->new IllegalArgumentException("not found"));



       for (int i=0;i<10;i++){

            Nurses cardionurse=new Nurses();

            cardionurse.setName(cardionurselist.get(i));

            cardionurse.setDepartment(cardiology);

            cardionurse.setShift_session(shifts.get(i%3));

            cardionurse.setGender("female");

            cardionurse.setId("maxn@"+cardiology.getId()+(i+1));

            nurseRepository.save(cardionurse);

        }

        for (int i=0;i<4;i++){

            Nurses neuronurse=new Nurses();

            neuronurse.setName(neuronurselist.get(i));

            neuronurse.setDepartment(neurology);

            neuronurse.setShift_session(shifts.get(i%3));

            neuronurse.setGender("female");

            neuronurse.setId("maxn@"+neurology.getId()+(i+1));

            nurseRepository.save(neuronurse);

        }
        for (int i=0;i<4;i++){

            Nurses radionurse=new Nurses();

            radionurse.setName(radionurselist.get(i));

            radionurse.setDepartment(radiology);

            radionurse.setShift_session(shifts.get(i%3));

            radionurse.setGender("female");

            radionurse.setId("maxn@"+radiology.getId()+(i+1));

            nurseRepository.save(radionurse);

        }
        for (int i=0;i<4;i++){

            Nurses onconurse=new Nurses();

            onconurse.setName(onconurselist.get(i));

            onconurse.setDepartment(oncology);

            onconurse.setShift_session(shifts.get(i%3));

            onconurse.setGender("female");

            onconurse.setId("maxn@"+oncology.getId()+(i+1));

            nurseRepository.save(onconurse);

        }

        for (int i=0;i<4;i++){

            Nurses opthanurse=new Nurses();

            opthanurse.setName(opthalmnurselist.get(i));

            opthanurse.setDepartment(opthalmology);

            opthanurse.setShift_session(shifts.get(i%3));

            opthanurse.setGender("female");

            opthanurse.setId("maxn@"+opthalmology.getId()+(i+1));

            nurseRepository.save(opthanurse);

        }
        for (int i=0;i<4;i++){

            Nurses pulmonurse=new Nurses();

            pulmonurse.setName(pulmonnurselist.get(i));

            pulmonurse.setDepartment(pulmonology);

            pulmonurse.setShift_session(shifts.get(i%3));

            pulmonurse.setGender("female");

            pulmonurse.setId("maxn@"+pulmonology.getId()+(i+1));

            nurseRepository.save(pulmonurse);

        }
    }
}
