package smqb.packagetracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smqb.packagetracker.entity.PackageEntity;
import smqb.packagetracker.entity.UserEntity;
import smqb.packagetracker.repository.PackageRepository;
import smqb.packagetracker.repository.UserRepository;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PackageEntityTest {
    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private UserRepository userRepository;
    @Test
    void entitySave_thenFindByName(){
        UserEntity fromUser = new UserEntity("User1");
        userRepository.save(fromUser);
        assertThat(userRepository.findByEmail("User1")).isNotNull();

        UserEntity toUser = new UserEntity("User2");
        userRepository.save(toUser);
        assertThat(userRepository.findByEmail("User2")).isNotNull();

        PackageEntity box = new PackageEntity();
        box.setFromUser(fromUser);
        box.setToUser(toUser);

        packageRepository.save(box);
        assertThat(packageRepository.findByFromUser(fromUser)).isNotNull();
    }
}
