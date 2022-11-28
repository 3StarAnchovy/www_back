package fatdb.fatdbback.service.Member;

import fatdb.fatdbback.Repository.Member.UserRepository;
import fatdb.fatdbback.domain.Member.User;
import fatdb.fatdbback.domain.Member.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String joinUser(UserDto userDto)
    {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPw(userDto.getPw());
        user.setEmail(userDto.getEmail());
        user.setTel(userDto.getTel());
        user.setTeam(userDto.getTeam());
        userRepository.save(user);
        return ("굳");
    }

    public Optional<User> loginUser(UserDto userDto)
    {
        Optional<User> userInfo = userRepository.findById(userDto.getId());
        //System.out.println(userInfo);
        userInfo.ifPresent(result -> {
            //로그인액션
        });
        if(userInfo.isEmpty()) {
            return (Optional.empty());
        }
        return (userInfo);
    }
}
