// package java8;

// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.function.Consumer;
// import java.util.function.Function;

// import lombok.extern.slf4j.Slf4j;

// /**
// * @author Chuck
// * @since 4/8/2021
// * @version 0.0.1
// *
// **/
// @Slf4j
// public class ProcessFile {
// public static void main(String[] args) {
// String oneLine = processFile(br -> br.readLine());
// String twoLine = processFile(br -> br.readLine() + br.readLine());

// List<String> array = Arrays.asList("Lambda", "in", "Action");

// List<Integer> lengths = map(array, s -> s.length());
// System.out.println(lengths);

// forEach(array, s -> System.out.print(" " + s));

// List<String> fitsArr = filter(array, s -> s.length() > 4);
// System.out.println(fitsArr);

// // T,T -> int
// // array.sort((a, b) -> a.compareToIgnoreCase(b));
// array.sort(String::compareToIgnoreCase);
// System.out.println(array);
// }

// /**
// * Function函数式接口应用
// *
// * @param <T>
// * @param <R>
// * @param inventory
// * @param f
// * @return
// */
// static <T, R> List<R> map(List<T> inventory, Function<T, R> f) {
// List<R> array = new ArrayList<>();
// for (T e : inventory) {
// array.add(f.apply(e));
// }
// return array;
// }

// /**
// * Consumer函数式接口
// *
// * @param <T>
// * @param inventory
// * @param c
// */
// static <T> void forEach(List<T> inventory, Consumer<T> c) {
// for (T e : inventory) {
// c.accept(e);
// }
// }

// static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
// List<T> result = new ArrayList<>();
// for (T e : inventory) {
// if (p.test(e)) {
// result.add(e);
// }
// }
// return result;
// }

// public String processFile() {
// try (BufferedReader br = new BufferedReader(new FileReader("test.json"))) {
// return br.readLine();
// } catch (Exception e) {
// log.error(e.getMessage());
// }
// return null;
// }

// public static String processFile(BufferedReaderProcessor processor) {
// try (BufferedReader reader = new BufferedReader(new FileReader("test.json")))
// {
// return processor.process(reader);
// } catch (Exception e) {
// log.error(e.getMessage());
// }
// return null;
// }

// }

// /**
// * 函数签名: Reader->String
// *
// * @author Chuck
// * @since 2021年4月8日
// * @version 0.0.1
// *
// *
// */
// @FunctionalInterface
// interface BufferedReaderProcessor {
// String process(BufferedReader reader) throws IOException;
// }