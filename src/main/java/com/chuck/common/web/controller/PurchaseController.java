package com.chuck.common.web.controller;

import com.chuck.common.services.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chuck
 * @since 1/7/2021
 * @version
 *
 **/
@RestController("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/{productId}")
    public Result purchase(@RequestBody Req req) {
        boolean success = purchaseService.purchase(req.getUserId(), req.getProductId(), req.getQuantity());
        return new Result(success, success ? "购买成功" : "购买失败");
    }

    /**
     * InnerPurchaseController
     */
    @Data
    public static class Req {
        int userId;
        int productId;
        int quantity;
    }

    @Data
    @NoArgsConstructor
    public static class Result {
        private Result(boolean success, String msg) {
            this.success = success;
            this.msg = msg;
        }

        private boolean success;
        private String msg;
    }
}
