package com.jessethouin.charts.db;

import com.jessethouin.charts.db.beans.BinanceTradeHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinanceTradeHistoryRepository extends CrudRepository<BinanceTradeHistory, Long> {
    @Query(value = "SELECT * FROM BINANCE_TRADE_HISTORY bth ORDER BY bth.tradeId desc LIMIT :start, :end", nativeQuery = true)
    Iterable<BinanceTradeHistory> getTopOrderByTradeId(int start, int end);
}
