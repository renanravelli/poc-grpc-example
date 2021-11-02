package me.renanravelli.pocgrpc.grpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import me.renanravelli.pocgrpc.entities.User;
import me.renanravelli.pocgrpc.server.UUID;
import me.renanravelli.pocgrpc.server.UserRequest;
import me.renanravelli.pocgrpc.server.UserResponse;
import me.renanravelli.pocgrpc.server.UserServiceGrpc.UserServiceImplBase;
import me.renanravelli.pocgrpc.service.UserService;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author renanravelli
 */

@GrpcService
@RequiredArgsConstructor
public class UserServiceGrpcImpl extends UserServiceImplBase {

  private final UserService userService;

  @Override
  public void register(UserRequest request, StreamObserver<UserResponse> responseObserver) {

    final var user = userService.register(new User(request.getUsername()));

    final var response = UserResponse.newBuilder()
        .setId(UUID.newBuilder().setValue(user.getId().toString()).build())
        .setUsername(user.getUsername())
        .setPassword(user.getPassword())
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void find(UUID request, StreamObserver<UserResponse> responseObserver) {
    final var user = userService.find(java.util.UUID.fromString(request.getValue()));

    final var response = UserResponse.newBuilder()
        .setId(UUID.newBuilder().setValue(user.getId().toString()).build())
        .setUsername(user.getUsername())
        .setPassword(user.getPassword())
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
