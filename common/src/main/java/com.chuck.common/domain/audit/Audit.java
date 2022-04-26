package com.chuck.common.domain.audit;

import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Audit {
  /** 是否有必要调整为ZonedDateTime THINKING */
  private LocalDateTime createWhen = LocalDateTime.now();
  /** 创建人，在修改时需要保持不变 */
  private int createBy;

  private LocalDateTime modifyWhen = LocalDateTime.now();

  private int modifyBy;
}
