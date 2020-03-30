package de.telran.service;

import de.telran.model.entity.Customer;
import de.telran.model.entity.Shipment;

public interface ShipmentService {
    Shipment createShipment(Shipment shipment);
    Shipment getShipmentById(Long shipmentId);
}
