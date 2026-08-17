# Core Java for Full-Stack Developers

A runnable Java 17 repository covering the course concepts through an industrial e-commerce and fintech context. The project is intentionally framework-free so the Java fundamentals remain visible before moving to Spring Boot.

## What is covered

| Area | Repository implementation |
|---|---|
| Precision and domain modeling | `BigDecimal`, immutable `record` types, constructor validation |
| OOP | Encapsulation, abstract payment contract, polymorphic payment routing |
| Abstraction | Repository interface with an in-memory implementation |
| Collections | `ArrayList`, `HashMap`, `TreeMap`, `ArrayDeque`, `LinkedHashMap`, `ConcurrentHashMap` |
| Exceptions | Checked gateway timeout and unchecked business-rule exceptions |
| Modern Java | Lambdas, `Predicate`, streams, grouping, sorting, `Optional`, method references |
| Date/time and I/O | `LocalDateTime`, `ZonedDateTime`, NIO.2 CSV import/export |
| Concurrency | `synchronized`, `BlockingQueue`, `ExecutorService`, `CompletableFuture` |
| Capstone | Concurrent order processing with inventory protection and revenue reporting |

## Run it

Requires Java 17+ and Maven 3.9+.

```bash
mvn test
mvn -q exec:java -Dexec.mainClass=com.example.corejava.examples.CourseDemo
mvn -q exec:java -Dexec.mainClass=com.example.corejava.capstone.CapstoneDemo
```

The demos are deliberately small enough to read in one sitting, but they use the same boundaries found in production services: domain objects, repositories, services, failures, concurrency, and reporting.

## Project map

```text
src/main/java/com/example/corejava/
├── capstone/      Concurrent order-processing engine
├── domain/        Product, order, payment, customer, and value objects
├── exceptions/    Business and infrastructure failures
├── examples/      One runnable demo per concept family
├── repository/    Repository abstraction and in-memory implementation
└── service/       Payment routing, pricing, streams, dates, and CSV services
```

## Suggested learning path

Start with `CourseDemo`, then inspect the `domain` package, followed by `service` and `repository`. Run `CapstoneDemo` last. The tests under `src/test` show how to verify money calculations, validation, repository behavior, stream analytics, and concurrent inventory updates.

## Educational note

The code is designed for learning. In a production system, add stronger input parsing, persistence, observability, transaction boundaries, idempotency, and integration tests before using the patterns with real payments or inventory.
