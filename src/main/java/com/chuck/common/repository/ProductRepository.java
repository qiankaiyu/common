package com.chuck.common.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Chuck
 * @since 1/6/2021
 * @version
 *
 **/
@Repository
public interface ProductRepository // extends CrudRepository<Product, Integer>
{
    @Query("update Product p set p.stock=p.stock-?2,p.version=p.version+1 where p.id=?1 and p.version=?3")
    @Modifying
    public int decreaseProduct(int id, int quantity, int version);
}
