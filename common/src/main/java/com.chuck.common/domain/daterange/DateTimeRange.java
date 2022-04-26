package com.chuck.common.domain.daterange;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 日期范围
 *
 * @author Chuck
 * @version 0.0.1
 * @apiNote Value Object
 * @since 2021年7月28日
 */
@Getter
@Setter
@AllArgsConstructor
public class DateTimeRange {
  @Past @NotNull private LocalDateTime since;

  private LocalDateTime to;

  public DateTimeRange() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime yesterday = now.minusDays(1);
    this.setSince(yesterday);
    this.setTo(now);
  }

  public DateTimeRange(LocalDateTime since) {
    this.setSince(since);
    this.setTo(LocalDateTime.now());
  }
}
