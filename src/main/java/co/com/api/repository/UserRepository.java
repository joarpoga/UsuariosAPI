package co.com.api.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import co.com.api.jpa.UserJPA;

public interface UserRepository extends CrudRepository<UserJPA, UUID>  {

}
