# Date and Time parsing in Android

Benchmark project for date and time parsing in Android.
Used to compare different libraries and methods for parsing date and time strings.

- SimpleDateFormat
- LocalDateTime
- Instant

```mermaid
graph 
    A[app] --> B[date-parser lib]
    C[benchmark] --> B
```

## Results

585,845,375
1,199,443,376
365,684,542

## Naive benchmarks - using unit tests

| Library          | Time (ms)  |
|------------------|------------|
| SimpleDateFormat | 242.578041 |
| LocalDateTime    | 200.570792 |
| Instant          | 361.839208 |

## Benchmarks - using Microbenchmark library

| Library          | Time (ns)     |
|------------------|---------------|
| SimpleDateFormat | 1,199,443,376 |
| LocalDateTime    | 365,684,542   |
| Instant          | 585,845,375   |
