package com.yxn.BePlayer.view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFont {
    private Font definedFont = null;

    public Font getDefinedFont(float fs) {
        String fonturllocal = "src\\main\\java\\com\\yxn\\BePlayer\\image\\my-face.otf";

        if (definedFont == null) {
            InputStream is = null;
            BufferedInputStream bis = null;
            try {
                is = new FileInputStream(new File(fonturllocal));
                bis = new BufferedInputStream(is);
                definedFont = Font.createFont(Font.TRUETYPE_FONT, is);
                //设置字体大小，float型
                definedFont = definedFont.deriveFont(fs);
            } catch (FontFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != bis) {
                        bis.close();
                    }
                    if (null != is) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return definedFont;
    }
}