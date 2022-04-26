package com.chuck.common.domain.audit;

import com.chuck.common.domain.core.IdentifiedEntity;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/** 如非必要，不推荐继承该类来使用审计功能。而是单独使用审计服务实现 */
@MappedSuperclass
@Getter
@Setter
public abstract class AuditValueObject extends IdentifiedEntity {

  @Embedded private Audit audit;
}
