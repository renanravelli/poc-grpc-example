package me.renanravelli.pocgrpc.exceptions;

/**
 * @author renanravelli
 */
public class NoResourceFoundException extends RuntimeException {

  public NoResourceFoundException() {
    super("Resource not found.");
  }
}
