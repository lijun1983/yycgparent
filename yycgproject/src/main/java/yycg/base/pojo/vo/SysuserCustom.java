package yycg.base.pojo.vo;

import yycg.base.pojo.po.Sysuser;

/**
 * @Version : 1.0
 * @ClassName :本类名称 SysuserCustom
 * @Auther : 创建人 Lijun
 * @Date : 创建时间 2018/8/19 0019 19:17
 * @Description: 描述 null
 * @TODO : 标注注释 null
 * Created by IntelliJ IDEA
 */
public class SysuserCustom extends Sysuser
{
  //单位名称
  private String sysmc;

  public String getSysmc()
  {
    return sysmc;
  }

  public void setSysmc(String sysmc)
  {
    this.sysmc = sysmc;
  }
}
