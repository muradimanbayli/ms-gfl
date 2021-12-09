package net.imanbayli.service.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.imanbayli.entity.BookEntity;
import net.imanbayli.mapper.BookMapper;
import net.imanbayli.model.BookRequest;
import net.imanbayli.model.BookResponse;
import net.imanbayli.repository.BookRepository;
import net.imanbayli.service.BookService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private final BookMapper MAPPER = BookMapper.INSTANCE;
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse add(BookRequest request) {
        BookEntity bookEntity = MAPPER.requestToEntity(request);
        BookEntity savedEntity = bookRepository.save(bookEntity);
        BookResponse response = MAPPER.entityToResponse(savedEntity);
        log.info("Book saved with id={} ", response.getId());
        return response;
    }
}
