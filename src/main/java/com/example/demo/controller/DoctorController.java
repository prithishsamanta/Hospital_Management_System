package com.example.demo.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.*;
import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;

@RestController
@RequestMapping("/api/v1_doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id) {
        Doctor doctor = doctorRepository.findById((int) id).orElse(null);

        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable Integer id) {

        doctorRepository.deleteById((int) id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }
}
