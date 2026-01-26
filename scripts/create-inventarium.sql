-- Create user
CREATE USER inventarium WITH PASSWORD '${INVENTARIUM_PG_PASS}';

-- Create database
CREATE DATABASE inventarium OWNER inventarium;

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE inventarium TO inventarium;