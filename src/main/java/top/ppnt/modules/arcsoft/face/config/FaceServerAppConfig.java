package top.ppnt.modules.arcsoft.face.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

import top.ppnt.jfinal.commons.web.constants.PpntJfinalWebConstants;
import top.ppnt.jfinal.swaager.api.config.SwaggerRoutes;
import top.ppnt.modules.asrsoft.face.constancts.PpntArcSoftFaceConstants;

public class FaceServerAppConfig extends JFinalConfig {

  public void configConstant(Constants me) {
    me.setDevMode(true);
    me.setInjectDependency(true);
    me.setInjectSuperClass(true);
  }

  public void configRoute(Routes me) {
    me.setMappingSuperClass(true);
    // 配置Swagger UI访问路由
    me.add(new SwaggerRoutes());
    //ppnt-jfinal-web中的controller
    me.scan(PpntJfinalWebConstants.CONTROLLER_PACKAGE_NAME);
    //
    me.scan(PpntArcSoftFaceConstants.PACKAGE_NAME);
  }

  @Override
  public void configEngine(Engine me) {
  }

  @Override
  public void configPlugin(Plugins me) {
  }

  @Override
  public void configInterceptor(Interceptors me) {
  }

  @Override
  public void configHandler(Handlers me) {
  }
}