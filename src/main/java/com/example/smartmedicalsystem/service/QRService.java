package com.example.smartmedicalsystem.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface QRService {
    //根据用户id生成二维码
    void generatorQRCode(Long userid, HttpServletResponse response) throws IOException;
}
