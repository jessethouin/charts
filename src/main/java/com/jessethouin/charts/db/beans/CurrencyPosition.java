package com.jessethouin.charts.db.beans;

import com.jessethouin.charts.db.BigDecimalConverter;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CURRENCY_POSITION")
@Data
public class CurrencyPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long positionId;
    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal quantity;
    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "counter_currency_id")
    private Currency counterCurrency;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id")
    private Currency baseCurrency;
}
