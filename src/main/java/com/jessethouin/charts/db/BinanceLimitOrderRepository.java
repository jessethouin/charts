package com.jessethouin.charts.db;

import com.jessethouin.charts.db.beans.BinanceLimitOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinanceLimitOrderRepository extends CrudRepository<BinanceLimitOrder, Long> {
    @Query(value = "SELECT orderId, originalAmount FROM BINANCE_LIMIT_ORDER BLO ORDER BY BLO.orderId DESC LIMIT 1", nativeQuery = true)
    Iterable<BinanceLimitOrder> getTopByOrderId();

    @Query(value = """
            SELECT BLO.orderId, BLO.limitPrice, BLO.averagePrice, BLO.type
            FROM ORDER_HISTORY_LOOKUP OHL
            LEFT JOIN BINANCE_LIMIT_ORDER BLO on OHL.orderId = BLO.id
            LEFT JOIN BINANCE_TRADE_HISTORY BTH on OHL.tradeId = BTH.tradeId
            ORDER BY BTH.timestamp DESC LIMIT :start, :end
            """, nativeQuery = true)
    Iterable<BinanceLimitOrder> getTopJoinBinanceTradeHistoryOrderByTradeId(int start, int end);

}
