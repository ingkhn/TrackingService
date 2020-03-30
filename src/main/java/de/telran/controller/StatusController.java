package de.telran.controller;

import de.telran.dto.StatusDTO;
import de.telran.model.entity.Status;
import de.telran.service.StatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatusController {
    private StatusService statusService;
    private ModelMapper modelMapper;

    @Autowired
    public StatusController(StatusService statusService, ModelMapper modelMapper) {
        this.statusService = statusService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/api/shipments/{shipment_id}/statuses")
    public StatusDTO createStatus(@RequestBody StatusDTO status, @PathVariable Long shipment_id) {
        Status statusEntity = modelMapper.map(status, Status.class);
        statusEntity.setShipmentId(shipment_id);
        return modelMapper.map(statusService.createStatus(statusEntity), StatusDTO.class);
    }
}
