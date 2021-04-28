// package concurrency.stream;

// import java.util.Arrays;

// import lombok.extern.slf4j.Slf4j;

// /**
//  * @author Chuck
//  * @since 4/18/2021
//  * @version 0.0.1
//  *
//  **/
// @Slf4j
// public class Summing2 {
//     static long basicSum(long[] la) {
//         long sum = 0;
//         int size = la.length;
//         for (int i = 0; i < size; i++) {
//             sum += la[i];
//         }
//         return sum;
//     }

//     private static final int SZ = 20_000_000;
//     private static final long CHECK = (long) SZ * ((long) SZ + 1) / 2;

//     public static void main(String[] args) {
//         log.info("{}", CHECK);
//         long[] la = new long[SZ + 1];
//         Arrays.parallelSetAll(la, i -> i);

//         Summing.timeTest("Array Stream Sum", CHECK, () -> Arrays.stream(la).sum());
//         Summing.timeTest("Parallel", CHECK, () -> Arrays.stream(la).parallel().sum());
//         Summing.timeTest("Basic Sum", CHECK, () -> basicSum(la));
//         Summing.timeTest("ParallelPrefix", CHECK, () -> {
//             Arrays.parallelPrefix(la, Long::sum);
//             return la[la.length - 1];
//         });
//     }
// }
