# Changelog

## [0.0.2](https://github.com/CloudRader/inventarium-api/compare/v0.0.1...v0.0.2) (2026-02-10)


### 🧱 Updates & Improvements

* add and config migration with liquibase, use proper ENVs in .env ([c091bb2](https://github.com/CloudRader/inventarium-api/commit/c091bb220de75778cab7d807943e8e76bb601e6e))
* add and move configs to one folder ([5331794](https://github.com/CloudRader/inventarium-api/commit/5331794bd95fd0ad8ff89f2b0531803ced8d6aa1))
* add annotations for swagger documentation ([958db6e](https://github.com/CloudRader/inventarium-api/commit/958db6e3bcf6c5c2b65e584d8f4f244b90426c1b))
* add config for platform admin with BasicAuth setup ([786f40d](https://github.com/CloudRader/inventarium-api/commit/786f40d57cd6973dc0d6c5544e716670af149eb9))
* add containers for postgres and authentik to compose.yaml ([5405750](https://github.com/CloudRader/inventarium-api/commit/5405750cc874375c67edc2540640a75e694d66a6))
* add dependencycheck lib ([a5b9eb3](https://github.com/CloudRader/inventarium-api/commit/a5b9eb3b05db783aab8aa2e02d519d5d41187145))
* add Dockerfile and add container to compose.yaml ([5efaf9b](https://github.com/CloudRader/inventarium-api/commit/5efaf9b504337d3e58afd42f6435e02c6a84c310))
* add dto and mappers between user ([5d7ea94](https://github.com/CloudRader/inventarium-api/commit/5d7ea94bd96add81435b6f044e4aec585ce58b3c))
* add encryption service ([3a30553](https://github.com/CloudRader/inventarium-api/commit/3a305535dc969dbd534f86abd659460ac6d0f03f))
* add exceptions ([76ecd32](https://github.com/CloudRader/inventarium-api/commit/76ecd325ba226f80d3a745e25e0790a9494ff764))
* add identity provider to all layers, fix migration with that ([24ade45](https://github.com/CloudRader/inventarium-api/commit/24ade45fdfff05b35e59f3c462ab608c2ac8be8c))
* add Logging component and move to one place ([5b9c249](https://github.com/CloudRader/inventarium-api/commit/5b9c2495a256d003e3cb335a3a0ecb4e0664c26a))
* add logs config and update some configurations ([b203085](https://github.com/CloudRader/inventarium-api/commit/b20308584a5ed18d3698759f4ef40d5a3f30b8de))
* add migration create IdPs and tenants tables ([f5c3ded](https://github.com/CloudRader/inventarium-api/commit/f5c3dedbfa4fdcc176a0c5b7e2eb035d7c6ae4f7))
* add migration for create table and instance platform_admins ([cc5f6c9](https://github.com/CloudRader/inventarium-api/commit/cc5f6c963182241474558596e597494f483770a4))
* add platform admin model ([17f739a](https://github.com/CloudRader/inventarium-api/commit/17f739a45128751056506de6ce4c6d629b297cc3))
* add Tenant controller, service, repository, DTOs, conflict exception ([6844f57](https://github.com/CloudRader/inventarium-api/commit/6844f57d4f4cb40a0437b9cb313eebcc45dc3a46))
* add user and auth logic with OpenId integration ([3dac11a](https://github.com/CloudRader/inventarium-api/commit/3dac11aebdcebacd5149d8fcf76d98381448c780))
* add user model and repository + hashEncode class ([f7c195d](https://github.com/CloudRader/inventarium-api/commit/f7c195d87bc68ac0fe05ef710134ab3f0b9e5d68))
* add validation, global, fix bugshandler for it ([9f97bbd](https://github.com/CloudRader/inventarium-api/commit/9f97bbd579b518523e740e36bc803f3a4716bd5e))
* add well-known controller ([39fc1f2](https://github.com/CloudRader/inventarium-api/commit/39fc1f2f3d9808582f53ba6926b444e7f92b5c94))
* change fetch userInfo with IdP from db, some small fixes ([2a57f3c](https://github.com/CloudRader/inventarium-api/commit/2a57f3cee20874f53779566dafedc12884d0ee69))
* delete test OpenIdConfiguration ([6430574](https://github.com/CloudRader/inventarium-api/commit/6430574c4e3cd9495f073b6be2d5dcbde7191620))
* downgrade java and gradle version (compatability issues) ([cc9bbc5](https://github.com/CloudRader/inventarium-api/commit/cc9bbc58aa72f726ae12614c6fa8067cd2d93c00))
* example note object and some other updates in structure ([da90635](https://github.com/CloudRader/inventarium-api/commit/da9063564d3d02884a8dce4cbca22e2745abf7e7))
* finish security logic, add auth controller ([b575996](https://github.com/CloudRader/inventarium-api/commit/b5759965d7800baf35a175bf39e1aac3fcd7fde6))
* init inventarium project ([1150ee3](https://github.com/CloudRader/inventarium-api/commit/1150ee306996b49ebd00a7893cb19c3182334973))
* remove note domain from each layers ([fdadd0b](https://github.com/CloudRader/inventarium-api/commit/fdadd0ba1f9c1f834b170b857ea806da8b636838))
* solve detect warnings ([eb17644](https://github.com/CloudRader/inventarium-api/commit/eb176441e0243b7571aa53c51140de0b57680351))
* start impl. jwt security logic ([4614544](https://github.com/CloudRader/inventarium-api/commit/461454411d77c78b11e7316d8dc5860f372a07d0))
* update and structure handling exceptions ([8e79a7b](https://github.com/CloudRader/inventarium-api/commit/8e79a7b8da62632656359a24c3ce5289a0afee6f))
* update deps, compose and app config ([a7edbe1](https://github.com/CloudRader/inventarium-api/commit/a7edbe16255ec3f5559ff24ed4cb02b6cb0c78b4))
* update Identity Provider Client, add getIssuerInfo logic ([d5833f4](https://github.com/CloudRader/inventarium-api/commit/d5833f484068fa5093a9911e299158e8948f8ab5))
* update java, gradle and kotlin versions. Add detect linter ([235a141](https://github.com/CloudRader/inventarium-api/commit/235a1410e9427ef49527d5a1f556c8251f76255d))
* update responses annotation updated tenant in all layers, fix some bugs ([51d27c8](https://github.com/CloudRader/inventarium-api/commit/51d27c80bd96ddd4c7885e4ccbc81b1758e72776))
* update security config and update responding status codes ([2e1e150](https://github.com/CloudRader/inventarium-api/commit/2e1e150ffecef555796231b5cbea646cb446532f))


### 🧹 Refactors

* **dto:** user and tenant dto (separate folders) ([f3a6fb3](https://github.com/CloudRader/inventarium-api/commit/f3a6fb309add8dcb2642fe818b6cb298f2fa190c))
* **exceptions:** unify with AppException ([bf32c38](https://github.com/CloudRader/inventarium-api/commit/bf32c38a3185e9aacb982a8df74ba215af4140e4))
* migrate note from mongo to postgres (domain for test purpose) ([0de1335](https://github.com/CloudRader/inventarium-api/commit/0de13359e5d4c06ca81e17221aa638fc19b80149))
* remove unused test files ([c5693e3](https://github.com/CloudRader/inventarium-api/commit/c5693e3cc86d4e26816561b8d8dabb5a5cb7150d))
* user service and controller with annotations and exceptions, update app config ([a4065d4](https://github.com/CloudRader/inventarium-api/commit/a4065d46dc7cc1e639466beece1c14315602d537))
