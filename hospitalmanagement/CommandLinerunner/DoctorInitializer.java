package com.stickytechnologies.hospitalmanagement.CommandLinerunner;

import com.stickytechnologies.hospitalmanagement.Repository.repository.DepartmentRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.DoctorRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.SalaryRepository;
import com.stickytechnologies.hospitalmanagement.entity.Department;
import com.stickytechnologies.hospitalmanagement.entity.Doctors;
import com.stickytechnologies.hospitalmanagement.entity.Salary;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Order(6)
@RequiredArgsConstructor

public class DoctorInitializer implements CommandLineRunner {
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;
    private  final SalaryRepository salaryRepository;
    List<String> cardiodoctors = List.of("Dr.Aneesh Thakur", "Dr.Abhay Sharma", "Dr.Rajesh Kumar",

            "Dr.Uday Patil", "Dr.Akshay Singh", "Dr.Dhiraj Kumar", "Dr.Kishore Kumar");

    List<String> cardioDesignation = List.of(
            "Chief Cardiologist", "Senior Cardiologist", "Consultant Cardiologist", "Associate Cardiologist", "Fellow Cardiologist", "Junior Cardiologist", "Resident Cardiologist"
    );
    List<Integer> cardioprice = List.of(
            3500, 2800, 2300, 2000, 1700, 1300, 1000
    );

    List<String> neuroDesignation = List.of(
            "Chief Neurologist", "Senior Neurologist", "Associate Neurologist", "Junior Neurologist"
    );
    List<Integer> neuroprice = List.of(
            3200, 2600, 1900, 1300
    );

    List<String> oncoDesignation = List.of(
            "Chief Oncologist", "Senior Oncologist", "Associate Oncologist", "Junior Oncologist"
    );
    List<Integer> oncoprice = List.of(
            3500, 2800, 2000, 1400
    );

    List<String> radioDesignation = List.of(
            "Chief Radiologist", "Senior Radiologist", "Associate Radiologist", "Junior Radiologist"
    );
    List<Integer> radioprice = List.of(
            2900, 2400, 1700, 1200
    );

    List<String> opthaDesignation = List.of(
            "Chief Opthalmologist", "Senior Opthalmologist", "Associate Opthalmologist", "Junior Opthalmologist"
    );
    List<Integer> opthaprice = List.of(
            2700, 2300, 1800, 1100
    );
    List<String> doctorImageUrls = List.of(
            "https://images.unsplash.com/photo-1559839734-2b71ea197ec2?w=300",
            "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?w=300",
            "https://images.unsplash.com/photo-1594824476967-48c8b964273f?w=300",
            "https://images.unsplash.com/photo-1651008376811-b90baee60c1f?w=300",
            "https://images.unsplash.com/photo-1622253692010-333f2da6031d?w=300",
            "https://images.unsplash.com/photo-1537368910025-700350fe46c7?w=300",
            "https://images.unsplash.com/photo-1582750433449-648ed127bb54?w=300"
    );

    List<String> neurodoctors = List.of("Dr.Arjun Mehta", "Dr.Sarah Connelly",
            "Dr.Rohan Verma", "Dr.Priya Nair");

    List<String> Oncodoctors = List.of("Dr.James Whitfield", "Dr.Ananya Krishnan",
            "Dr.Marcus Delgado", "Dr.Fatima Al-Rashid");

    List<String> Radiodoctors = List.of("Dr. Samuel Okafor", " Dr. Leena Sharma", "Dr. David Thornton", "Dr. Mei Lin");

    List<String> Opthadoctors = List.of("Dr. Rahul Gupta", "Dr. Sophia Laurent", "Dr. Tariq Hussain", "Dr. Emily Hargrove");

    @Override
    public void run(String... args) throws Exception {
        if (doctorRepository.count() > 0) return;
        Department cardio = departmentRepository.findById(2L).orElseThrow(() -> new RuntimeException("Department Not found"));

        Department neuro = departmentRepository.findById(1L).orElseThrow(() -> new RuntimeException("Department Not found"));

        Department Onco = departmentRepository.findById(3L).orElseThrow(() -> new RuntimeException("Department Not found"));

        Department Radio = departmentRepository.findById(4L).orElseThrow(() -> new RuntimeException("Department Not found"));

        Department Optha = departmentRepository.findById(5L).orElseThrow(() -> new RuntimeException("Department Not found"));

        {
            for (int i = 0; i < cardiodoctors.size(); i++) {

                Doctors doctor = new Doctors();

                Salary salary=salaryRepository.findByRole(cardioDesignation.get(i));


                doctor.setId("maxd@" + cardio.getId() + (i + 1));

                doctor.setPassword("D@"+ cardio.getId() + (i + 1));

                doctor.setCardioDepartment(cardio);

                doctor.setDesignation(cardioDesignation.get(i));

                doctor.setDoctorname(cardiodoctors.get(i));

                doctor.setPrice("₹"+cardioprice.get(i));

                doctor.setOccupied(false);

                doctor.setFloor(Math.toIntExact(cardio.getId()));

                doctor.setRoom_no(cardio.getId() + "0" + (i + 1));

                doctor.setSalary(salary);

                doctor.setDoctor_image(doctorImageUrls.get(i));

                doctorRepository.save(doctor);

            }
            for (int i = 0; i < neurodoctors.size(); i++) {

                Doctors neurodoctor = new Doctors();

                neurodoctor.setId("maxd@" + neuro.getId() + (i + 1));

                neurodoctor.setPassword("D@"+ neuro.getId() + (i + 1));

                neurodoctor.setDoctorname(neurodoctors.get(i));

                neurodoctor.setCardioDepartment(neuro);

                neurodoctor.setOccupied(false);

                neurodoctor.setDesignation(neuroDesignation.get(i));

                neurodoctor.setPrice("₹"+neuroprice.get(i));

                neurodoctor.setFloor(Math.toIntExact(neuro.getId()));

                neurodoctor.setRoom_no(neuro.getId()+"0"+(i+1));

                doctorRepository.save(neurodoctor);

            }

            for (int i = 0; i < Oncodoctors.size(); i++) {
                Doctors Oncodoctor = new Doctors();

                Oncodoctor.setId("maxd@" + Onco.getId() + (i + 1));

                Oncodoctor.setDoctorname(Oncodoctors.get(i));

                Oncodoctor.setCardioDepartment(Onco);

                Oncodoctor.setOccupied(false);

                Oncodoctor.setDesignation(oncoDesignation.get(i));

                Oncodoctor.setPrice("₹"+oncoprice.get(i));

                Oncodoctor.setFloor(Math.toIntExact(Onco.getId()));

                Oncodoctor.setRoom_no(Onco.getId()+"0"+(i+1));

                doctorRepository.save(Oncodoctor);

            }

            for (int i = 0; i < Radiodoctors.size(); i++) {

                Doctors Radiodoctor = new Doctors();

                Radiodoctor.setId("maxd@" + Radio.getId() + (i + 1));

                Radiodoctor.setDoctorname(Radiodoctors.get(i));

                Radiodoctor.setCardioDepartment(Radio);

                Radiodoctor.setOccupied(false);

                Radiodoctor.setDesignation(radioDesignation.get(i));

                Radiodoctor.setPrice("₹"+radioprice.get(i));

                Radiodoctor.setFloor(Math.toIntExact(Radio.getId()));

                Radiodoctor.setRoom_no(Radio.getId()+"0"+(i+1));

                doctorRepository.save(Radiodoctor);

            }
            for (int i = 0; i < Opthadoctors.size(); i++) {
                Doctors Opthadoctor = new Doctors();

                Opthadoctor.setId("maxd@" + Optha.getId() + (i + 1));

                Opthadoctor.setDoctorname(Opthadoctors.get(i));

                Opthadoctor.setCardioDepartment(Optha);

                Opthadoctor.setOccupied(false);

                Opthadoctor.setDesignation(opthaDesignation.get(i));

                Opthadoctor.setFloor(Math.toIntExact(Optha.getId()));

                Opthadoctor.setPrice("₹"+opthaprice.get(i));

                Opthadoctor.setRoom_no(Optha.getId()+"0"+(i+1));

                doctorRepository.save(Opthadoctor);

            }
        }
    }
}
