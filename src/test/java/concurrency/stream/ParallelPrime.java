// package concurrency.stream;

// import static java.util.stream.LongStream.iterate;
// import static java.util.stream.LongStream.rangeClosed;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.nio.file.StandardOpenOption;
// import java.util.List;
// import java.util.stream.Collectors;

// import com.chuck.common.utils.Timer;

// import lombok.extern.slf4j.Slf4j;

// /**
//  * @author Chuck
//  * @since 4/18/2021
//  * @version 0.0.1
//  *
//  **/
// @Slf4j
// public class ParallelPrime {

//     static int count = 100_000;

//     static boolean isPrime(long n) {
//         return rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % i == 0);
//     }

//     public static void main(String[] args) throws IOException {
//         Timer time = new Timer();
//         List<String> primes = iterate(2, i -> i + 1).
//         // parallel().
//                 filter(ParallelPrime::isPrime).limit(count).mapToObj(Long::toString).collect(Collectors.toList());

//         log.info("Takes Time:{}", time.duration());
//         Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
//     }
// }
