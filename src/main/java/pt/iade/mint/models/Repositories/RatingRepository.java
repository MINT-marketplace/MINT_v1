package pt.iade.mint.models.Repositories;

import pt.iade.mint.models.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
