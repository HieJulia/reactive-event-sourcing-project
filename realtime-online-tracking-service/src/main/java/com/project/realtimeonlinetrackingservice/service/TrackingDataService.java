package com.project.realtimeonlinetrackingservice.service;


import com.project.realtimeonlinetrackingservice.model.TrackingData;
import com.project.realtimeonlinetrackingservice.repository.TrackingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingDataService {

    @Value("${opensky.base_url}")
    private final String baseUrl;

    @Autowired
    private TrackingDataRepository trackingDataRepository;

    @Bean
    WebClient client(){
        return WebClient.create(baseURL);
    }

    /**
     * Get all TrackingData
     *
     */

    public Flux<TrackingData> getALl(){
        return client().get().uri(baseUrl).accept(MediaType.APPLICATION_JSON)
                .exchange().flatMap(cr -> cr.bodyToMono(TrackingData.class));
    }


    /**
     * Get one Tracking Data details
     */
    public Mono<TrackingData> getTrackingDataDetail(long id){
        return trackingDataRepository.findById(id);
    }


}
