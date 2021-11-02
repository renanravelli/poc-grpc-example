package me.renanravelli.pocgrpc.repositories;

import java.util.UUID;
import me.renanravelli.pocgrpc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

}
