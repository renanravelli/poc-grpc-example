package me.renanravelli.pocgrpc.service.impl;

import java.lang.module.ResolutionException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import me.renanravelli.pocgrpc.entities.User;
import me.renanravelli.pocgrpc.exceptions.NoResourceFoundException;
import me.renanravelli.pocgrpc.repositories.UserRepository;
import me.renanravelli.pocgrpc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author renanravelli
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User register(User user) {
    user.newPassword();
    return userRepository.save(user);
  }

  @Override
  public User find(UUID id) {
    return userRepository.findById(id).orElseThrow(NoResourceFoundException::new);
  }
}
