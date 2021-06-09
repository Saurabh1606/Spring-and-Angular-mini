package in.nareshit.saurabh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.nareshit.saurabh.model.User;
import in.nareshit.saurabh.model.UserDetailsImpl;
import in.nareshit.saurabh.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException 
	{
		//loading model class user object
		User user = repository.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("User not exist" + username));
		//converting into Spring Security User object
		return UserDetailsImpl.build(user);
	}

}
