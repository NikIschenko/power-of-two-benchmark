package by.ischenko;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Application {
	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(PowerOfTwoBenchmark.class.getSimpleName())
				.forks(1)
				.shouldDoGC(true)
				.build();

		new Runner(opt).run();
	}
}
