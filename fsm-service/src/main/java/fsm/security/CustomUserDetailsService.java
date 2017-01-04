package fsm.security;

import fsm.model.domain.UserRole;
import fsm.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        fsm.model.domain.User user = userService.getUserByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

    // Converts fsm.domain.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(fsm.model.domain.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), authorities);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}