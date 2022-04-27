package top.ppnt.modules.arcsoft.face;

import com.jfinal.server.undertow.UndertowConfig;
import com.jfinal.server.undertow.UndertowServer;
import com.litongjava.utils.ip.IpUtils;

import top.ppnt.jfinal.commons.web.constants.PpntJfinalWebConstants;
import top.ppnt.jfinal.swaager.api.constants.PpntSwaggerConstants;
import top.ppnt.modules.arcsoft.face.config.FaceServerAppConfig;
import top.ppnt.modules.asrsoft.face.constancts.PpntArcSoftFaceConstants;

public class FaceServerApplication {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    UndertowServer undertowServer = UndertowServer.create(FaceServerAppConfig.class);
    //添加SwapClassPrefix,开发环境扫描 jar 包中的路由 
    undertowServer.addHotSwapClassPrefix(PpntSwaggerConstants.PACKAGE_NAME);
    undertowServer.addHotSwapClassPrefix(PpntJfinalWebConstants.PACKAGE_NAME);
    undertowServer.addHotSwapClassPrefix(PpntArcSoftFaceConstants.PACKAGE_NAME);
    //启动服务
    undertowServer.start();
    UndertowConfig undertowConfig = undertowServer.getUndertowConfig();
    int port = undertowConfig.getPort();
    String contextPath = undertowConfig.getContextPath();
    long end = System.currentTimeMillis();
    IpUtils.getThisUrl(port, contextPath);
    System.out.println("启动完成,共使用了" + (end - start) + "ms");
  }
}