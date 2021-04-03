# BusBook API

This is the api for the busmaster project.

### Running the Postgresql image for this app
The schema and default test data are stored in schema.sql and data.sql respectively under the src/main/resources dir of this program.
To start postgres using podman, use this command: 
podman run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=buspw -d postgres

Note that the default user is 'postgres'.  The command above starts the postgres server with the default schema of 'postgres' and a password of 'buspw' of port 5432.

There is no need to specify the database or schema in any sql statements, just access the database object name directly, e.g., tablename "riders".  (This is assuming that you are running against a containerized instance of postgres.)

Also note that the first time you run against an empty postgres instance, you will need to include this line in your application.properties file:
spring.datasource.initialization-mode=always

This tells spring boot to re-initialize the database schema and data with what is in the schema.sql and data.sql files upon starting the app.  If you wish to maintain the same schema, you will need to remove this line after you have performed your initial data object creation and inserts.

More documentation to come on how to create a production database environment...

### Local project setup
You will need eclipse EE to edit this project.  Once you have cloned the project to your local workspace, you will need to import it as a Maven project.  When you first import the project, you may encounter some Maven POM errors.  If so, right-click the project, and run Maven -> Update Project.  Once this has completed, the project should be recognized, and display as expected without errors.
