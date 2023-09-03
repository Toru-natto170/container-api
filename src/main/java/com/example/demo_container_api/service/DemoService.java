package com.example.demo_container_api.service;

import com.example.demo_container_api.dto.DemoResponse;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class DemoService {

    public DemoResponse makeHello(String name){
        LocalTime time = LocalTime.now();
        DemoResponse response = new DemoResponse();
        if (time.isBefore(LocalTime.of(10,59,59))) {
            response.setMessage("Good Morning, " + name);
        }else if (time.isAfter(LocalTime.of(11,0,0)) && time.isBefore(LocalTime.of(17,59,59))){
            response.setMessage("Good Afternoon, " + name);
        } else {
            response.setMessage("Good Evening, " + name);
        }
        return response;
    }
}
