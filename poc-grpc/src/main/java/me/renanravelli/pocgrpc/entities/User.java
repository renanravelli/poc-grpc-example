package me.renanravelli.pocgrpc.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

/**
 * @author renanravelli
 */

@Entity
@Getter
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  public User(String username) {
    this.username = username;
  }

  public User(UUID id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public void newPassword() {
    this.password = UUID.randomUUID().toString();
  }

}
