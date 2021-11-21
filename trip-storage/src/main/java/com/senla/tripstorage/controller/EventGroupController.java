package com.senla.tripstorage.controller;

import com.senla.tripstorage.model.dto.EventGroupDTO;
import com.senla.tripstorage.model.dto.EventTypeDTO;
import com.senla.tripstorage.service.EventGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("v1.0/event_group")
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
    public EventGroupDTO getEventGroupByUuid(@PathVariable String eventGroupUuid) {
        return eventGroupService.findByUuid(eventGroupUuid);
    }

    @GetMapping("{eventGroupUuid}/event_type")
    public Set<EventTypeDTO> getAllEventTypeForGroup(@PathVariable String eventGroupUuid) {
        return null;
    }

    @PostMapping
    public EventGroupDTO saveEventGroup(@RequestBody EventGroupDTO eventGroupDTO) {
        return eventGroupService.save(eventGroupDTO);
    }

    @PostMapping("{eventGroupUuid}/event_type")
    public EventGroupDTO saveEventTypeForGroup(@PathVariable String eventGroupUuid, @RequestBody EventTypeDTO eventTypeDTO) {
        return eventGroupService.saveEventTypeForGroup(eventGroupUuid, eventTypeDTO);
    }

    @DeleteMapping("{eventGroupUuid}")
    public void deleteEventGroup(@PathVariable String eventGroupUuid) {
        eventGroupService.deleteByUuid(eventGroupUuid);
    }
}
