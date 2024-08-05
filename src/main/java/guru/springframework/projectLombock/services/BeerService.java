package guru.springframework.projectLombock.services;

import guru.springframework.projectLombock.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
