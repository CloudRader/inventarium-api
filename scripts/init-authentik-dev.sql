-- Create user
CREATE USER authentik WITH PASSWORD 'authentik';

-- Create database
CREATE DATABASE authentik OWNER authentik;

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE authentik TO authentik;