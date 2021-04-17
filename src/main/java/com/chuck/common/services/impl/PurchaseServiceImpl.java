// package com.chuck.common.services.impl;

// import javax.transaction.Transactional;
// import javax.transaction.Transactional.TxType;

// import com.chuck.common.domain.Product;
// import com.chuck.common.model.PurchaseRecord;
// import com.chuck.common.repository.ProductRepository;
// import com.chuck.common.repository.PurchaseRecordRepository;
// import com.chuck.common.services.PurchaseService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import lombok.extern.slf4j.Slf4j;

// /**
// * @author Chuck
// * @since 1/7/2021
// * @version
// *
// **/
// @Slf4j
// @Service
// public class PurchaseServiceImpl implements PurchaseService {
// @Autowired
// private PurchaseRecordRepository recordRepo;
// @Autowired
// private ProductRepository productRepo;

// @Transactional(value = TxType.NOT_SUPPORTED)
// @Override
// public boolean purchase(int userId, int productId, int quantity) {
// Product prod = productRepo.findById(productId).get();
// if (quantity > prod.getStock()) {
// log.warn("产品数量不足，现有库存：%d ;需要购买：%d", prod.getStock(), quantity);
// return Boolean.FALSE;
// }
// int affectRows = productRepo.decreaseProduct(productId, quantity,
// prod.getVersion());
// if (affectRows == 0) {
// return Boolean.FALSE;
// }
// PurchaseRecord record = new PurchaseRecord();
// record.setPrice(prod.getPrice());
// record.setProductId(productId);
// record.setQuantity(quantity);
// record.setSum(prod.getPrice() * quantity);
// record.setUserId(userId);
// record.setNote("购买日志，购买时间：" + System.currentTimeMillis());
// recordRepo.save(record);
// return Boolean.TRUE;
// }

// }
