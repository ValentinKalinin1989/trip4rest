package com.senla.afishaparser.service.parser;

import com.senla.afishaparser.model.Coordinate;
import com.senla.afishaparser.model.Place;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AfishaParserRestaurants {
    private AfishaParserRestaurants() {
        throw new IllegalStateException("AfishaParser is utility class");
    }

    public static List<String> getRestaurantLinks(String linkOnAfishaRestaurant) throws IOException {
        List<String> links = new ArrayList<>();
        Document doc = Jsoup.connect(linkOnAfishaRestaurant).ignoreHttpErrors(true).get();
        Elements restaurantInfo = doc.getElementsByClass("places");
        for(Element element: restaurantInfo) {
            links.add("https://www.afisha.ru" + element.getElementsByTag("a").attr("href"));
        }
        return links;
    }

    public static List<String> getAllRestaurantLinks() throws IOException {
        List<String> links = new ArrayList<>();
        links.addAll(
                getRestaurantLinks("https://www.afisha.ru/tula/restaurants/restaurant_list/?view=list")
        );
        List<String> subLinks;
        int count = 2;
        while (true) {
            subLinks = getRestaurantLinks(
                    "https://www.afisha.ru/tula/restaurants/restaurant_list/page" + count
                            + "/?view=list");
            if(subLinks.isEmpty()) {
                break;
            }
            links.addAll(subLinks);
            count++;
        }
        return links;
    }

    public static List<Place> getAllPlaces() throws IOException {
        List<Place> places = new ArrayList<>();
        Place place;
        Coordinate coordinate;
        List<String> links = getAllRestaurantLinks();
        for (String link: links) {
            Document doc = Jsoup.connect(link).get();
            place = new Place();
            coordinate = new Coordinate();
            place.setType("restaurant");
            place.setName(doc.getElementsByClass("place js-place-rest-card").attr("data-name"));
            place.setDescription(doc.getElementsByClass("about_item").next().text());
            coordinate.setAddress(doc.getElementsByClass("info-address__text").text());
            place.setCoordinate(coordinate);
            Elements contacts = doc.getElementsByClass("contact_sense");
            place.setPhone(contacts.get(2).text());
            if (contacts.size() > 3) {
                place.setSite("http://" + contacts.get(3).text());
            }
            StringBuilder kitchens = new StringBuilder("");
            doc.getElementsByClass("rest-tags_link")
                    .stream().map(Element::text).map(str->str.concat("; ")).forEach(kitchens::append);
            place.setInfo(kitchens.toString());
            place.setWorkTime(contacts.get(1).text());
            places.add(place);
        }
        return places;
    }

}
