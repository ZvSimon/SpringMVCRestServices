package guru.springframework.springRestServices.controllers;

import guru.springframework.springRestServices.model.Beer;
import guru.springframework.springRestServices.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController

public class BeerController {

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH+"/{beerId}";
    private final BeerService beerService;

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity<Beer>updateBeerPatchById(@PathVariable("beerId")UUID beerId,@RequestBody Beer beer){
        beerService.patchBeerById(beerId,beer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)

    public ResponseEntity<Beer>deleteById(@PathVariable("beerId")UUID beerId){
        beerService.deleteById(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(BEER_PATH_ID)
    public ResponseEntity<Beer>updateById(@PathVariable("beerId")UUID beerId,@RequestBody Beer beer){
        beerService.updateBeerById(beerId,beer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping(BEER_PATH)
    public ResponseEntity<Beer> handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH+"/" + savedBeer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @GetMapping(BEER_PATH)
    public ResponseEntity<List<Beer>> listBeers() {
        log.debug("List Beers - in controller");
        List<Beer> beers = beerService.listBeers();
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }

    @GetMapping(BEER_PATH_ID)
    public ResponseEntity<Beer> getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug("Get Beer by Id - in controller");
        Beer beer = beerService.getBeerById(beerId);
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }
}
