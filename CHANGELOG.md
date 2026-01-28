# Changelog

## [0.0.2](https://github.com/CloudRader/inventarium-api/compare/v0.0.1...v0.0.2) (2026-01-28)


### 🧱 Updates & Improvements

* add and config migration with liquibase, use proper ENVs in .env ([c091bb2](https://github.com/CloudRader/inventarium-api/commit/c091bb220de75778cab7d807943e8e76bb601e6e))
* add and move configs to one folder ([5331794](https://github.com/CloudRader/inventarium-api/commit/5331794bd95fd0ad8ff89f2b0531803ced8d6aa1))
* add containers for postgres and authentik to compose.yaml ([5405750](https://github.com/CloudRader/inventarium-api/commit/5405750cc874375c67edc2540640a75e694d66a6))
* add dto and mappers between user ([5d7ea94](https://github.com/CloudRader/inventarium-api/commit/5d7ea94bd96add81435b6f044e4aec585ce58b3c))
* add user and auth logic with OpenId integration ([3dac11a](https://github.com/CloudRader/inventarium-api/commit/3dac11aebdcebacd5149d8fcf76d98381448c780))
* add user model and repository + hashEncode class ([f7c195d](https://github.com/CloudRader/inventarium-api/commit/f7c195d87bc68ac0fe05ef710134ab3f0b9e5d68))
* add validation, global, fix bugshandler for it ([9f97bbd](https://github.com/CloudRader/inventarium-api/commit/9f97bbd579b518523e740e36bc803f3a4716bd5e))
* add well-known controller ([39fc1f2](https://github.com/CloudRader/inventarium-api/commit/39fc1f2f3d9808582f53ba6926b444e7f92b5c94))
* downgrade java and gradle version (compatability issues) ([cc9bbc5](https://github.com/CloudRader/inventarium-api/commit/cc9bbc58aa72f726ae12614c6fa8067cd2d93c00))
* example note object and some other updates in structure ([da90635](https://github.com/CloudRader/inventarium-api/commit/da9063564d3d02884a8dce4cbca22e2745abf7e7))
* finish security logic, add auth controller ([b575996](https://github.com/CloudRader/inventarium-api/commit/b5759965d7800baf35a175bf39e1aac3fcd7fde6))
* init inventarium project ([1150ee3](https://github.com/CloudRader/inventarium-api/commit/1150ee306996b49ebd00a7893cb19c3182334973))
* remove note domain from each layers ([fdadd0b](https://github.com/CloudRader/inventarium-api/commit/fdadd0ba1f9c1f834b170b857ea806da8b636838))
* start impl. jwt security logic ([4614544](https://github.com/CloudRader/inventarium-api/commit/461454411d77c78b11e7316d8dc5860f372a07d0))
* update deps, compose and app config ([a7edbe1](https://github.com/CloudRader/inventarium-api/commit/a7edbe16255ec3f5559ff24ed4cb02b6cb0c78b4))
* update security config and update responding status codes ([2e1e150](https://github.com/CloudRader/inventarium-api/commit/2e1e150ffecef555796231b5cbea646cb446532f))


### 🧹 Refactors

* migrate note from mongo to postgres (domain for test purpose) ([0de1335](https://github.com/CloudRader/inventarium-api/commit/0de13359e5d4c06ca81e17221aa638fc19b80149))
* remove unused test files ([c5693e3](https://github.com/CloudRader/inventarium-api/commit/c5693e3cc86d4e26816561b8d8dabb5a5cb7150d))
