# Busmaster API

This is the api for the busmaster project.

### Running the Postgresql image for this app
The schema and default test data are stored in schema.sql and data.sql respectively under the src/main/resources dir of this program.
To start postgres using podman, use this command: 
podman run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=buspw -d postgres

Note that the default user is 'postgres'.  The command above starts the postgres server with the default schema of 'postgres' and a password of 'buspw'.