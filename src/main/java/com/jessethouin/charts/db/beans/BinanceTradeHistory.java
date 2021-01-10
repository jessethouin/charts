package com.jessethouin.charts.db.beans;

import com.jessethouin.charts.db.BigDecimalConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BINANCE_TRADE_HISTORY")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class BinanceTradeHistory {
    @Id
    private Long tradeId;
    private Date timestamp;
    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal ma1;
    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal ma2;
    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal l;
    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal h;
    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal p;
}
