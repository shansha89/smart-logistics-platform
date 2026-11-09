package com.karthick.logistics.shipment.service;

import com.karthick.logistics.shipment.dto.BookShipmentRequest;
import com.karthick.logistics.shipment.dto.BookShipmentResponse;
import com.karthick.logistics.shipment.dto.ShipmentDetailsResponse;
import com.karthick.logistics.shipment.entity.Shipment;
import com.karthick.logistics.shipment.entity.ShipmentStatus;
import com.karthick.logistics.shipment.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public Shipment bookShipment(BookShipmentRequest request,Long customerId){
        Shipment shipment = new Shipment();

        shipment.setCustomerId(customerId);
        shipment.setTrackingNumber("SLP-" + UUID.randomUUID());
        shipment.setStatus(ShipmentStatus.BOOKED);

        shipment.setSenderName(request.senderName());
        shipment.setSenderPhone(request.senderPhone());
        shipment.setPickupAddress(request.pickupAddress());
        shipment.setPickupCity(request.pickupCity());
        shipment.setPickupState(request.pickupState());
        shipment.setPickupPostalCode(request.pickupPostalCode());

        shipment.setRecipientName(request.recipientName());
        shipment.setRecipientPhone(request.recipientPhone());
        shipment.setDeliveryAddress(request.deliveryAddress());
        shipment.setDeliveryCity(request.deliveryCity());
        shipment.setDeliveryState(request.deliveryState());
        shipment.setDeliveryPostalCode(request.deliveryPostalCode());

        shipment.setParcelDescription(request.parcelDescription());
        shipment.setWeightKg(request.weightKg());

        return shipmentRepository.save(shipment);
    }

    public ShipmentDetailsResponse getShipmentDetails(String trackingNumber){

        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Shipment not found"
                ));

        return new ShipmentDetailsResponse(
                shipment.getTrackingNumber(),
                shipment.getStatus(),
                shipment.getSenderName(),
                shipment.getSenderPhone(),
                shipment.getPickupAddress(),
                shipment.getPickupCity(),
                shipment.getPickupState(),
                shipment.getPickupPostalCode(),
                shipment.getRecipientName(),
                shipment.getRecipientPhone(),
                shipment.getDeliveryAddress(),
                shipment.getDeliveryCity(),
                shipment.getDeliveryState(),
                shipment.getDeliveryPostalCode(),
                shipment.getParcelDescription(),
                shipment.getWeightKg(),
                shipment.getAssignedAgentId(),
                shipment.getCreatedAt()
        );
    }
}
