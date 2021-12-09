package net.imanbayli.service;

import net.imanbayli.model.BookRequest;
import net.imanbayli.model.BookResponse;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    BookResponse add(BookRequest request);
}
