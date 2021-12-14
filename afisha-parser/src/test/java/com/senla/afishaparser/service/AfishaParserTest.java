package com.senla.afishaparser.service;

import com.senla.afishaparser.model.Place;
import com.senla.afishaparser.service.parser.AfishaParserRestaurants;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AfishaParserTest {

    @Test
    void getRestaurantLinks() throws IOException {
        AfishaParserRestaurants.getRestaurantLinks("https://www.afisha.ru/tula/restaurants/restaurant_list/?view=list")
                .stream().forEach(System.out::println);

        System.out.println("1");

        AfishaParserRestaurants.getRestaurantLinks("https://www.afisha.ru/tula/restaurants/restaurant_list/page2/?view=list")
                .stream().forEach(System.out::println);

        System.out.println("2");

        AfishaParserRestaurants.getRestaurantLinks("https://www.afisha.ru/tula/restaurants/restaurant_list/page3/?view=list")
                .stream().forEach(System.out::println);

        System.out.println("3");

        AfishaParserRestaurants.getRestaurantLinks("https://www.afisha.ru/tula/restaurants/restaurant_list/page4/?view=list")
                .stream().forEach(System.out::println);

        System.out.println("4");

        AfishaParserRestaurants.getRestaurantLinks("https://www.afisha.ru/tula/restaurants/restaurant_list/page5/?view=list")
                .stream().forEach(System.out::println);

        System.out.println("5");

        AfishaParserRestaurants.getRestaurantLinks("https://www.afisha.ru/tula/restaurants/restaurant_list/page6/?view=list")
                .stream().forEach(System.out::println);

        System.out.println("6");
    }

    @Test
    void testGetAllRestaurantLinks() throws IOException {
        AfishaParserRestaurants.getAllRestaurantLinks()
                .stream().forEach(System.out::println);
    }

    @Test
    void testGetAllPlaces() throws IOException {
        AfishaParserRestaurants.getAllPlaces()
                .stream().map(Place::toString).forEach(System.out::println);    }

}