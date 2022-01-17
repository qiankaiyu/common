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
// public class Summing3 {
//     static long basicSum(Long[] la) {
//         long sum = 0;
//         int size = la.length;
//         for (int i = 0; i < size; i++) {
//             sum += la[i];
//         }
//         return sum;
//     }

//     private static final int SZ = 10_000_000;
//     private static final long CHECK = (long) SZ * ((long) SZ + 1) / 2;

//     public static void main(String[] args) {
//         log.info("{}", CHECK);
//         Long[] la = new Long[SZ + 1];
//         Arrays.parallelSetAll(la, i -> (long)i);

//         Summing.timeTest("Long Array Stream Reduce", CHECK, () -> Arrays.stream(la).reduce(0L, Long::sum));
//         Summing.timeTest("Long Basic Sum", CHECK, () -> basicSum(la));
//         Summing.timeTest("Long ParallelPrefix", CHECK, () -> {
//             Arrays.parallelPrefix(la, Long::sum);
//             return la[la.length - 1];
//         });
//     }
// }
