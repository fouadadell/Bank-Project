package com.fouad.Bank.service;

import com.fouad.Bank.dto.CardDTO;
import com.fouad.Bank.model.Customer;
import com.fouad.Bank.repository.CardsRepository;
import com.fouad.Bank.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CardsService {
    @Autowired
    private final CardsRepository cardsRepository;
    @Autowired
    private final CustomerRepository customerRepository;

    public CardDTO getCardDetails(String cardNumber) {
        return cardsRepository.findByCardNumber(cardNumber).
                map(card -> new CardDTO(card.getCardNumber(),
                        card.getCardType(),
                        card.getTotalLimit(),
                        card.getAmountUsed(),
                        card.getAvailableAmount())).orElse(null);
    }


    public List<CardDTO> getAllCards(String customerEmail) {
        Optional<Customer> customer = customerRepository.findByEmail(customerEmail);

        return customer.get().getCards().stream().map(card -> new CardDTO(
                card.getCardNumber(),
                card.getCardType(),
                card.getTotalLimit(),
                card.getAmountUsed(),
                card.getAvailableAmount())).toList();

    }

}
