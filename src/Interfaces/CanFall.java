package Interfaces;

import Enums.Place;

public interface CanFall {
    void fall(Place place);
    void die();
    void noticed();
}