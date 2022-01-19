package Cybersoft.javabackend.girajava14taithan.commo.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder
				.getContext()
				.getAuthentication();
		
		if (auth == null) {
			return Optional.ofNullable("");
		}
		
		Object principal = auth.getPrincipal();
		
		if (principal instanceof UserDetails) {
			UserDetails user = (UserDetails)principal;
			return Optional.ofNullable(user.getUsername());
		} else {
			return Optional.ofNullable(principal.toString());
		}
	}

}
