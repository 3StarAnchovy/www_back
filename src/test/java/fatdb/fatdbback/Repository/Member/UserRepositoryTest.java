package fatdb.fatdbback.Repository.Member;

import fatdb.fatdbback.domain.Member.User;
import fatdb.fatdbback.domain.Member.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@Transactional
class UserRepositoryTest {
    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void 회원가입()
    {
        //given
        User user = new User();
        user.setId("test");
        user.setEmail("test@naver.com");
        user.setPw("test");
        user.setName("test");
        user.setTeam("test");
        user.setTel("test");

        //when
        userRepository.save(user);

        //then
        List<User> result = userRepository.findAll();
        for(User i : result)
        {
            assertThat(i.getId().equals("test"));
        }
    }
}