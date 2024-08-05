package guru.springframework.springRestServices.services;

import guru.springframework.springRestServices.model.Beer;
import guru.springframework.springRestServices.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    private final Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder().id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123456")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Beer beer2 = Beer.builder().id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Dog")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123456121")
                .price(new BigDecimal("10.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Beer beer3 = Beer.builder().id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Fox")
                .beerStyle(BeerStyle.IPA)
                .upc("1234561234")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public void updateBeer(UUID beerId, Beer beer) {
        Beer beerToUpdate = beerMap.get(beerId);
        beerToUpdate.setBeerName(beer.getBeerName());
        beerToUpdate.setVersion(beer.getVersion());
        beerToUpdate.setBeerStyle(beer.getBeerStyle());
        beerToUpdate.setPrice(beer.getPrice());
        beerToUpdate.setUpc(beer.getUpc());
        beerToUpdate.setQuantityOnHand(beer.getQuantityOnHand());
        beerToUpdate.setUpdateDate(LocalDateTime.now());
        beerMap.put(beerId, beerToUpdate);
    }

    @Override
    public List<Beer> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID beerId) {
        log.debug("Getting beer by id"+beerId.toString());
        return beerMap.get(beerId);
    }
    @Override
    public Beer saveNewBeer(Beer beer){
        Beer savedBeer = Beer.builder().id(UUID.randomUUID())
                .version(1)
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .quantityOnHand(beer.getQuantityOnHand())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

            beerMap.put(savedBeer.getId(),savedBeer);
            return savedBeer;

    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }
}
