package yycg.business.pojo.vo;

/**
 * @Version : 1.0
 * @ClassName :本类名称 GysypmlCustom
 * @Auther : 创建人 Lijun
 * @Date : 创建时间 2018/8/26 0026 14:40
 * @Description: 描述 null
 * @TODO : 标注注释 null
 * Created by IntelliJ IDEA
 */
public class GysypmlCustom extends YpxxCustom{
  //控制状态名称
  private String gysypmlid;
  private String ypxxid;
  private String usergysid;
  private String usergysmc;
  private String controlmc;
  private String control;

  public String getGysypmlid()
  {
    return gysypmlid;
  }

  public void setGysypmlid(String gysypmlid)
  {
    this.gysypmlid = gysypmlid;
  }

  public String getYpxxid()
  {
    return ypxxid;
  }

  public void setYpxxid(String ypxxid)
  {
    this.ypxxid = ypxxid;
  }

  public String getUsergysid()
  {
    return usergysid;
  }

  public void setUsergysid(String usergysid)
  {
    this.usergysid = usergysid;
  }

  public String getUsergysmc()
  {
    return usergysmc;
  }

  public void setUsergysmc(String usergysmc)
  {
    this.usergysmc = usergysmc;
  }

  public String getControlmc()
  {
    return controlmc;
  }

  public void setControlmc(String controlmc)
  {
    this.controlmc = controlmc;
  }

  public String getControl()
  {
    return control;
  }

  public void setControl(String control)
  {
    this.control = control;
  }
}
