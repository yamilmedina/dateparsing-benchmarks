package io.github.yamilmedina

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.yamilmedina.dateparser.withJavaInstantParser
import io.github.yamilmedina.dateparser.withKotlinInstantParser
import io.github.yamilmedina.dateparser.withLocalDateTimeParser
import io.github.yamilmedina.dateparser.withTextSimpleDateFormat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Benchmark, which will execute on an Android device.
 *
 * The body of [BenchmarkRule.measureRepeated] is measured in a loop, and Studio will
 * output the result. Modify your code to see how it affects performance.
 */
@RunWith(AndroidJUnit4::class)
class DateParsingBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun simpleDateFormatParsing() {
        benchmarkRule.measureRepeated {
            repeat(ITERATIONS) {
                INPUT.withTextSimpleDateFormat()
            }
        }
    }

    @Test
    fun dateLocalDateParsing() {
        benchmarkRule.measureRepeated {
            repeat(ITERATIONS) {
                INPUT.withLocalDateTimeParser()
            }
        }
    }

    @Test
    fun dateJavaInstantParsing() {
        benchmarkRule.measureRepeated {
            repeat(ITERATIONS) {
                INPUT.withJavaInstantParser()
            }
        }
    }

    @Test
    fun dateKotlinInstantParsing() {
        benchmarkRule.measureRepeated {
            repeat(ITERATIONS) {
                INPUT.withKotlinInstantParser()
            }
        }
    }

    companion object {
        const val ITERATIONS = 500_000
        const val INPUT = "2030-11-11T07:59:10Z"
    }
}
