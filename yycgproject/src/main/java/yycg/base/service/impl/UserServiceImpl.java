package yycg.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yycg.base.dao.mapper.*;
import yycg.base.pojo.po.*;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultInfo;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.service.UserService;
import yycg.util.UUIDBuild;

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
  private UserjdMapper userjdMapper;
  @Autowired
  private UseryyMapper useryyMapper;
  @Autowired
  private UsergysMapper usergysMapper;
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

     *@修改人和其它信息  dao mapper -》 yycg.base.dao.mapper.SysuserMapperCustom -》 findSysuserList

     */
     return sysuserMapperCustom.findSysuserList(sysuserQueryVo);
  }

  @Override
  public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception {
    /**

     *@描述

     *@参数  [sysuserQueryVo]

     *@返回值  int

     *@创建人  lijun

     *@创建时间  2018/8/20 0020

     *@修改人和其它信息   dao mapper -》 yycg.base.dao.mapper.SysuserMapperCustom -》 findSysuserCount

     */
    return sysuserMapperCustom.findSysuserCount(sysuserQueryVo);
  }
  /**

   *@描述  根据账号查询用户方法

   *@参数  [userId]

   *@返回值  yycg.base.pojo.po.Sysuser

   *@创建人  lijun

   *@创建时间  2018/8/21 0021

   *@修改人和其它信息  用户表

   */
  public Sysuser findSysuserByUserid(String userId) throws Exception{

    SysuserExample sysuserExample = new SysuserExample();
    SysuserExample.Criteria criteria = sysuserExample.createCriteria();

    criteria.andUseridEqualTo(userId);//设置查询条件 END 根据账号查询

    List<Sysuser> list = sysuserMapper.selectByExample(sysuserExample);

    if(list!=null && list.size()==1){
      return list.get(0);
    }
    return null;
  }
  /**

   *@描述 根据单位名称 查询单位信息

   *@参数  [mc]

   *@返回值  yycg.base.pojo.po.Userjd

   *@创建人  lijun

   *@创建时间  2018/8/21 0021

   *@修改人和其它信息  监督单位  表

   */
  public Userjd findUserjdByMc(String mc) throws Exception{


    UserjdExample userjdExample = new UserjdExample();
    UserjdExample.Criteria criteria = userjdExample.createCriteria();

    criteria.andMcEqualTo(mc);//设置查询条件 END 根据账号查询

    List<Userjd> list = userjdMapper.selectByExample(userjdExample);

    if(list!=null && list.size()==1){
      return list.get(0);
    }
    return null;
  }
  /**

   *@描述

   *@参数  [mc]

   *@返回值  yycg.base.pojo.po.Useryy

   *@创建人  lijun

   *@创建时间  2018/8/21 0021

   *@修改人和其它信息 卫生室  Useryy 表

   */
  public Useryy findUseryyByMc(String mc) throws Exception{

    UseryyExample useryyExample = new UseryyExample();
    UseryyExample.Criteria criteria = useryyExample.createCriteria();

    criteria.andMcEqualTo(mc);//设置查询条件 END 根据账号查询

    List<Useryy> list = useryyMapper.selectByExample(useryyExample);

    if(list!=null && list.size()==1){
      return list.get(0);
    }
    return null;
  }
  /**

   *@描述

   *@参数  [mc]

   *@返回值  yycg.base.pojo.po.Usergys

   *@创建人  lijun

   *@创建时间  2018/8/21 0021

   *@修改人和其它信息   供货商 Usergys 表

   */
  public Usergys findUsergysByMc(String mc) throws Exception{

    UsergysExample usergysExample = new UsergysExample();
    UsergysExample.Criteria criteria = usergysExample.createCriteria();

    criteria.andMcEqualTo(mc);//设置查询条件 END 根据账号查询

    List<Usergys> list = usergysMapper.selectByExample(usergysExample);

    if(list!=null && list.size()==1){
      return list.get(0);
    }
    return null;
  }
  /**

   *@描述

   *@参数  [sysuserCustom]

   *@返回值  void

   *@创建人  lijun

   *@创建时间  2018/8/21 0021

   *@修改人和其它信息

   */

  @Override
  public void insertSysuser(SysuserCustom sysuserCustom) throws Exception {

    //参数校验
    //通用的参数合法校验，非空校验，长度校验
    //...使用一些工具类来完成

    //数据业务合法性校验
    //账号唯一性校验，查询数据库校验出来
    //思路：根据用户账号查询sysuser表，如果查询到说明 账号重复
    Sysuser sysuser = this.findSysuserByUserid(sysuserCustom.getUserid());
    if(sysuser!=null){
      //账号重复
      //抛出异常，可预知异常
      //throw new Exception("账号重复");
      //使用系统自定义异常类
      ResultInfo resultInfo = new ResultInfo();
      resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
      resultInfo.setMessage("账号重复");
      throw new ExceptionResultInfo(resultInfo);
    }

    //根据用户类型，输入单位名称必须存在对应的单位表
    String groupid = sysuserCustom.getGroupid();//用户类型
    String sysmc = sysuserCustom.getSysmc();//单位名称
    String sysid = null;//单位id
    if(groupid.equals("1") || groupid.equals("2")){
      //监督单位
      //根据单位名称查询单位信息
      Userjd userjd = this.findUserjdByMc(sysmc);
      if(userjd==null){
        //抛出异常，可预知异常
        throw new Exception("单位名称输入错误");
      }
      sysid = userjd.getId();
    }else if(groupid.equals("3")){
      //卫生室
      //根据单位名称查询单位信息
      Useryy useryy = this.findUseryyByMc(sysmc);
      if(useryy==null){
        //抛出异常，可预知异常
        throw new Exception("单位名称输入错误");
      }
      sysid = useryy.getId();
    }else if(groupid.equals("4")){
      //供货商
      //根据单位名称查询单位信息
      Usergys usergys = this.findUsergysByMc(sysmc);
      if(usergys==null){
        //抛出异常，可预知异常
        throw new Exception("单位名称输入错误");
      }
      sysid = usergys.getId();
    }
    //设置主键
    sysuserCustom.setId(UUIDBuild.getUUID());
    //设置单位id
    sysuserCustom.setSysid(sysid);
    //完成插入记录
    sysuserMapper.insert(sysuserCustom);


  }




}
