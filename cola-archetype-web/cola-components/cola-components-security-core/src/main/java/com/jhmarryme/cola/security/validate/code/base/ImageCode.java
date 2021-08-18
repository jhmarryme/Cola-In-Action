package com.jhmarryme.cola.security.validate.code.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * 图片验证码
 * @author JiaHao Wang
 * @date 2020/11/30 12:29
 */
@Data
@AllArgsConstructor
public class ImageCode extends ValidateCode {

    /**
     * 图片验证码
     */
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

}
