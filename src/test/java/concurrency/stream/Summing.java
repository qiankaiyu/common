// package concurrency.stream;

// import java.util.function.LongSupplier;
// import java.util.stream.LongStream;

// import com.chuck.common.utils.Timer;

// import lombok.extern.slf4j.Slf4j;

// /**
// * @author Chuck
// * @since 4/18/2021
// * @version 0.0.1
// *
// **/
// @Slf4j
// public class Summing {

// static void timeTest(String id, long checkVal, LongSupplier operation) {
// log.info("{}:", id);
// Timer time = new Timer();
// long val = operation.getAsLong();
// if (checkVal == val) {
// log.info("takes:{}", time.duration());
// } else {
// log.info("result:{} checkValue:{}", val, checkVal);
// }
// }

// private static final int SZ = 100_000_000;
// private static final long CHECK = (long) SZ * ((long) SZ + 1) / 2;

// public static void main(String[] args) {
// log.info("{}", CHECK);
// timeTest("Sum Stream", CHECK, () -> LongStream.rangeClosed(0, SZ).sum());
// timeTest("Sum Stream Parallel", CHECK, () -> LongStream.rangeClosed(0,
// SZ).parallel().sum());
// // 如果使用迭代方式，由于前后数据相关，不要使用并行流
// timeTest("Sum Iterated", CHECK, () -> LongStream.iterate(0, i -> i +
// 1).limit(SZ + 1).sum());
// }
// }
