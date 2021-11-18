package pt.iade.mint.Controllers;
import java.util.Optional;

import pt.iade.mint.models.Exceptions.NotFoundException;
import pt.iade.mint.models.Exceptions.Response;
import pt.iade.mint.models.Rating;
import pt.iade.mint.models.Repositories.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/rating")
public class RatingController {
    private Logger logger = LoggerFactory.getLogger(RatingController.class);
    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Rating> getRatings() {
        logger.info("Sending all ratings");
        return ratingRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rating getRating(@PathVariable int id) {
        logger.info("Sending rating with id " + id);
        Optional<Rating> _rating = ratingRepository.findById(id);
        if (_rating.isEmpty())
            throw new NotFoundException("" + id, "Rating", "id");
        else
            return _rating.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rating saveRating(@RequestBody Rating rating) {
        Rating savedRating = ratingRepository.save(rating);
        logger.info("Saving rating with id " + savedRating.getId_rating());
        return savedRating;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteRating(@PathVariable int id) {
        logger.info("Deleting rating with id " + id);
        // No verification to see if it exists
        ratingRepository.deleteById(id);
        return new Response("Deleted rating with id " + id, null);
    }
}
