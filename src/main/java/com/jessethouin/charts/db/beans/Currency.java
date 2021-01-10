package com.jessethouin.charts.db.beans;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CURRENCY")
@Data
public class Currency {
    @Id
    private long currencyId;
    private String symbol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baseCurrency", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<CurrencyPosition> currencyPositions = new HashSet<>();
}
