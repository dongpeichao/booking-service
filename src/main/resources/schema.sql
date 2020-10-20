CREATE TABLE bookingOrder (
    id SERIAL PRIMARY KEY,
    type VARCHAR(255),
    status VARCHAR(255),
    content VARCHAR(255),
    price INT,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP
);
