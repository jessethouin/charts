package com.jessethouin.charts.db;

import com.jessethouin.charts.db.beans.BinanceLimitOrder;
import com.jessethouin.charts.db.beans.OrderHistoryLookup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryLookupRepository extends CrudRepository<OrderHistoryLookup, Long> {
    @Query(value = """
            SELECT OHL.id, OHL.orderId, OHL.tradeId, OHL.value
            FROM ORDER_HISTORY_LOOKUP OHL
            LEFT JOIN BINANCE_LIMIT_ORDER BLO on OHL.orderId = BLO.orderId
            LEFT JOIN BINANCE_TRADE_HISTORY BTH on OHL.tradeId = BTH.tradeId
            ORDER BY BTH.timestamp DESC LIMIT :start, :end
            """, nativeQuery = true)
    Iterable<OrderHistoryLookup> getValues(int start, int end);

}
