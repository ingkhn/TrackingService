package de.telran.controller;

import de.telran.dto.ShipmentDTO;
import de.telran.model.entity.Shipment;
import de.telran.service.ShipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipmentController {
    private ShipmentService shipmentService;
    private ModelMapper modelMapper;

    @Autowired
    public ShipmentController(ShipmentService shipmentService, ModelMapper modelMapper) {
        this.shipmentService = shipmentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/api/customers/{customer_id}/shipments")
    public ShipmentDTO createShipment(@RequestBody ShipmentDTO shipment, @PathVariable Long customer_id) {
        Shipment shipmentEntity = modelMapper.map(shipment, Shipment.class);
        shipmentEntity.setCustomerId(customer_id);
        return modelMapper.map(shipmentService.createShipment(shipmentEntity), ShipmentDTO.class);
    }

    @GetMapping("api/shipments/{id}")
    ShipmentDTO getShipmentById(@PathVariable long id) {
        return modelMapper.map(shipmentService.getShipmentById(id), ShipmentDTO.class);
    }
}
