// package java8;

// import static java.util.stream.Collectors.toList;

// import java.util.Arrays;
// import java.util.Comparator;
// import java.util.List;

// import lombok.AllArgsConstructor;
// import lombok.Data;

// /**
// * @author Chuck
// * @since 4/8/2021
// * @version 0.0.1
// *
// **/
// public class StreamSample {
// public static void main(String[] args) {
// List<Integer> arr1 = Arrays.asList(1, 2, 3);
// List<Integer> arr2 = Arrays.asList(3, 4);

// // 返回{(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)}
// List<int[]> result = arr1.stream().flatMap(i -> arr2.stream().map(j -> new
// int[] { i, j })).collect(toList());
// // result.stream().forEach(e -> System.out.println(Arrays.deepToString(e)));

// Trader r = new Trader("Raoul", "Cambridge");
// Trader mario = new Trader("Mario", "Milan");
// Trader alan = new Trader("Alan", "Cambridge");
// Trader brian = new Trader("Brian", "Cambridge");
// List<Transaction> ts = Arrays.asList(new Transaction(brian, 2011, 300), new
// Transaction(r, 2012, 1000),
// new Transaction(r, 2011, 400), new Transaction(mario, 2012, 710), new
// Transaction(mario, 2012, 700),
// new Transaction(alan, 2012, 950));
// // 2011 按交易额从低到高排序
// ts.stream().filter(t -> 2011 ==
// t.getYear()).sorted(Comparator.comparing(Transaction::getValue))
// .collect(toList()).stream().forEach(System.out::println);
// // 不同城市
// ts.stream().map(t ->
// t.getTrader().getCity()).distinct().collect(toList()).stream()
// .forEach(System.out::println);
// // Cambridge,按名称排序
// ts.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity()))
// .sorted((a, b) ->
// a.getTrader().getName().compareTo(b.getTrader().getName())).collect(toList()).stream()
// .forEach(System.out::println);
// // 所有姓名，按字母排序
// ts.stream().map(t ->
// t.getTrader().getName()).distinct().sorted().collect(toList()).stream()
// .forEach(System.out::println);
// // 是否有在米兰工作的教育员
// System.out.println(ts.stream().anyMatch(t ->
// "Milan".equals(t.getTrader().getCity())));

// // 生活在剑桥的交易员的所有交易额
// ts.stream().filter(t ->
// "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue)
// .forEach(System.out::println);
// // 所有交易中交易额最高
// System.out.println(ts.stream().map(Transaction::getValue).reduce(0,
// Integer::max));
// // 所有交易额最低
// System.out.println(ts.stream().map(Transaction::getValue).reduce(Integer.MAX_VALUE,
// Integer::min));
// ts.stream().min(Comparator.comparing(Transaction::getValue));
// //

// }
// }

// @Data
// @AllArgsConstructor
// class Trader {
// private final String name;
// private final String city;
// }

// @Data
// @AllArgsConstructor
// class Transaction {
// private final Trader trader;
// private final int year;
// private final int value;
// }