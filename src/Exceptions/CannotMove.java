package Exceptions;

public class CannotMove extends Exception{
    public CannotMove() {
        super("Ошибка: Персонаж в данный момент не может передвигаться.");
    }
}
