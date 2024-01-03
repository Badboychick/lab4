package Interfaces;

import Exceptions.CannotAddThisAmount;
import Exceptions.CannotDieTwice;
import Exceptions.CannotMove;
import Objects.Trap;
import Objects.Place;

public interface Moveable {
    void move(Place place) throws CannotAddThisAmount, CannotMove;
}