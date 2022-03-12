package com.chuck.common.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.ObjectUtils;

/**
 *
 * @author Administrator
 * @since 2021/8/23
 * @version 0.0.1
 * @apiNote Value Object
 **/
public class SortUtils {
    private SortUtils() {
    }

    public static List<Order> ordersOfSort(String sort) {
        if (ObjectUtils.isEmpty(sort)) {
            return Arrays.asList(Order.by("id"));
        }

        List<Order> orders = new ArrayList<>(5);
        String[] ordersOfStr = sort.split(",");
        for (String orderOfStr : ordersOfStr) {
            orders.add(order(orderOfStr));
        }
        return orders;
    }

    private static Order order(String orderOfStr) {
        Direction dir = Direction.ASC;
        String property = orderOfStr;

        if (hasPlusOrMinusSymbol(orderOfStr)) {
            property = orderOfStr.substring(1);
        }
        if (orderOfStr.startsWith("-")) {
            dir = Direction.DESC;
        }
        return new Order(dir, property);
    }

    private static boolean hasPlusOrMinusSymbol(String orderOfStr) {
        if (ObjectUtils.isEmpty(orderOfStr)) {
            return Boolean.FALSE;
        }
        if (orderOfStr.startsWith("-") || orderOfStr.startsWith("+")) {
            return Boolean.TRUE;
        }
        return false;
    }
}
