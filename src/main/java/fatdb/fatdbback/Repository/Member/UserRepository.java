package fatdb.fatdbback.Repository.Member;

import fatdb.fatdbback.domain.Member.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
