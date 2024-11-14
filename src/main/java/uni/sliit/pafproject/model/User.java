package uni.sliit.pafproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    private String userType;
    private String userName;
    private String userPassword;
    private String userLoginState;
    private String userHref;
    private String userSelf;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.EMPTY_LIST;
    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }


    public boolean isEnabled() {
        return true;
    }


}
