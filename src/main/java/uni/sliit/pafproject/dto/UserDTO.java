package uni.sliit.pafproject.dto;


import lombok.Builder;
import lombok.Data;
import uni.sliit.pafproject.model.User;

@Builder
@Data
public class UserDTO {
    private String userId;
    private String userName;

    public static UserDTO from(User user) {
        return builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }
}
