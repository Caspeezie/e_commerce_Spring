package com.ecommerce.service.card;

import com.ecommerce.data.model.Card;

import java.util.List;

public interface CardService {
    public Card saveCard(Card card);
    public List<Card> findAllCards();
    public void deleteCardById(Integer id);
    public Card updateCard(Card card);
}
