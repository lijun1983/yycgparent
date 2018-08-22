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
  /**
   * 2.用户管理 列表 结果级 绑定返回 json 数据
   *@当前包名 yycg.base.service 
   *@本类名称 UserService 
   *@参数  SysuserQueryVo
   * 
   *@返回值   
   */
  public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception;
  /**
   * 2.1根据条件查询列表的总数
   *@当前包名 yycg.base.service 
   *@本类名称 UserService 
   *@参数  SysuserQueryVo  包装类
   *
   *@返回值    int
   */
  public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception;

  //公用调-1.Sysuser 表 根据账号查询用户方法
  public Sysuser findSysuserByUserid(String userId) throws Exception;
  //公用调-2. 监督单位 Userjd 表 根据 单位 名称 查询单位信息
  public Userjd findUserjdByMc(String mc) throws Exception;
  //公用调-3 卫生室 医院  Useryy 表 根据 卫生室 名称 查询单位信息
  public Useryy findUseryyByMc(String mc) throws Exception;
  //公用调-4 供货商 Usergys 表 根据 供货商 名称 查询单位信息
  public Usergys findUsergysByMc(String mc) throws Exception;
  /**
   * 4.插入数据 返回绑定 json 数据
   *@当前包名 yycg.base.service 
   *@本类名称 UserService 
   *@参数  SysuserCustom    修改表单数据  扩展类
   * 
   *@返回值    void
   */
  public void insertSysuser(@Param("sysuserCustom") SysuserCustom sysuserCustom) throws Exception;
  /**
   * 5.DEL系统用户
   *@当前包名 yycg.base.service 
   *@本类名称 UserService 
   *@参数 String id  id 用户ID,
   * 
   *@返回值   
   */
  public void deleteSysuser(String id) throws Exception;
 /**
 * 6.EDIT  返回  绑定 jsp 修改页面 并查询 系统 单条 用户信息
 *@当前包名 yycg.base.service 
 *@本类名称 UserService 
 *@参数  id
 *@返回值
 */

  public Sysuser findSysuserById(String id) throws Exception;
  /**
   * 
   *@当前包名 yycg.base.service 
   *@本类名称 UserService 
   *@参数  String id  id 用户ID,
   *@参数  SysuserCustom    修改表单数据  扩展类
   *
   *@返回值   void
   */
  public void updateSysuser(String id,@Param("sysuserCustom") SysuserCustom sysuserCustom) throws Exception;




}

