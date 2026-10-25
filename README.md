# Smart Logistics & Delivery Management Platform
  A portfolio capstone project using React and Spring Boot microservices.

## Problem Statement
  Manual shipment booking, agent assignment, and scattered delivery updates
  make logistics operations difficult to manage.
  
  This application centralises these activities and provides customers
  with a shipment tracking history.

## User Roles

### Customer
- Book a shipment.
- View their own shipments.
- View shipment details and tracking history.

### Operations Admin
- View all shipments.
- Assign delivery agents.
- Monitor shipment progress.

### Delivery Agent
- View assigned shipments.
- Update the status of assigned shipments.

The recipient receives the parcel and does not need an account
in the first version. The customer and recipient may be the same person.

## First-Version Scope

- Registration and login.
- Role-based access control.
- Shipment booking.
- Unique tracking number generation.
- Delivery agent assignment.
- Shipment status updates.
- Tracking history.

## Shipment Lifecycle

BOOKED → ASSIGNED → PICKED_UP → IN_TRANSIT → OUT_FOR_DELIVERY → DELIVERED

## Business Rules

1. Every shipment has a unique tracking number.
2. Customers can access only their own shipments.
3. Only operations admins can assign delivery agents.
4. Agents can update only shipments assigned to them.
5. Status updates must follow the defined lifecycle without skipping steps.
6. Every status change records the timestamp and the user making the change.
7. DELIVERED is the final status; further status changes are rejected.

## Initial Assumptions

- Each shipment contains one parcel.
- One assigned agent manages the shipment through delivery.
- Tracking shows status history.

## Future Enhancements

- Live GPS tracking.
- Payments.
- Route optimisation.
- Multiple hubs and agent handovers.

## Planned Technology Stack

- Frontend: React and Bootstrap.
- Backend: Java 21 and Spring Boot microservices.
- Database: MySQL.
- Security: Spring Security with JWT.
- Database migrations: Flyway.
- Testing: JUnit and Mockito.
- Later phases: Kafka, Docker, CI/CD, AWS, and Kubernetes.

## Project Status

Day 1: Business requirements and initial scope defined.
