/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.common;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/** Encryptor for Jingdong/Joybuy user register/login. */
public class MD5Encrypt {
  private static final int LEN_SALT = 12;

  // MD5 yields a 16-byte hash.
  private static final int LEN_SALT_HASH = 16 + LEN_SALT;

  private static byte[] encrypt(String password, byte[] salt) {
    byte[] hash = null;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(salt);
      md.update(password.getBytes());
      hash = md.digest();
    } catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return hash;
  }

  /**
   * Encrypt password by MD5 message-digest algorithm. This could be used in user register.
   *
   * @param password the password
   * @return a byte array including that password to be saved in the database
   */
  public static byte[] encryptByMD5(String password) {
    byte[] salt = new byte[LEN_SALT];
    new SecureRandom().nextBytes(salt);
    return ByteBuffer.allocate(LEN_SALT_HASH).put(salt).put(encrypt(password, salt)).array();
  }

  /**
   * Validate if {@code validPassword} includes {@code password}. This could be used in user login.
   *
   * @param password the password
   * @param validPassword the byte array including a valid password from the database
   * @return if the login is successful
   */
  public static boolean validatePassword(String password, byte[] validPassword) {
    byte[] salt = Arrays.copyOfRange(validPassword, 0, LEN_SALT);
    byte[] hash = Arrays.copyOfRange(validPassword, LEN_SALT, LEN_SALT_HASH);
    return Arrays.equals(hash, encrypt(password, salt));
  }
}
