package com.jessethouin.charts.db.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "BINANCE_LIMIT_ORDER")
public class BinanceLimitOrder {
    @Id
    public long orderId;
    public BigDecimal limitPrice;
    public BigDecimal averagePrice;
    public int type;
}
