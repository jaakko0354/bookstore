package swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import swd20.bookstore.domain.User;
import swd20.bookstore.domain.UserRepository;

@Service
public class UserDetailServiceImplement implements UserDetailsService {
	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImplement(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
					AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}
}
