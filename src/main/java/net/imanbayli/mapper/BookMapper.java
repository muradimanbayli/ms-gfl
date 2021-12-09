package net.imanbayli.mapper;

import net.imanbayli.entity.BookEntity;
import net.imanbayli.model.BookRequest;
import net.imanbayli.model.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookEntity requestToEntity(BookRequest request);
    BookResponse entityToResponse(BookEntity bookEntity);
}
