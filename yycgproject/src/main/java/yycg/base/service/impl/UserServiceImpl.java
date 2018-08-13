package yycg.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yycg.base.dao.mapper.SysuserMapper;
import yycg.base.pojo.po.Sysuser;
import yycg.base.service.UserService;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public class UserServiceImpl implements UserService
{
  //注入  mapper
  @Autowired
  private SysuserMapper sysuserMapper;


  @Override
  public Sysuser findSysuserById(String id) throws Exception
  {
    return sysuserMapper.selectByPrimaryKey(id);
  }
}
