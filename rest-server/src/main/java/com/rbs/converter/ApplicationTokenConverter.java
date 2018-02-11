package com.rbs.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.rbs.repository.UserRepository;

/**
 * Allows to add other details to the response aside from
 * the token, token expiry, scope etc.
 *
 * @author rburawes
 */
@Component
public class ApplicationTokenConverter extends JwtAccessTokenConverter {

    @Autowired
    private UserRepository userRepository;

    @Value("${security.signing-key}")
    private String signingKey;

    @PostConstruct
    public void init(){
        this.setSigningKey(signingKey);
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        final Map<String, Object> additionalInfo = new HashMap<>();
        User user = (User) authentication.getPrincipal();
        com.rbs.entity.User loggedUser = userRepository.findByUsername(user.getUsername());
        additionalInfo.put("id", loggedUser.getId());
        additionalInfo.put("username", loggedUser.getUsername());
        additionalInfo.put("password", loggedUser.getPassword());
        additionalInfo.put("firstName", loggedUser.getFirstName());
        additionalInfo.put("lastName", loggedUser.getLastName());
        additionalInfo.put("isAdmin", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).contains("ADMIN_ACCOUNT"));
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        return super.enhance(accessToken, authentication);
    }
}
