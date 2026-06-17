    package com.stickytechnologies.hospitalmanagement.CommandLinerunner;

    import com.stickytechnologies.hospitalmanagement.Repository.repository.DepartmentRepository;
    import com.stickytechnologies.hospitalmanagement.Repository.repository.DoctorRepository;
    import com.stickytechnologies.hospitalmanagement.Repository.repository.NurseRepository;
    import com.stickytechnologies.hospitalmanagement.entity.Department;
    import lombok.RequiredArgsConstructor;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.core.annotation.Order;
    import org.springframework.stereotype.Component;

    import java.util.List;

    @Component
    @Order(1)
    @RequiredArgsConstructor

    public class DepartmentInitializer implements CommandLineRunner {
        private final DepartmentRepository departmentRepository;
        private final NurseRepository nurseRepository;
        private final DoctorRepository doctorRepository;
        private final DoctorInitializer doctorInitializer;
        List<String> department = List.of("Neurology", "Cardiology", "Oncology", "Radiology", "Opthalmology", "Pulmonolgy"
                ,"Urology");


        @Override
        public void run(String... args) throws Exception {

            if (departmentRepository.count() > 0) return;
            for (int i = 0; i < department.size(); i++) {
                Department departments = new Department();

                departments.setDepartments(department.get(i));

//                departments.setTotal_nurses(nurseRepository.countByDepartmentId(i+1L));

//                departments.setTotal_doctors(doctorRepository.countBycardioDepartmentId(i+1L));

                departmentRepository.save(departments);
            }
        }
    }
