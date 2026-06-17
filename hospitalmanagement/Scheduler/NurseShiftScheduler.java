package com.stickytechnologies.hospitalmanagement.Scheduler;

import com.stickytechnologies.hospitalmanagement.Repository.repository.NurseRepository;
import com.stickytechnologies.hospitalmanagement.entity.Nurses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NurseShiftScheduler {
        @Autowired
    NurseRepository nurseRepository;


        @Scheduled(cron = "0 0 0 * * *")
    public void shift() {
            List<Nurses> nurses = nurseRepository.findAll();
            for (int i = 0; i < nurses.size(); i++) {
                Nurses nurse=nurses.get(i);
              if("Morning".equalsIgnoreCase(nurse.getShift_session())){
                  nurse.setShift_session("Evening");
              }else if("Evening".equalsIgnoreCase(nurse.getShift_session())){
                  nurse.setShift_session("Night");
              } else if ("Night".equalsIgnoreCase(nurse.getShift_session())) {
                  nurse.setShift_session("Morning");
              }
              nurseRepository.save(nurse);
            }

        }
}
