package guru.springframework.springRestServices.controllers;

import guru.springframework.springRestServices.model.Beer;
import guru.springframework.springRestServices.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PostMapping
    public ResponseEntity<Beer> handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);
        return new ResponseEntity<>(savedBeer, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Beer>> listBeers() {
        log.debug("List Beers - in controller");
        List<Beer> beers = beerService.listBeers();
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public ResponseEntity<Beer> getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug("Get Beer by Id - in controller");
        Beer beer = beerService.getBeerById(beerId);
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }
}
