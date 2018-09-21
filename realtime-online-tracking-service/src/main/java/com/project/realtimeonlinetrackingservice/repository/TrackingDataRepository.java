package com.project.realtimeonlinetrackingservice.repository;



import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TrackingDataRepository extends ReactiveCrudRepository<TrackingData, Long> {

    Mono<TrackingData> findById(long id );
}