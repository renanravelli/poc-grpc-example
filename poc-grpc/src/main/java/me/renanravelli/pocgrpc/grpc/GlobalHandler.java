package me.renanravelli.pocgrpc.grpc;

import io.grpc.Status;
import lombok.RequiredArgsConstructor;
import me.renanravelli.pocgrpc.exceptions.NoResourceFoundException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

/**
 * @author renanravelli
 */

@GrpcAdvice
@RequiredArgsConstructor
public class GlobalHandler {

  @GrpcExceptionHandler
  public Status handleNoResourceFound(NoResourceFoundException ex) {
    return Status.NOT_FOUND.withDescription(ex.getMessage())
        .withCause(ex);
  }

  @GrpcExceptionHandler
  public Status handleNoResourceFound(Exception ex) {
    return Status.INTERNAL.withDescription(ex.getMessage())
        .withCause(ex);
  }

}
