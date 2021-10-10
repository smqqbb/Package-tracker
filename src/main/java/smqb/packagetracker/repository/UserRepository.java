package smqb.packagetracker.repository;

import org.springframework.data.repository.CrudRepository;
import smqb.packagetracker.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}