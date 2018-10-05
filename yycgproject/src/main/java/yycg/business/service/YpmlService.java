package yycg.business.service;

import yycg.business.pojo.po.Gysypml;
import yycg.business.pojo.po.GysypmlControl;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;

import java.util.List;

/**
 * @Version : 1.0
 * @ClassName :本类名称 YpmlService
 * @Auther : 创建人 Lijun
 * @Date : 创建时间 2018/8/26 0026 16:53
 * @Description: 描述 null
 * @TODO : 标注注释 null
 * Created by IntelliJ IDEA
 */
public interface YpmlService
{
  //供货商药品目录查询列表
  /**
   * 
   *@当前包名 yycg.business.service 
   *@本类名称 YpmlService 
   *@参数  usergysId 供货商 ID
   *@参数   GysypmlQueryVo  包装类 查询条件
   * 
   *@返回值   
   */
  public List<GysypmlCustom> findGysypmlList(String usergysId,GysypmlQueryVo gysypmlQueryVo) throws Exception;

  public int findGysypmlCount(String usergysId,GysypmlQueryVo gysypmlQueryVo) throws Exception;

  //供货商添加药品目录查询列表
  public List<GysypmlCustom> findAddGysypmlList(String usergysId,GysypmlQueryVo gysypmlQueryVo) throws Exception;
  public int findAddGysypmlCount(String usergysId,GysypmlQueryVo gysypmlQueryVo) throws Exception;

  // 供货商药品目录添加
  public void insertGysypml(String usergysid, String ypxxid) throws Exception;

  // 根据供货商id和药品id查询供货商药品目录
  public Gysypml findGysypmlByUsergysidAndYpxxid(String usergysid,String ypxxid) throws Exception;


  // 根据供货商id和药品id查询供货商药品目录控制表记录
  public GysypmlControl findGysypmlControlByUsergysidAndYpxxid(String usergysid, String ypxxid) throws Exception;

}
