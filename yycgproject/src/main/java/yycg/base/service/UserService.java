package yycg.base.service;

import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;

import java.util.List;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public interface UserService
{
  //依据 ID 查询信息

  public Sysuser findSysuserById(String id) throws Exception;
  public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception;
}



