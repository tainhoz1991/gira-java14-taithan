package Cybersoft.javabackend.girajava14taithan.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;
import Cybersoft.javabackend.girajava14taithan.security.dto.CustomUserDetails;
import Cybersoft.javabackend.girajava14taithan.user.model.User;
import Cybersoft.javabackend.girajava14taithan.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOpt = repository.findByUsername(username);
		if (!userOpt.isPresent()) {
			throw new UsernameNotFoundException("Username is not existed");
		}
		User currentUser = userOpt.get();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); // tao danh sach quyen
		authorities.addAll(getAuthorities(currentUser));
		
		return new CustomUserDetails(currentUser.getUsername(), currentUser.getPassword(), authorities);
	}
	
	// lay danh sach ten nhom quyen ma user thuoc
	private List<? extends GrantedAuthority> getAuthorities(final User currentUser) { // final de khong duoc thay doi
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (GroupRole group: currentUser.getGroups()) {
			authorities.add(new SimpleGrantedAuthority(group.getName()));
		}
		return authorities;
	}

}
