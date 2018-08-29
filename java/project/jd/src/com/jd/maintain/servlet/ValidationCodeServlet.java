/* Copyright (c) 2018, https://github.com/AquaJerry/itmsw. ISC License. */

package com.jd.maintain.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation for validation code on Jingdong/Joybuy register page. */
@WebServlet("/maintain/ValidationCodeServlet")
public class ValidationCodeServlet extends HttpServlet {

  /* The charset for validation code. */
  private static final String CHARSET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final int CHARSET_SIZE = CHARSET.length();

  /* The random number generator. */
  private static final Random RANDOM = new Random();

  /**
   * Create a 4-bit random validation code.
   *
   * @return the validation code
   */
  public static String createValidationCode() {
    String validationCode = "";
    int index;
    for (int i = 0; i < 4; ++i) {
      index = RANDOM.nextInt(CHARSET_SIZE);
      validationCode += CHARSET.charAt(index);
    }
    return validationCode;
  }

  /**
   * Draw validation code.
   *
   * @param image the background image of validation code
   * @param validationCode a string of validation code
   */
  public static void drawValidationCode(BufferedImage image, String validationCode) {
    Graphics graphics = image.getGraphics();
    graphics.setFont(new Font("MicrosoftYahei", Font.PLAIN, /*size*/ 25));
    graphics.setColor(new Color(/*rgb*/ 0xffffff));
    String validationChar;
    int x, y;
    for (int i = 0, l = validationCode.length(); i < l; ++i) {
      validationChar = validationCode.substring(i, i + 1);
      x = 12 * (i + 1);
      y = 25 + RANDOM.nextInt(8);
      graphics.drawString(validationChar, x, y);
    }
  }

  /**
   * Send an image of validation code to the register page.
   *
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    /* Read request. */
    ServletContext context = request.getServletContext();

    /* Create image. */
    String path = context.getRealPath("common/images/") + "jd_bg_validation-code.png";
    File input = new File(path);
    BufferedImage image = ImageIO.read(input);

    /* Process image. */
    String validationCode = createValidationCode();
    drawValidationCode(image, validationCode);

    /* Write response. */
    response.setContentType("image/png");
    OutputStream out = response.getOutputStream();
    ImageIO.write(image, "png", out);
    out.close();
  }

  /**
   * Do as the same as {@link #doGet doGet}.
   *
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
