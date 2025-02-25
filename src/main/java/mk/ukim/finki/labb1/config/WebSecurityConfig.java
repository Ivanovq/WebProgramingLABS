package mk.ukim.finki.labb1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .headers((headers)->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .authorizeHttpRequests((requests)->requests.requestMatchers("/", "/events", "/assets/**", "/events/details/{id}", "/h2", "/eventBooking")
                        .permitAll().requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin((form)->form.permitAll().defaultSuccessUrl("/songs",true))
                .logout((logout)->logout.logoutUrl("/logout")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/login")
                );
            return http.build();
    }
    // In Memory Authentication
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("katerina.ivanova")
                .password(passwordEncoder.encode("ki"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        System.out.println("User: " + user.getUsername() + ", Password: " + user.getPassword());

        return new InMemoryUserDetailsManager(user, admin);
    }



}
