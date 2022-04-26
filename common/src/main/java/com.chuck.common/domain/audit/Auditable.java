package com.chuck.common.domain.audit;

import java.time.ZonedDateTime;
import lombok.Value;

/**
 * @description
 * @author: Chuck
 * @date: 1/15/2022 4:49 PM
 */
@Value
public class Auditable {
  /** 是否有必要调整为ZonedDateTime THINKING */
  private ZonedDateTime createWhen = ZonedDateTime.now();
  /** 创建人，在修改时需要保持不变 */
  private int createBy;

  private ZonedDateTime modifyWhen = ZonedDateTime.now();

  private int modifyBy;
}
