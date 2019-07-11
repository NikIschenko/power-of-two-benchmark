package by.ischenko;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
public class PowerOfTwoBenchmark {

    @Benchmark
    public void isPowerOfTwo(TestState testState, Blackhole blackhole) {
        PowerOfTwoApproach powerOfTwoApproach = testState.powerOfTwoApproach;
        IntStream.rangeClosed(testState.min, testState.max)
                .boxed()
                .parallel()
                .filter(powerOfTwoApproach::isPowerOfTwo)
                .map(Integer::toBinaryString)
                .forEach(blackhole::consume);
    }

    @State(Scope.Thread)
    public static class TestState {
        public int min = Byte.MIN_VALUE;
        public int max = Integer.MAX_VALUE;
        @Param({"CALC", "BIT", "INT_BIT_COUNT"})
        public PowerOfTwoApproach powerOfTwoApproach;
    }
}
