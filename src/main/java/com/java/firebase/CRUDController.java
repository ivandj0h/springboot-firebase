package com.java.firebase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CRUDController {

    public CRUDService crudService;

    public CRUDController(CRUDService crudService) {
        this.crudService = crudService;
    }

    // create user by using POST Mapping
    @PostMapping("/create")
    public String createCRUD(@RequestBody CRUD crud) throws InterruptedException, ExecutionException {
        return crudService.createCRUD(crud);
    }

    // get users by using GET Mapping
    @GetMapping("/user")
    public CRUD getCRUD(@RequestParam String docId) throws InterruptedException, ExecutionException {
        return crudService.getCRUD(docId);
    }

    // Update user by using PUT Mapping
    @PutMapping("/update")
    public String updateCRUD(@RequestBody CRUD crud) throws InterruptedException, ExecutionException {
        return crudService.updateCRUD(crud);
    }

    // Delete user by using DELETE Mapping
    @DeleteMapping("/delete")
    public String deleteCRUD(@RequestParam String docId) throws InterruptedException, ExecutionException {
        return crudService.deleteCRUD(docId);
    }

    // Create Test Endpoint
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Endpoint Success!!");
    }
 }
