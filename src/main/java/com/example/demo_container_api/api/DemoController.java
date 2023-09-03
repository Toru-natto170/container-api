package com.example.demo_container_api.api;

import com.example.demo_container_api.dto.DemoResponse;
import com.example.demo_container_api.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    public ResponseEntity<DemoResponse> getHello(@RequestParam String name) {
        return ResponseEntity.ok(demoService.makeHello(name));
    }
}
