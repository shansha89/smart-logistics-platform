package com.karthick.logistics.shipment.dto;

import com.karthick.logistics.shipment.entity.ShipmentStatus;

public record BookShipmentResponse(
        String trackingNumber,
        ShipmentStatus status
) {}
