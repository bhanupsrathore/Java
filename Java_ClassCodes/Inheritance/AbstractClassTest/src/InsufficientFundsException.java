package banking;

//compile-time checked exception - it can only occur within a try block which catches it
//or in an implementation of a method in which it is declared to be thrown
public class InsufficientFundsException extends Exception {}

