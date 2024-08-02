package com.kerem.userboot.logout;

import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
/*or @Service*/
@Component /*çıkış işlemi için birinci */
public class BlackList {
    private final Set<String> blackListTokenSet = new HashSet<>();

    public void blackListToken(String token){
        blackListTokenSet.add(token);
    }

    public boolean isBlackListed(String token){
        return blackListTokenSet.contains(token);
    }
}
