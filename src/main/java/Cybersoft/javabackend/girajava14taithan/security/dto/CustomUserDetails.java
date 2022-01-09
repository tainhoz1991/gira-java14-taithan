package Cybersoft.javabackend.girajava14taithan.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails{

	public CustomUserDetails(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) { // tham so t3: la danh sach cac quyen
		super(username, password, authorities);
	}

}
