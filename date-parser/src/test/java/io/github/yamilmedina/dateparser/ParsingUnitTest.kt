package io.github.yamilmedina.dateparser

import org.junit.Test
import kotlin.time.measureTime

class ParsingUnitTest {
    @Test
    fun measureSimpleDateFormat() {
        measureTime {
            repeat(ITERATIONS) {
                INPUT.withTextSimpleDateFormat()
            }
        }.also {
            println(">> Time elapsed with SimpleDateFormat: $it")
        }
    }

    @Test
    fun measureLocalDateTime() {
        measureTime {
            repeat(ITERATIONS) {
                INPUT.withLocalDateTimeParser()
            }
        }.also {
            println(">> Time elapsed with LocalDateTime: $it")
        }
    }

    @Test
    fun measureInstant() {
        measureTime {
            repeat(ITERATIONS) {
                INPUT.withJavaInstantParser()
            }
        }.also {
            println(">> Time elapsed with Instant: $it")
        }
    }

    companion object {
        const val ITERATIONS = 500_000
        const val INPUT = "2030-11-11T07:59:10Z"
    }
}