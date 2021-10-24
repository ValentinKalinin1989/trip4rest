package com.senla.tripstorage.controller;

import com.senla.tripstorage.model.dto.EventGroupDTO;
import com.senla.tripstorage.service.impl.EventGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/event_group/v1.0")
public class EventGroupController {

    private final EventGroupService eventGroupService;

    public EventGroupController(EventGroupService eventGroupService) {
        this.eventGroupService = eventGroupService;
    }

    @GetMapping
    public Set<EventGroupDTO> getAllEventGroup() {
        return eventGroupService.findAll();
    }

    @GetMapping("{eventGroupUuid}")
    public EventGroupDTO getAllEventGroup(@PathVariable String eventGroupUuid) {
        return eventGroupService.findByUuid(eventGroupUuid);
    }

    @PostMapping
    public EventGroupDTO saveEventGroup(@RequestBody EventGroupDTO eventGroupDTO) {
        return eventGroupService.save(eventGroupDTO);
    }
}
