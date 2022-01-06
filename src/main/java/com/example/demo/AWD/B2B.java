package com.example.demo.AWD;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class B2B {
    private static final String seperator= ":";
    private static final String Algorithm = "HmacSHA512";
    private static final String secretKey = "AWDSecretKey";

    public static String sign(final String ID, final Date time) throws Exception{

        final String message = Long.toString( time.getTime())+seperator+ID;
        final Mac hmac = Mac.getInstance(Algorithm);
        final SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), Algorithm);
        hmac.init(secret_key);

        byte[] macData = hmac.doFinal(message.getBytes());
        final String hash = new String(Base64.getEncoder().encodeToString(macData));
        return hash+seperator+message;
    }

    protected static String SignWithSecret(final String secret, final String ID, final Date time) throws Exception{

        final String message = Long.toString( time.getTime())+seperator+ID;
        final Mac hmac = Mac.getInstance(Algorithm);
        final SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), Algorithm);
        hmac.init(secret_key);

        byte[] macData = hmac.doFinal(message.getBytes());
        final String hash = new String(Base64.getEncoder().encodeToString(macData));
        return hash+seperator+message;
    }

}
