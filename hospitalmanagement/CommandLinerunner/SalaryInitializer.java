package com.stickytechnologies.hospitalmanagement.CommandLinerunner;

import com.stickytechnologies.hospitalmanagement.Repository.repository.DepartmentRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.NurseRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.SalaryRepository;
import com.stickytechnologies.hospitalmanagement.entity.Department;
import com.stickytechnologies.hospitalmanagement.entity.Nurses;
import com.stickytechnologies.hospitalmanagement.entity.Salary;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(4)
@RequiredArgsConstructor
public class SalaryInitializer implements CommandLineRunner {
    private final SalaryRepository salaryRepository;
    private final NurseRepository nurseRepository;
    private final DepartmentRepository departmentRepository;

    List<String> cardioRoles = List.of(
            "Chief Cardiologist", "Senior Cardiologist", "Consultant Cardiologist", "Associate Cardiologist", "Fellow Cardiologist", "Junior Cardiologist", "Resident Cardiologist"
    );

    List<Double> cardioBasic = List.of(
            200000.0, 180000.0, 175000.0, 210000.0,
            120000.0, 100000.0, 80000.0
    );
    List<Double> cardioHRA = List.of(
            40000.0, 36000.0, 35000.0, 42000.0,
            24000.0, 20000.0, 16000.0
    );
    List<Double> cardioDA = List.of(
            20000.0, 18000.0, 17500.0, 21000.0,
            12000.0, 10000.0, 8000.0
    );
    List<Double> cardioTransport = List.of(
            10000.0, 10000.0, 8000.0, 10000.0,
            6000.0, 5000.0, 5000.0
    );
    List<Double> cardioMedical = List.of(
            8000.0, 8000.0, 7000.0, 8000.0,
            5000.0, 4000.0, 3000.0
    );
    List<Double> cardioUniform = List.of(
            2000.0, 2000.0, 2000.0, 2000.0,
            2000.0, 2000.0, 2000.0
    );
    List<Double> cardioNightShift = List.of(
            0.0, 0.0, 5000.0, 0.0,
            4000.0, 5000.0, 5000.0
    );
    List<Double> cardioOnCall = List.of(
            8000.0, 8000.0, 6000.0, 10000.0,
            4000.0, 3000.0, 2000.0
    );
    List<Double> cardioRisk = List.of(
            15000.0, 12000.0, 12000.0, 18000.0,
            6000.0, 4000.0, 3000.0
    );
    List<Double> cardioPerformance = List.of(
            20000.0, 18000.0, 15000.0, 22000.0,
            8000.0, 6000.0, 4000.0
    );
    List<Double> cardioOvertime = List.of(
            0.0, 5000.0, 5000.0, 0.0,
            4000.0, 4000.0, 4000.0
    );
    List<Double> cardioSeniority = List.of(
            12000.0, 8000.0, 7000.0, 15000.0,
            0.0, 0.0, 0.0
    );
    List<Double> cardioTax = List.of(
            30000.0, 25000.0, 24000.0, 33000.0,
            12000.0, 9000.0, 7000.0
    );
    List<Double> cardioPF = List.of(
            24000.0, 21600.0, 21000.0, 25200.0,
            14400.0, 12000.0, 9600.0
    );
    List<String> neuroRoles = List.of(
            "Senior Neurologist",
            "Neurosurgeon",
            "Interventional Neurologist",
            "Junior Neurologist",
            "Neurology Fellow",
            "Neurology Resident"
    );

    List<Double> neuroBasic = List.of(
            190000.0, 215000.0, 180000.0,
            110000.0, 95000.0, 75000.0
    );
    List<Double> neuroHRA = List.of(
            38000.0, 43000.0, 36000.0,
            22000.0, 19000.0, 15000.0
    );
    List<Double> neuroDA = List.of(
            19000.0, 21500.0, 18000.0,
            11000.0, 9500.0, 7500.0
    );
    List<Double> neuroTransport = List.of(
            10000.0, 10000.0, 10000.0,
            6000.0, 5000.0, 5000.0
    );
    List<Double> neuroMedical = List.of(
            8000.0, 8000.0, 7000.0,
            5000.0, 4000.0, 3000.0
    );
    List<Double> neuroUniform = List.of(
            2000.0, 2000.0, 2000.0,
            2000.0, 2000.0, 2000.0
    );
    List<Double> neuroNightShift = List.of(
            0.0, 0.0, 5000.0,
            4000.0, 5000.0, 5000.0
    );
    List<Double> neuroOnCall = List.of(
            8000.0, 10000.0, 7000.0,
            4000.0, 3000.0, 2000.0
    );
    List<Double> neuroRisk = List.of(
            12000.0, 18000.0, 12000.0,
            5000.0, 4000.0, 3000.0
    );
    List<Double> neuroPerformance = List.of(
            18000.0, 22000.0, 16000.0,
            7000.0, 5000.0, 4000.0
    );
    List<Double> neuroOvertime = List.of(
            0.0, 0.0, 5000.0,
            4000.0, 4000.0, 4000.0
    );
    List<Double> neuroSeniority = List.of(
            10000.0, 15000.0, 8000.0,
            0.0, 0.0, 0.0
    );
    List<Double> neuroTax = List.of(
            28000.0, 33000.0, 25000.0,
            10000.0, 8000.0, 6000.0
    );
    List<Double> neuroPF = List.of(
            22800.0, 25800.0, 21600.0,
            13200.0, 11400.0, 9000.0
    );
    List<String> radiologyRoles = List.of(
            "Senior Radiologist",
            "Interventional Radiologist",
            "Junior Radiologist",
            "Radiology Fellow",
            "Radiology Resident"
    );

    List<Double> radiologyBasic = List.of(
            170000.0, 185000.0,
            105000.0, 90000.0, 72000.0
    );
    List<Double> radiologyHRA = List.of(
            34000.0, 37000.0,
            21000.0, 18000.0, 14400.0
    );
    List<Double> radiologyDA = List.of(
            17000.0, 18500.0,
            10500.0, 9000.0, 7200.0
    );
    List<Double> radiologyTransport = List.of(
            10000.0, 10000.0,
            6000.0, 5000.0, 5000.0
    );
    List<Double> radiologyMedical = List.of(
            8000.0, 8000.0,
            5000.0, 4000.0, 3000.0
    );
    List<Double> radiologyUniform = List.of(
            2000.0, 2000.0,
            2000.0, 2000.0, 2000.0
    );
    List<Double> radiologyNightShift = List.of(
            0.0, 0.0,
            4000.0, 5000.0, 5000.0
    );
    List<Double> radiologyOnCall = List.of(
            7000.0, 8000.0,
            3000.0, 2000.0, 2000.0
    );
    List<Double> radiologyRisk = List.of(
            10000.0, 12000.0,  // radiation exposure risk
            4000.0, 3000.0, 3000.0
    );
    List<Double> radiologyPerformance = List.of(
            16000.0, 18000.0,
            7000.0, 5000.0, 4000.0
    );
    List<Double> radiologyOvertime = List.of(
            0.0, 0.0,
            4000.0, 4000.0, 4000.0
    );
    List<Double> radiologySeniority = List.of(
            10000.0, 12000.0,
            0.0, 0.0, 0.0
    );
    List<Double> radiologyTax = List.of(
            22000.0, 26000.0,
            9000.0, 7500.0, 5500.0
    );
    List<Double> radiologyPF = List.of(
            20400.0, 22200.0,
            12600.0, 10800.0, 8640.0
    );

    @Override
    public void run(String... args) throws Exception {


        Department cardio = departmentRepository.findById(2L).orElseThrow(() -> new RuntimeException("not found"));

        Department neuro = departmentRepository.findById(1L).orElseThrow(() -> new RuntimeException("not found"));

        Department radio = departmentRepository.findById(4L).orElseThrow(() -> new RuntimeException("not found"));

        for (int i = 0; i < cardioRoles.size(); i++) {

            Salary salary = new Salary();

            salary.setRole(cardioRoles.get(i));
            salary.setDepartment(cardio);

            salary.setHouseRentAllowance(cardioHRA.get(i));

            salary.setDearnessAllowance(cardioDA.get(i));

            salary.setMedicalAllowance(cardioMedical.get(i));

            salary.setNightShiftAllowance(cardioNightShift.get(i));

            salary.setOnCallAllowance(cardioOnCall.get(i));

            salary.setOvertimeAllowance(cardioOvertime.get(i));

            salary.setTransportAllowance(cardioTransport.get(i));

            salary.setPerformanceBonus(cardioPerformance.get(i));

            salary.setRiskAllowance(cardioRisk.get(i));

            salary.setGradePay(i + 1);

            salary.setTaxDeduction(cardioTax.get(i));

            salary.setSeniorityAllowance(cardioSeniority.get(i));

            salary.setProvidentFund(cardioPF.get(i));

            salary.setUniformAllowance(cardioUniform.get(i));

            salary.setSalary(cardioBasic.get(i) + cardioHRA.get(i) + cardioDA.get(i)
                    + cardioTransport.get(i) + cardioMedical.get(i) + cardioUniform.get(i)
                    + cardioNightShift.get(i) + cardioOnCall.get(i) + cardioRisk.get(i)
                    + cardioPerformance.get(i) + cardioOvertime.get(i) + cardioSeniority.get(i)
                    - cardioTax.get(i) - cardioPF.get(i)
            );

            salaryRepository.save(salary);
        }

        for (int i = 0; i < neuroRoles.size(); i++) {

            Salary salary = new Salary();

            salary.setRole(neuroRoles.get(i));
            salary.setDepartment(neuro);

            salary.setHouseRentAllowance(neuroHRA.get(i));

            salary.setDearnessAllowance(neuroDA.get(i));

            salary.setMedicalAllowance(neuroMedical.get(i));

            salary.setNightShiftAllowance(neuroNightShift.get(i));

            salary.setOnCallAllowance(neuroOnCall.get(i));

            salary.setOvertimeAllowance(neuroOvertime.get(i));

            salary.setTransportAllowance(neuroTransport.get(i));

            salary.setPerformanceBonus(neuroPerformance.get(i));

            salary.setRiskAllowance(neuroRisk.get(i));

            salary.setGradePay(i + 1);

            salary.setTaxDeduction(neuroTax.get(i));

            salary.setSeniorityAllowance(neuroSeniority.get(i));

            salary.setProvidentFund(neuroPF.get(i));

            salary.setUniformAllowance(neuroUniform.get(i));

            salary.setSalary(neuroBasic.get(i) + neuroHRA.get(i) + neuroDA.get(i)
                    + neuroTransport.get(i) + neuroMedical.get(i) + neuroUniform.get(i)
                    + neuroNightShift.get(i) + neuroOnCall.get(i) + neuroRisk.get(i)
                    + neuroPerformance.get(i) + neuroOvertime.get(i) + neuroSeniority.get(i)
                    - neuroTax.get(i) - neuroPF.get(i)
            );

            salaryRepository.save(salary);

        }
        for (int i = 0; i < radiologyRoles.size(); i++) {

            Salary salary = new Salary();

            salary.setRole(radiologyRoles.get(i));
            salary.setDepartment(radio);

            salary.setHouseRentAllowance(radiologyHRA.get(i));

            salary.setDearnessAllowance(radiologyDA.get(i));

            salary.setMedicalAllowance(radiologyMedical.get(i));

            salary.setNightShiftAllowance(radiologyNightShift.get(i));

            salary.setOnCallAllowance(radiologyOnCall.get(i));

            salary.setOvertimeAllowance(radiologyOvertime.get(i));

            salary.setTransportAllowance(radiologyTransport.get(i));

            salary.setPerformanceBonus(radiologyPerformance.get(i));

            salary.setRiskAllowance(radiologyRisk.get(i));

            salary.setGradePay(i + 1);

            salary.setTaxDeduction(radiologyTax.get(i));

            salary.setSeniorityAllowance(radiologySeniority.get(i));

            salary.setProvidentFund(radiologyPF.get(i));

            salary.setUniformAllowance(radiologyUniform.get(i));

            salary.setSalary(radiologyBasic.get(i) + radiologyHRA.get(i) + radiologyDA.get(i)
                    + radiologyTransport.get(i) + radiologyMedical.get(i) + radiologyUniform.get(i)
                    + radiologyNightShift.get(i) + radiologyOnCall.get(i) + radiologyRisk.get(i)
                    + radiologyPerformance.get(i) + radiologyOvertime.get(i) + radiologySeniority.get(i)
                    - radiologyTax.get(i) - radiologyPF.get(i)
            );

            salaryRepository.save(salary);

        }

    }
}
