package com.senla.tripstorage.controller;

import com.senla.tripstorage.service.EventTypeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1.0/event_type")
public class EventTypeController {
    private final EventTypeService eventTypeService;

    public EventTypeController(EventTypeService eventTypeService) {
        this.eventTypeService = eventTypeService;
    }

    @DeleteMapping("{eventTypeUuid}")
    public void deleteEventTypeByUuid(@PathVariable String eventTypeUuid) {
        eventTypeService.deleteByUuid(eventTypeUuid);
    }
}
