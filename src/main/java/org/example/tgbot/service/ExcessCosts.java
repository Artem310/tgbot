package org.example.tgbot.service;

import org.example.tgbot.entity.Spend;
import org.example.tgbot.repository.SpendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExcessCosts {

    @Autowired
    SpendRepository spendRepository;

    public List<Spend> calculation(BigDecimal amount) {
        return spendRepository.findAll().stream().filter(spend -> spend.getSpend().compareTo(amount) > 0)
                .toList();
    }
}
