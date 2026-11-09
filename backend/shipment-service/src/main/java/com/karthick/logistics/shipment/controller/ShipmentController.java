package com.karthick.logistics.shipment.controller;

import com.karthick.logistics.shipment.dto.BookShipmentRequest;
import com.karthick.logistics.shipment.dto.BookShipmentResponse;
import com.karthick.logistics.shipment.dto.ShipmentDetailsResponse;
import com.karthick.logistics.shipment.entity.Shipment;
import com.karthick.logistics.shipment.service.ShipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private static final long LOCAL_TEST_CUSTOMER_ID = 1L;

    private final ShipmentService shipmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookShipmentResponse bookShipment(
            @Valid @RequestBody BookShipmentRequest request
            ){

        Shipment shipment = shipmentService.bookShipment(request, LOCAL_TEST_CUSTOMER_ID);

        return  new BookShipmentResponse(
                shipment.getTrackingNumber(),
                shipment.getStatus()
        );
    }

    @GetMapping("/{trackingNumber}")
    public ShipmentDetailsResponse getBookShipment(
            @PathVariable("trackingNumber") String trackingNumber){

        return  shipmentService.getShipmentDetails(trackingNumber);
    }
}
