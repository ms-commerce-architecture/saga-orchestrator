CREATE TABLE  saga_instances(
    saga_id VARCHAR(30) NOT NULL PRIMARY KEY ,
    order_number VARCHAR(100) NOT NULL ,
    saga_status VARCHAR(40) NOT NULL ,
    current_step VARCHAR(100),
    request_payload  JSON NULL,
    failure_reason VARCHAR(1000) Null,
    version BIGINT NOT NULL  DEFAULT  0,
    created_at TIMESTAMP(6) NOT NULL ,
    updated_at TIMESTAMP(6) NOT NULL,

    CONSTRAINT  uk_saga_order_number UNIQUE (order_number)
);


CREATE TABLE saga_outbox(
    id VARCHAR(30) NOT NULL  PRIMARY KEY ,
    aggregatetype VARCHAR(255) NOT NULL ,
    aggregateid VARCHAR(255) NOT NULL ,
    type VARCHAR(255) NOT NULL ,
    payload JSON NOT NULL ,
    created_at TIMESTAMP(6) NOT NULL  DEFAULT CURRENT_TIMESTAMP(6),
    INDEX idx_saga_outbox_aggregate(aggregatetype,aggregateid,created_at)
);

CREATE TABLE saga_processed_messages(
    message_id VARCHAR(100) NOT NULL PRIMARY KEY ,
    processed_at TIMESTAMP(6) NOT NULL
);