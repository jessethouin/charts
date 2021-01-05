package com.jessethouin.charts.web;

import com.jessethouin.charts.db.BinanceLimitOrderRepository;
import com.jessethouin.charts.db.BinanceTradeHistoryRepository;
import com.jessethouin.charts.db.OrderHistoryLookupRepository;
import com.jessethouin.charts.db.beans.BinanceLimitOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ChartController {
    private final BinanceTradeHistoryRepository binanceTradeHistoryRepository;
    private final BinanceLimitOrderRepository binanceLimitOrderRepository;
    private final OrderHistoryLookupRepository orderHistoryLookupRepository;

    public ChartController(BinanceTradeHistoryRepository binanceTradeHistoryRepository, BinanceLimitOrderRepository binanceLimitOrderRepository, OrderHistoryLookupRepository orderHistoryLookupRepository) {
        this.binanceTradeHistoryRepository = binanceTradeHistoryRepository;
        this.binanceLimitOrderRepository = binanceLimitOrderRepository;
        this.orderHistoryLookupRepository = orderHistoryLookupRepository;
    }

    @GetMapping(path = "/data", produces = "application/json")
    public @ResponseBody Map<String, Iterable<?>> chart(@RequestParam(name="length", required=false, defaultValue="500") int length) {
        Map<String, Iterable<?>> returnValue = new HashMap<>();
        returnValue.put("trades", binanceTradeHistoryRepository.getTopOrderByTradeId(1, length));
        returnValue.put("orders", binanceLimitOrderRepository.getTopJoinBinanceTradeHistoryOrderByTradeId(1, length));
        returnValue.put("vals", orderHistoryLookupRepository.getValues(1, length));
        return returnValue;
    }

    @GetMapping(path="/balance", produces = "application/json")
    public @ResponseBody Double balance() {
        return (double) 0;
    }

    @GetMapping(path = "/order", produces = "application/json")
    public @ResponseBody Iterable<BinanceLimitOrder> orders() {
        return binanceLimitOrderRepository.getTopByOrderId();
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
