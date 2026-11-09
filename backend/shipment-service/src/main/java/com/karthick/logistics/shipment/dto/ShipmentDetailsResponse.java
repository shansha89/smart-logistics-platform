package com.karthick.logistics.shipment.dto;

import com.karthick.logistics.shipment.entity.ShipmentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ShipmentDetailsResponse(

        String trackingNumber,
        ShipmentStatus status,

        String senderName,
        String senderPhone,
        String pickupAddress,
        String pickupCity,
        String pickupState,
        String pickupPostalCode,

        String recipientName,
        String recipientPhone,
        String deliveryAddress,
        String deliveryCity,
        String deliveryState,
        String deliveryPostalCode,

        String parcelDescription,
        BigDecimal weightKg,
        Long assignedAgentId,
        LocalDateTime createdAt


) {}
