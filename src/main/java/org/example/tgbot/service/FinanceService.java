package org.example.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.example.tgbot.entity.Income;
import org.example.tgbot.entity.Spend;
import org.example.tgbot.repository.IncomeRepository;
import org.example.tgbot.repository.SpendRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FinanceService {

    static final String ADD_INCOME = "/addincome";

    private final IncomeRepository incomeRepository;
    private final SpendRepository spendRepository;


    public String addFinanceOperation(String operationType, String price, Long chatId) {
        String message;
        if (ADD_INCOME.equalsIgnoreCase(operationType)) {
            Income income = new Income();
            income.setChatId(chatId);
            income.setIncome(new BigDecimal(price));
            LocalDate ld = LocalDate.now();
            income.setDate(Date.valueOf(ld));
            incomeRepository.save(income);
            message = "Доход в размере " + price + " был успешно добавлен";
        } else {
            Spend spend = new Spend();
            spend.setChatId(chatId);
            spend.setSpend(new BigDecimal(price));
            LocalDate ld = LocalDate.now();
            spend.setDate(Date.valueOf(ld));
            spendRepository.save(spend);
            message = "Расход в размере " + price + " был успешно добавлен";
        }
        return message;
    }
}