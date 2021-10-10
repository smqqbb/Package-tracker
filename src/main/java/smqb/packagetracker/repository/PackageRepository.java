package smqb.packagetracker.repository;

import org.springframework.data.repository.CrudRepository;
import smqb.packagetracker.entity.PackageEntity;
import smqb.packagetracker.entity.UserEntity;

public interface PackageRepository extends CrudRepository<PackageEntity, Long> {
    PackageEntity findByFromUser(UserEntity fromUser);
}