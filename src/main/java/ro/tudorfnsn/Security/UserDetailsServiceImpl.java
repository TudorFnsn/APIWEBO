package ro.tudorfnsn.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.tudorfnsn.Model.RoleEntity;
import ro.tudorfnsn.Model.UserEntity;
import ro.tudorfnsn.Repository.RepositoryUser;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private RepositoryUser userRepository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        // we get the user with the specified username
        UserEntity user = userRepository.findByUsername(username);

        // we check if the user exists
        if(user != null)
        {
            // we initialize the granted authorities
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            // we go through the authorities of the user
            for (RoleEntity role : user.getRoles())
            {
                // we add them to the granted authorities
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            // we return the user details
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
        else
        {
            // the username doesn't exist
            throw new UsernameNotFoundException(username);
        }
    }
}