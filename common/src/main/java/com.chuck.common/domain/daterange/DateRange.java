package com.chuck.common.domain.daterange;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
*
* @author Chuck
* @since Apr 26, 2022
* @version 0.0.1
* @apiNote Value Object
**/
@Data
@AllArgsConstructor
public class DateRange {
    @Past
    @NotNull
    private LocalDate since;

    private LocalDate to;

    public DateRange() {
        LocalDate now = LocalDate.now();
        LocalDate yesterday = now.minusDays(1);
        this.setSince(yesterday);
        this.setTo(now);
    }

    public DateRange(LocalDate since) {
        this.setSince(since);
        this.setTo(LocalDate.now());
    }
}
