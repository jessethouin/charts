package com.jessethouin.charts.db.beans;

import com.jessethouin.charts.db.BigDecimalConverter;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CURRENCY")
@Data
public class Currency {
    @Id
    private long currencyId;
    private String symbol;
    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal quantity;
}
