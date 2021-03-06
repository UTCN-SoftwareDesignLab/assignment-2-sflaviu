package bookstore.service.author;

import bookstore.dto.AuthorDTO;
import bookstore.entity.Author;

import java.util.List;

/**
 * Created by Catalysts on 9/9/2015.
 */
public interface AuthorService {
    List<Author> getAll();
    Author findById(int authorId);
    Author create(AuthorDTO authorDTO);
}
