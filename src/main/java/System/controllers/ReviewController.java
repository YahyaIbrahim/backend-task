package System.controllers;

import System.dtos.ReviewDTO;
import System.objects.Success;
import System.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@RestController
@RequestMapping("/review")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<?> postReview(@RequestBody ReviewDTO reviewDTO) {
        reviewService.postReview(reviewDTO);
        return new ResponseEntity<>(new Success(true), HttpStatus.OK);
    }
}
