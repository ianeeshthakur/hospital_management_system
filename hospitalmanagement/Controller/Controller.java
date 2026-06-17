package com.stickytechnologies.hospitalmanagement.Controller;


import com.stickytechnologies.hospitalmanagement.dtos.Request.DoctorAddDto;
import com.stickytechnologies.hospitalmanagement.dtos.Request.DoctorRequestdto;
import com.stickytechnologies.hospitalmanagement.dtos.Request.LoginDto;
import com.stickytechnologies.hospitalmanagement.dtos.Response.*;
import com.stickytechnologies.hospitalmanagement.dtos.Request.Requestdto;
import com.stickytechnologies.hospitalmanagement.entity.AppointmentPatients;
import com.stickytechnologies.hospitalmanagement.entity.Doctors;
import com.stickytechnologies.hospitalmanagement.entity.Patient;
import com.stickytechnologies.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class Controller {
    private final PatientService patientService;
    private final ModelMapper modelMapper;

@GetMapping("/viewpatients")
public ResponseEntity<List<ResponseDto>> getallpatient(){

List<ResponseDto> patients=patientService.getallpatients();

return ResponseEntity.ok().body(patients);

}

@GetMapping("/{id}")

public ResponseEntity<ResponseDto> getpatientByid(@PathVariable Long id){

    return ResponseEntity.ok(patientService.getpatientByid(id));

}

//@GetMapping("/viewdoctors")
//public ResponseEntity<List<Doctordto>> viewdoctor(@RequestBody DoctorRequestdto doctorRequestdto){
//    Doctors d=modelMapper.map()
//    List<Doctors> doctor=patientService.viewdoctors();
//    Doctordto response=modelMapper.map(doctor,Doctordto.class);
//}

    @PostMapping("/admit")
    public ResponseEntity<ResponseDto> savepatient(@RequestBody Requestdto requestdto){
Patient patient= modelMapper.map(requestdto, Patient.class);
Patient saved=patientService.savepatient(patient);
ResponseDto response=modelMapper.map(saved, ResponseDto.class);
        response.setBedNo(saved.getBeds().getBedno());
return ResponseEntity.status(201).header("Hospital-name","Satya Hospitals").body(response);
    }

    @DeleteMapping("/dischargepatient/{id}")
public ResponseEntity<ResponseDto> dischargepatient(@PathVariable Long id){

    return ResponseEntity.ok().body(patientService.dischargepatient(id));
    }

    @PutMapping("/{id}")

    public ResponseEntity<ResponseDto> updatepatientdata(@PathVariable Long id,@RequestBody Requestdto requestdto){
    Patient patient=modelMapper.map(requestdto, Patient.class);
    Patient saved=patientService.updatepatient(patient,id);
  ResponseDto response=modelMapper.map(saved, ResponseDto.class);
  return ResponseEntity.ok().body(response);
    }

    @PostMapping("/appointmentpatients")
public ResponseEntity<AppointmentDto> appointmentpatient(@RequestBody Requestdto requestdto){
  AppointmentPatients patient=modelMapper.map(requestdto, AppointmentPatients.class);
  AppointmentDto saved=patientService.appointmentpatient(patient);
//  AppointmentDto response=modelMapper.map(saved,AppointmentDto.class);

  return ResponseEntity.ok().body(saved);
    }

@PostMapping("/login")
public ResponseEntity<ProfileDto> logininfo(@RequestBody LoginDto loginDto){
    Doctors d=modelMapper.map(loginDto, Doctors.class);
    Doctors found=patientService.loginInfo(d);
    ProfileDto result=modelMapper.map(found, ProfileDto.class);
result.setMessage("Welcome"+result.getDoctorname());
    return ResponseEntity.ok().body(result);
}
@PostMapping("/CardioDoctors")
public ResponseEntity<DoctorApprovalDto> addDoctor(@RequestBody DoctorAddDto doctorAddDto){
    Doctors d=modelMapper.map(doctorAddDto, Doctors.class);
    Doctors add=patientService.addCardioDoctor(d);
    DoctorApprovalDto pending=modelMapper.map(add, DoctorApprovalDto.class);
    pending.setMessage("Doctor Added");
    return ResponseEntity.ok().body(pending);
}

}
