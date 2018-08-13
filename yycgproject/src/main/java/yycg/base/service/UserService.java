package yycg.base.service;

import yycg.base.pojo.po.Sysuser;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public interface UserService
{
  //依据 ID 查询信息
  public Sysuser findSysuserById(String id) throws Exception;
}



