package com.example.smartmedicalsystem.service.impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.example.smartmedicalsystem.service.QRService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@Service
public class QRServiceImpl implements QRService{
    //注入配置依赖
    @Resource
    QrConfig config;
    @Override
    public void generatorQRCode(Long userid, HttpServletResponse response) throws IOException {
        //设置当前通行码的背景颜色
        config.setBackColor(Color.green.getRGB());
        //使用工具生成
        QrCodeUtil.generate(userid+"",config,"png",response.getOutputStream());
    }
}
