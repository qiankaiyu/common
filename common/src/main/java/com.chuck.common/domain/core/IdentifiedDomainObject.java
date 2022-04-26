package com.chuck.common.domain.core;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * Chuck 26/9/21 10:20
 */
@MappedSuperclass
@Getter
@Setter
@Access(AccessType.FIELD)
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class IdentifiedDomainObject implements Serializable {

    /**
     * 未持久化的实体id为null
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    // protected int getId() {
    // return this.id;
    // }

    // protected void setId(int anId) {
    // this.id = anId;
    // }
    protected abstract String getName();

    public IdNamePair identify(){
        return new IdNamePair(this.getId(),this.getName());
    }
}