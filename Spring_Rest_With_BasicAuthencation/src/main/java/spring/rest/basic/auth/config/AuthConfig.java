package main.java.spring.rest.basic.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Configuration
public class AuthConfig{

	  @Bean
	  UserDetailsService userDetailsService() {
	    return new UserDetailsService() {

	      @Override
	      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	        if(username.equals("admin")) {
	        return new User("admin", "$2a$04$LVUFP/pVM49ZK1kU/nUJCuHfyII7x1Ika1QC8L0Y/jByEbjjeb4VC", true, true, true, true,
	                AuthorityUtils.createAuthorityList("USER"));
	        } else {
	          throw new UsernameNotFoundException("could not find the user '"
	                  + username + "'");
	        }
	      }
	      
	    };
	  }
}
