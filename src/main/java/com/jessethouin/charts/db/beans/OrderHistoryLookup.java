package com.jessethouin.charts.db.beans;

import com.jessethouin.charts.db.BigDecimalConverter;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDER_HISTORY_LOOKUP")
@Data
public class OrderHistoryLookup {
    @Id
    private long id;
    private long tradeId;
    private long orderId;
    @Convert(converter = BigDecimalConverter.class)
    @Column(name = "value")
    private BigDecimal pval;
}
