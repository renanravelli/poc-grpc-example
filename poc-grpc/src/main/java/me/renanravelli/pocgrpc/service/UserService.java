package me.renanravelli.pocgrpc.service;

import java.util.UUID;
import me.renanravelli.pocgrpc.entities.User;

/**
 * @author renanravelli
 */
public interface UserService {

  User register(User user);

  User find(UUID id);

}
