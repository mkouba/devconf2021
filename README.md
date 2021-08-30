# Quarkus - From zero to your first gRPC service with Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

This is a demo application for [DevConf.US 2021 session](https://devconfus2021.sched.com/event/lke8/from-zero-to-your-first-grpc-service-with-quarkus) focused Quarkus gRPC extension.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/devconf2021-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related Guides

* https://quarkus.io/guides/grpc-getting-started
* https://quarkus.io/guides/grpc-service-implementation
* https://quarkus.io/guides/grpc-service-consumption
