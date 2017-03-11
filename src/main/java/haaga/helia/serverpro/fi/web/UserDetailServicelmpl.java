package haaga.helia.serverpro.fi.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import haaga.helia.serverpro.fi.domain.User;
import haaga.helia.serverpro.fi.domain.UserRepository;



/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailServicelmpl implements UserDetailsService  {
	private final UserRepository repository;

	@Autowired
	public UserDetailServicelmpl(UserRepository userRepository) {
		this.repository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	User curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 