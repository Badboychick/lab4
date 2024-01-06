package Exceptions;

public class CannotDoThisAction extends RuntimeException{
    public CannotDoThisAction() {
        super("Ошибка: Персонаж в данный момент не может выполнить это действие.");
    }
}
