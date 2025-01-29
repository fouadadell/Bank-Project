package com.fouad.Bank.controller;

import com.fouad.Bank.dto.CardDTO;
import com.fouad.Bank.service.CardsService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
public class CardsController {

    @Autowired
    private final CardsService cardsService;
    @GetMapping("/myCardDetails")
    public CardDTO getCardDetails(@RequestParam String cardNumber) {
        return cardsService.getCardDetails(cardNumber);
    }

    @GetMapping("/myAllCards")
    public List<CardDTO> getAllCards(@RequestParam("customerEmail") String customerEmail) {
        return cardsService.getAllCards(customerEmail);
    }

}
