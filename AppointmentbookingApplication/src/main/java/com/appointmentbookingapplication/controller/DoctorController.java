package com.appointmentbookingapplication.controller;


import com.appointmentbookingapplication.message.ResponseMessage;
import com.appointmentbookingapplication.model.Doctor;
import com.appointmentbookingapplication.service.DoctorService;
import com.appointmentbookingapplication.service.ExportDataToExcel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class DoctorController {

    static DoctorService doctorService;
    public List<Doctor> tempDoctorList;


    public DoctorController(DoctorService doctorService) {
        this.tempDoctorList = new ArrayList<>();
        this.doctorService = doctorService;

    }

    @GetMapping("/Admin")

    public String welcome() {
        return "welcome to the doctor portal";
    }


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file) {
        String message = " ";
        if (!file.isEmpty()) {
            try {
                doctorService.upload(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }

    @GetMapping("/doctorlist")
    public List<Doctor> getTempDoctorList() {
        return doctorService.getTempDoctorList();
    }

    @GetMapping("/retrivedoctorbySpeciality={spec}")
    public ResponseEntity<List<Doctor>> getListBySpec(@PathVariable String spec) {
        try {
            doctorService.retreiveDoctorbySpeciality(spec);
            if (doctorService.retreiveDoctorbySpeciality(spec).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctorService.retreiveDoctorbySpeciality(spec), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/write")
    public ResponseEntity<ResponseMessage> write() throws IOException {
        doctorService.write();
        return null;
    }

    @GetMapping("/updatePhonenumber")
    public void updatePhonenumber() throws IOException {

        doctorService.updatePhonenumber();
    }

    @GetMapping("/searchDocbyFirstname={fname}")
    public ResponseEntity<List<Doctor>> searchDocbyFirstname(@PathVariable String fname) {
        try {
            System.out.println("get 2 list");
            doctorService.searchDoctorByfirstname(fname);
            if (doctorService.searchDoctorByfirstname(fname).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctorService.searchDoctorByfirstname(fname), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/searchDocbylastname={lname}")
    public ResponseEntity<List<Doctor>> searchDocbyLastname(@PathVariable String lname) {
        try {
            System.out.println("get 2 list");
            doctorService.searchDoctorByLastname(lname);
            if (doctorService.searchDoctorByLastname(lname).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctorService.searchDoctorByLastname(lname), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchDocbyarea={area}")
    public ResponseEntity<List<Doctor>> searchDocbyArea(@PathVariable String area) {
        try {
            System.out.println("get 2 list");
            doctorService.searchDoctorByArea(area);
            if (doctorService.searchDoctorByArea(area).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctorService.searchDoctorByArea(area), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/excel/export")
    public ResponseEntity<?> exportDoctorInfoExcel(HttpServletResponse response, @RequestBody Doctor doctor) throws IOException {
        response.setContentType("application/octet-stream");
        String headerkey ="Content-Disposition";
        String headerValue ="attachment;filename=doctor16.xlsx";
        response.setHeader(headerkey, headerValue);
        this.tempDoctorList.add(doctor);
        ExportDataToExcel edte = new ExportDataToExcel(tempDoctorList);
        edte.export(response);
        return ResponseEntity.ok("successfully Exported");
    }


}

