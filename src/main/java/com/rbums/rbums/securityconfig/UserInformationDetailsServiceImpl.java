package com.rbums.rbums.securityconfig;

import com.rbums.rbums.role.model.Role;
import com.rbums.rbums.userinformation.model.UserInformation;
import com.rbums.rbums.userinformation.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserInformationDetailsServiceImpl implements UserDetailsService {
    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */

    @Autowired
    UserInformationRepository userInformationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInformation> userInformation=userInformationRepository.findByUsername(username);
        if (!userInformation.isPresent()){
            throw new UsernameNotFoundException("User with "+username+" not found.");
        }

        List<GrantedAuthority> authorities=new ArrayList<>();
        for (Role role:userInformation.get().getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return User.withUsername(userInformation.get().getUsername())
                .password(userInformation.get().getPassword())
                .authorities(authorities)
                .build();
    }
}
