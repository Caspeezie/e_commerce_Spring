package com.ecommerce.service.card;

import com.ecommerce.data.model.Card;
import com.ecommerce.data.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CardServiceImplTest {

    @Mock
    CardRepository cardRepository;

    @InjectMocks
    CardService cardService = new CardServiceImpl();

    Card card;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        card = new Card();
    }

    @Test
    void testThatWeCanCallTheSaveCardRepository () {
        when(cardRepository.save(card)).thenReturn(card);
        cardService.saveCard(card);
        verify(cardRepository, times(1)).save(card);
    }

    @Test
    void testThatWeCanCallTheFindCardRepository () {
        List<Card> cardList = new ArrayList<>();

        when(cardRepository.findAll()).thenReturn(cardList);
        cardService.findAllCards();
        verify(cardRepository, times(1)).findAll();
    }

    @Test
    void testThatWeCanCallTheDeleteCardByIdRepository () {
        doNothing().when(cardRepository).deleteById(2);
        cardService.deleteCardById(2);
        verify(cardRepository, times(1)).deleteById(2);
    }

    @Test
    void testThatWeCanCallTheUpdateCardRepository() {
        when(cardRepository.save(card)).thenReturn(card);
        cardService.updateCard(card);
        verify(cardRepository, times(1)).save(card);
    }
}
