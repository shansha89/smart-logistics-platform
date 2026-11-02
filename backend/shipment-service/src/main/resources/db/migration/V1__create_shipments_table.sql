CREATE TABLE shipments(
    id BIGINT not null auto_increment,
    tracking_number varchar(50) not null,
    customer_id BIGINT NOT NULL,

    sender_name varchar(100) NOT NULL,
    sender_phone varchar(20) NOT NULL,
    pickup_address VARCHAR(255) NOT NULL,
    pickup_city VARCHAR(100) NOT NULL,
    pickup_state VARCHAR(100) NOT NULL,
    pickup_postal_code VARCHAR(10) NOT NULL,

    recipient_name VARCHAR(100) NOT NULL,
    recipient_phone VARCHAR(20) NOT NULL,
    delivery_address VARCHAR(255) NOT NULL,
    delivery_city VARCHAR(100) NOT NULL,
    delivery_state VARCHAR(100) NOT NULL,
    delivery_postal_code VARCHAR(10) NOT NULL,

     parcel_description VARCHAR(500) NOT NULL,
     weight_kg DECIMAL(10, 3) NOT NULL,
     status VARCHAR(30) NOT NULL,
     assigned_agent_id BIGINT NULL,

      created_at DATETIME(6) NOT NULL,
      updated_at DATETIME(6) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT uk_shipments_tracking_number UNIQUE (tracking_number),
    CONSTRAINT chk_shipments_weight CHECK (weight_kg > 0),
    INDEX idx_shipments_customer (customer_id),
    INDEX idx_shipments_agent (assigned_agent_id)

)