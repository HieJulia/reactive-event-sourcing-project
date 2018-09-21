package com.project.realtimeonlinetrackingservice.controller;


import com.project.realtimeonlinetrackingservice.model.TrackingData;
import com.project.realtimeonlinetrackingservice.service.TrackingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class TrackingDataController {
    @Autowired
    TrackingDataService service;

    // text event stream value
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/trackingdata")
    @ResponseBody
    Flux<TrackingData> getAll(){
        return Flux.from(service.getALl());

    }


    // json
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/trackingdata/{id}")
    @ResponseBody
    Mono<TrackingData> getDetail(@PathVariable long id){
        return service.getTrackingDataDetail(id);

    }

    @GetMapping("/")
    Mono<String> home() {
        return Mono.just("tracking data ... homne");
    }
}