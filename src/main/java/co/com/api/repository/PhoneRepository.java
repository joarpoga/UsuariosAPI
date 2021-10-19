package co.com.api.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import co.com.api.jpa.PhoneJPA;

public interface PhoneRepository extends CrudRepository<PhoneJPA, UUID>  {

}
