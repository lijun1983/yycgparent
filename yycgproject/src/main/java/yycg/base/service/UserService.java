package yycg.base.service;

import org.apache.ibatis.annotations.Param;
import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.Useryy;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;

import java.util.List;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public interface UserService
{
  //=====================插件数据
  //依据 ID 查询信息
  public Sysuser findSysuserById(String id) throws Exception;

  //查询用户列表
  public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception;

  // 根据条件查询列表的总数
  public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception;

  //=====================插件数据
  //1.根据账号查询用户方法
  public Sysuser findSysuserByUserid(String userId) throws Exception;
  //2.根据单位名称 查询单位信息
  public Userjd findUserjdByMc(String mc) throws Exception;
  //3.?
  public Useryy findUseryyByMc(String mc) throws Exception;
  //4.?
  public Usergys findUsergysByMc(String mc) throws Exception;
  //5.添加系统用户
  public void insertSysuser(@Param("sysuserCustom") SysuserCustom sysuserCustom) throws Exception;


}

