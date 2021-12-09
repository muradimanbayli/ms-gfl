package net.imanbayli.service.implementation;

import net.imanbayli.entity.BookEntity;
import net.imanbayli.model.BookRequest;
import net.imanbayli.model.BookResponse;
import net.imanbayli.repository.BookRepository;
import net.imanbayli.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BookServiceImplTest {
    private BookService bookService;
    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void test_addBook_Success(){
        //setup
        BookRequest request = new BookRequest();
        request.setBookName("TEST");
        request.setAuthor("TEST");
        request.setPrice(new BigDecimal("5.5"));
        request.setCurrency("USD");
        when(bookRepository.save(any())).thenReturn(new BookEntity());
        //when
        BookResponse response = bookService.add(request);
        //expect
        assertThat(response).isNotNull();
        ArgumentCaptor<BookEntity> entityArgumentCaptor = ArgumentCaptor.forClass(BookEntity.class);
        verify(bookRepository).save(entityArgumentCaptor.capture());
        assertThat(entityArgumentCaptor.getValue().getBookName()).isEqualTo(request.getBookName());
        assertThat(entityArgumentCaptor.getValue().getAuthor()).isEqualTo(request.getAuthor());
        assertThat(entityArgumentCaptor.getValue().getCurrency().name()).isEqualTo(request.getCurrency());
        assertThat(entityArgumentCaptor.getValue().getPrice()).isEqualTo(request.getPrice());
    }
}