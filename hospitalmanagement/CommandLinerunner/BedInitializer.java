package com.stickytechnologies.hospitalmanagement.CommandLinerunner;

import com.stickytechnologies.hospitalmanagement.Repository.repository.BedsRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.DepartmentRepository;
import com.stickytechnologies.hospitalmanagement.Repository.repository.WardRepository;
import com.stickytechnologies.hospitalmanagement.entity.Beds;
import com.stickytechnologies.hospitalmanagement.entity.Department;
import com.stickytechnologies.hospitalmanagement.entity.Ward;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(3)
public class BedInitializer implements CommandLineRunner {

    private final BedsRepository bedsRepository;

    private final DepartmentRepository departmentRepository;

    private final WardRepository wardRepository;

    @Override

    public void run(String... args) {

        if (bedsRepository.count() > 0) return;


        Ward cardioward = wardRepository.findById("maxCw@2").orElseThrow(() -> new RuntimeException("Ward Not found"));

        Ward neuroward = wardRepository.findById("maxNu@1").orElseThrow(() -> new RuntimeException("Ward Not found"));

        Ward Radioward = wardRepository.findById("maxRd@4").orElseThrow(() -> new RuntimeException("Ward Not found"));

        for (int i = 1; i <= 20; i++) {

            Beds bed = new Beds();

            bed.setBedno(i);

            bed.setId(cardioward.getId() + (i +0));

            bed.setWard(cardioward);

            bed.setOccupied(false);

            bedsRepository.save(bed);

        }

        for (int i = 1; i <= 20; i++) {

            Beds neurobed = new Beds();

            neurobed.setBedno(i);

            neurobed.setWard(neuroward);

            neurobed.setId(neuroward.getId() + (i + 0));

            neurobed.setOccupied(false);

            bedsRepository.save(neurobed);

        }

        for (int i = 1; i <= 20; i++) {

            Beds Radiobed = new Beds();

            Radiobed.setBedno(i);

            Radiobed.setWard(Radioward);

            Radiobed.setOccupied(false);

            Radiobed.setId(Radioward.getId() + (i + 0));

            bedsRepository.save(Radiobed);

        }

    }

}
