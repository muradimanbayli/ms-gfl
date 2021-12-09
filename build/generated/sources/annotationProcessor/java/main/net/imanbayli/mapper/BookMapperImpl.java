package net.imanbayli.mapper;

import javax.annotation.processing.Generated;
import net.imanbayli.entity.BookEntity;
import net.imanbayli.entity.BookEntity.BookEntityBuilder;
import net.imanbayli.entity.BookEntity.Currency;
import net.imanbayli.model.BookRequest;
import net.imanbayli.model.BookResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-10T01:56:59+0400",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 13.0.2 (AdoptOpenJDK)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity requestToEntity(BookRequest request) {
        if ( request == null ) {
            return null;
        }

        BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.bookName( request.getBookName() );
        bookEntity.author( request.getAuthor() );
        bookEntity.price( request.getPrice() );
        if ( request.getCurrency() != null ) {
            bookEntity.currency( Enum.valueOf( Currency.class, request.getCurrency() ) );
        }

        return bookEntity.build();
    }

    @Override
    public BookResponse entityToResponse(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setId( bookEntity.getId() );

        return bookResponse;
    }
}
