package fatdb.fatdbback.domain.Member;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String pw;
    private String email;
    private String tel;
    private String team;
}
