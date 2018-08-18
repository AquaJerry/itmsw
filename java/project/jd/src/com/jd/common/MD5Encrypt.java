/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.common;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/** Encryptor for Jingdong/Joybuy user register/login. */
public class MD5Encrypt {
  private static final int LEN_SALT = 12;

  /**
   * Encrypt password by MD5 message-digest algorithm.
   *
   * @param password the password
   * @return a byte array including password to be saved in the database
   */
  public static byte[] encryptByMD5(String password) {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    byte[] salt = new byte[LEN_SALT];
    new SecureRandom().nextBytes(salt);
    md.update(salt);
    md.update(password.getBytes());
    return ByteBuffer.allocate(16 + LEN_SALT).put(salt).put(md.digest()).array();
  }
}
