package com.senla.tripstorage.controller;

import com.senla.tripstorage.model.dto.EventDTO;
import com.senla.tripstorage.model.dto.TripDTO;
import com.senla.tripstorage.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("v1.0/trip")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public Set<TripDTO> getAllTrips() {
        return tripService.findAll();
    }

    @GetMapping("{tripUuid}")
    public TripDTO getTripByUuid(@PathVariable String tripUuid) {
        return tripService.findByUuid(tripUuid);
    }

    @PostMapping
    public TripDTO saveTrip(@RequestBody TripDTO tripDTO) {
        return tripService.save(tripDTO);
    }

    @DeleteMapping("{tripUuid}")
    public void deleteTripByUuid(@PathVariable String tripUuid) {
        tripService.deleteByUuid(tripUuid);
    }

    @PostMapping("{tripUuid}")
    public TripDTO addEventToTrip(@PathVariable String tripUuid, @RequestBody EventDTO eventDTO) {
        return tripService.addEventToTrip(tripUuid, eventDTO);
    }

    @DeleteMapping("{tripUuid}/event/{uuidEvent}")
    public TripDTO deleteEventFromTrip(@PathVariable String tripUuid, @PathVariable String eventUuid)
    {
        return deleteEventFromTrip(tripUuid, eventUuid);
    }
}
