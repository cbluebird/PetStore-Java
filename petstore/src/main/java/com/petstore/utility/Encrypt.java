package com.petstore.utility;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class Encrypt {
    public String sha256(String password){
        return DigestUtils.sha256Hex(password);
    }
}
