package Exceptions;

public class CannotDieTwice extends Exception{
    public CannotDieTwice() {
        super("Ошибка: Персонаж уже покинул этот мир и не может сделать этого ещё раз.");
    }
}
