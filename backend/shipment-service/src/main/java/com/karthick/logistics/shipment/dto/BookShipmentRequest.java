package com.karthick.logistics.shipment.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record BookShipmentRequest(

        @NotBlank @Size(max = 255)
        String senderName,

        @NotBlank @Size(max = 100)
        String senderPhone,

        @NotBlank @Size(max = 100)
        String pickupAddress,

        @NotBlank @Size(max = 100)
        String pickupCity,

        @NotBlank @Size(max = 100)
        String pickupState,

        @NotBlank @Size(max = 10)
        String pickupPostalCode,

        @NotBlank @Size(max = 100)
        String recipientName,

        @NotBlank @Size(max = 20)
        String recipientPhone,

        @NotBlank @Size(max = 255)
        String deliveryAddress,

        @NotBlank @Size(max = 100)
        String deliveryCity,

        @NotBlank @Size(max = 100)
        String deliveryState,

        @NotBlank @Size(max = 10)
        String deliveryPostalCode,

        @NotBlank @Size(max = 500)
        String parcelDescription,

        @NotNull
        @DecimalMin(value = "0", inclusive = false,
                message = "Weight must be greater than 0 kg")
        @Digits(integer = 7, fraction = 3,
                message = "Weight must have at most 7 whole digits and 3 decimal places")
        BigDecimal weightKg

) {}
