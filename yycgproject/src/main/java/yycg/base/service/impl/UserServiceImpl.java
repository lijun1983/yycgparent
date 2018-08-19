package yycg.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yycg.base.dao.mapper.SysuserMapper;
import yycg.base.dao.mapper.SysuserMapperCustom;
import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public class UserServiceImpl implements UserService
{
  //注入  mapper
  @Autowired
  private SysuserMapper sysuserMapper;

  @Autowired
  private SysuserMapperCustom sysuserMapperCustom;

  @Override
  public Sysuser findSysuserById(String id) throws Exception
  {
    /**

     *@描述

     *@参数  [id]

     *@返回值  yycg.base.pojo.po.Sysuser

     *@创建人  lijun

     *@创建时间  2018/8/18 0018

     *@修改人和其它信息

     */
    return sysuserMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception
  {
    /**

     *@描述

     *@参数  [sysuserQueryVo]

     *@返回值  java.util.List<yycg.base.pojo.vo.SysuserCustom>

     *@创建人  lijun

     *@创建时间  2018/8/19 0019

     *@修改人和其它信息

     */
     return sysuserMapperCustom.findSysuserList(sysuserQueryVo);
  }


}
