package fatdb.fatdbback.controller.Member;
import fatdb.fatdbback.Auth.JwtTokenProvider;
import fatdb.fatdbback.Repository.Member.UserRepository;
import fatdb.fatdbback.domain.Member.User;
import fatdb.fatdbback.domain.Member.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fatdb.fatdbback.service.Member.UserService;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class MemberController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public MemberController(UserService userService, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    //회원가입
    //처리해야할 예외처리 : 빈값, 중복
    @PostMapping("/join")
    public String joinController(@RequestBody UserDto userDto) {
        log.info("------------join_router------------------");
        System.out.println("join_Router");
        userService.joinUser(userDto);
        return ("tt");
    }

    //로그인
    //처리해야할 예외처리 : 빈값
    //동작확인
    @PostMapping("/login")
    public String loginController(@RequestBody UserDto userDto) {
        log.info("--------------login_router----------------");
//        Optional<User> result = userService.loginUser(userDto);
//        if(result.isEmpty()) {
//            return new ResponseEntity<>("no", HttpStatus.valueOf(404));
//        }
//        return jwtTokenProvider.createToken();
        User member = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));

        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
        //public ResponseEntity<?> loginController(@RequestBody UserDto userDto
    }
}
