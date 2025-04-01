package com.example.blockbuster_api.controllers;

import com.example.blockbuster_api.models.ApiInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @GetMapping
    public ResponseEntity<String> getStatus(){
        return ResponseEntity.ok("Blockbuster API is Running!");
    }

    @GetMapping("/info")
    public ResponseEntity<ApiInfo> getInfo(){
        return ResponseEntity.ok(new ApiInfo("blockbuster-api", "v1.0.0"));
    }
}
