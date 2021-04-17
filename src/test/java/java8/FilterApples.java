// package java8;

// import java.util.ArrayList;
// import java.util.List;

// import lombok.AllArgsConstructor;
// import lombok.Data;

// /**
// * @author Chuck
// * @since 4/8/2021
// * @version 0.0.1
// *
// **/
// /**
// * 版本演变
// *
// * @author Chuck
// * @since 2021年4月8日
// * @version 0.0.1
// *
// *
// */
// public class FilterApples {
// /**
// * 按绿色过滤
// *
// * @param inventory
// * @return
// */
// public static List<Apple> filterGreenApples(List<Apple> inventory) {
// List<Apple> result = new ArrayList<>();
// for (Apple apple : inventory) {
// if ("green".equals(apple.getColor())) {
// result.add(apple);
// }
// }
// return result;
// }

// /**
// * 按颜色过滤，或者还可以按重量过滤，按颜色或（和）重量过滤
// *
// * （是或条件则再添加一个标志是重量还是颜色的参数，如果是和则添加一个重量参数）
// *
// * @param inventory
// * @param color
// * @return
// */
// public static List<Apple> filterApplesByColor(List<Apple> inventory, String
// color) {
// List<Apple> result = new ArrayList<>();
// for (Apple apple : inventory) {
// if (apple.getColor().equals(color)) {
// result.add(apple);
// }
// }
// return result;
// }

// /**
// * 思考：如果过滤的条件是变化的，可能我们需要将过滤条件以一种更抽象的方式参数化
// *
// *
// *
// 一种方式是为所有条件创建一个聚合体（将条件存放在该model中），实际上可能我们过滤的实体（Apple）就是这个聚合体，这种方式只是减少了参数，并没有减少内部代码
// *
// *
// *
// 另一种方式是将行为（判断逻辑）抽象出来（由于Java不能单独存在函数，必须在类或接口内部，Lambda表达式就是表现为函数形式的接口），所以我们实际说的是函数式接口：
// * 根据行为，我们先定义函数签名（行为的特征），如上述则是输入T类型，输出Boolean类型
// *
// *
// */
// public static List<Apple> filterApples(List<Apple> inventory,
// Predicate<Apple> predicate) {
// List<Apple> result = new ArrayList<>();
// for (Apple apple : inventory) {
// if (predicate.test(apple)) {
// result.add(apple);
// }
// }
// return result;
// }

// /**
// * 如何使用
// *
// *
// * 使用Predicate时，可以预先创建它的实例（new
// AppleHeavyWeightPredicate），也可以使用匿名内部类方式临时创建其实现的实例
// *
// * 或者使用Lambda表达式
// *
// * @param args
// */
// public static void main(String[] args) {
// List<Apple> inventory = new ArrayList<>();
// inventory.add(new Apple("red", 150));
// inventory.add(new Apple("green", 180));
// List<Apple> apples = filterApples(inventory, (apple) ->
// "red".equals(apple.getColor()));

// // 排序方式：
// // Collections.sort(instance,Compartor),
// // instance.sort(Compartor)
// }
// }

// interface Predicate<T> {
// boolean test(T t);
// }

// class AppleHeavyWeightPredicate implements Predicate<Apple> {

// @Override
// public boolean test(Apple t) {
// return t.getWeight() > 150;
// }

// }

// class AppleGreenColorPredicate implements Predicate<Apple> {

// @Override
// public boolean test(Apple t) {
// return "green".equals(t.getColor());
// }

// }

// @Data
// @AllArgsConstructor
// class Apple {
// private String color;

// private int weight;
// }