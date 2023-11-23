CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE hotel (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100),
    information TEXT
);