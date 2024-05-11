package org.example.tgbot.controllers;

import lombok.RequiredArgsConstructor;
import org.example.tgbot.dto.ValuteCursOnDate;
import org.example.tgbot.entity.Spend;
import org.example.tgbot.service.CentralRussianBankService;
import org.example.tgbot.service.ExcessCosts;
import org.example.tgbot.service.FinanceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;

    @GetMapping("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }


    private final ExcessCosts excessCosts;

    @GetMapping("/getStatsBetweenDates")
    @ResponseBody
    public List<Spend> getStatsBetweenDates(@RequestParam(value = "amount") BigDecimal amount) {

        return excessCosts.calculation(amount);
    }
}
