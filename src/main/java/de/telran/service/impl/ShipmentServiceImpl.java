package de.telran.service.impl;

import de.telran.model.entity.Shipment;
import de.telran.model.entity.Status;
import de.telran.model.entity.StatusType;
import de.telran.repository.CustomerRepository;
import de.telran.repository.ShipmentRepository;
import de.telran.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private ShipmentRepository shipmentRepository;
    private StatusServiceImpl statusService;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, StatusServiceImpl statusService) {
        this.shipmentRepository = shipmentRepository;
        this.statusService = statusService;
    }

    public Shipment createShipment(Shipment shipment) {
        Shipment savedShipment = shipmentRepository.save(shipment);

        Status status = Status.builder()
                .type(StatusType.INITIAL)
                .shipmentId(savedShipment.getShipmentId())
                .build();
        statusService.createStatus(status);

        return shipmentRepository.getOne(savedShipment.getShipmentId());
    }

    public Shipment getShipmentById(Long shipmentId){
        return shipmentRepository.findById(shipmentId).orElse(null);
    }
}
