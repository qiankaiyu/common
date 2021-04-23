package com.chuck.common.service;

import org.springframework.stereotype.Service;

/**
 * @author Chuck
 * @since 1/7/2021
 * @version
 *
 **/
@Service
public interface PurchaseService {

    public boolean purchase(int userId, int productId, int quantity);
}
