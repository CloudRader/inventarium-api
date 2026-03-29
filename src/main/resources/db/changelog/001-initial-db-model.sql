CREATE TABLE tenants
(
    id         UUID PRIMARY KEY      DEFAULT gen_random_uuid(),

    name       VARCHAR(255) NOT NULL,
    alias      VARCHAR(50)  NOT NULL UNIQUE,

    created_at TIMESTAMPTZ  NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ
);

CREATE TABLE users
(
    id          VARCHAR(100) PRIMARY KEY,
    tenant_id   UUID         NOT NULL REFERENCES tenants (id),
    username    VARCHAR(32)  NOT NULL UNIQUE,
    first_name  VARCHAR(32)  NOT NULL,
    second_name VARCHAR(32)  NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    created_at  TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE TABLE audit_logs
(
    id          UUID PRIMARY KEY     DEFAULT gen_random_uuid(),

    tenant_id   UUID        NOT NULL REFERENCES tenants (id),
    user_id     VARCHAR(100) REFERENCES users (id),

    action      VARCHAR(50) NOT NULL,
    entity_type VARCHAR(50) NOT NULL,
    entity_id   UUID,
    timestamp   TIMESTAMPTZ NOT NULL DEFAULT now(),
    metadata    JSONB
);

CREATE INDEX idx_audit_tenant_time
    ON audit_logs (tenant_id, timestamp DESC);

CREATE INDEX idx_audit_entity
    ON audit_logs (entity_type, entity_id);

CREATE INDEX idx_audit_user
    ON audit_logs (user_id);

CREATE TABLE identity_providers
(
    id                     UUID PRIMARY KEY      DEFAULT gen_random_uuid(),

    tenant_id              UUID         NOT NULL REFERENCES tenants (id) ON DELETE CASCADE,

    type                   VARCHAR(50)  NOT NULL,
    name                   VARCHAR(100) NOT NULL,
    alias                  VARCHAR(50)  NOT NULL UNIQUE,

    client_id              VARCHAR(64)  NOT NULL,
    client_secret_hashed   VARCHAR(255) NOT NULL,

    configuration_endpoint VARCHAR(255) NOT NULL,

    issuer                 VARCHAR(255) NOT NULL,
    authorization_endpoint VARCHAR(100) NOT NULL,
    token_endpoint         VARCHAR(100) NOT NULL,
    userinfo_endpoint      VARCHAR(255) NOT NULL,
    end_session_endpoint   VARCHAR(255) NOT NULL,
    jwks_uri               VARCHAR(255) NOT NULL,
    scopes_supported       VARCHAR(255) NOT NULL,

    enabled                BOOLEAN      NOT NULL DEFAULT true,
    primary_provider       BOOLEAN      NOT NULL DEFAULT false
);