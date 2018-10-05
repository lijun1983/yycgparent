package yycg.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yycg.base.process.context.Config;
import yycg.base.process.result.ResultUtil;
import yycg.base.service.SystemConfigService;
import yycg.business.dao.mapper.GysypmlControlMapper;
import yycg.business.dao.mapper.GysypmlMapper;
import yycg.business.dao.mapper.GysypmlMapperCustom;
import yycg.business.dao.mapper.YpxxMapper;
import yycg.business.pojo.po.*;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;
import yycg.business.service.YpmlService;
import yycg.util.UUIDBuild;

import java.util.List;

/**
 * @Version : 1.0
 * @ClassName :本类名称 YpmlServiceImpl
 * @Auther : 创建人 Lijun
 * @Date : 创建时间 2018/8/26 0026 16:56
 * @Description: 描述 null
 * @TODO : 标注注释 null
 * Created by IntelliJ IDEA
 */
public class YpmlServiceImpl implements YpmlService
{
  @Autowired
  private GysypmlMapperCustom gysypmlMapperCustom;

  @Autowired
  private GysypmlMapper gysypmlMapper;

  @Autowired
  private GysypmlControlMapper gysypmlControlMapper;

  @Autowired
  private YpxxMapper ypxxMapper;

  @Autowired
  private SystemConfigService systemConfigService;

  @Override
  public List<GysypmlCustom> findGysypmlList(String usergysId,GysypmlQueryVo gysypmlQueryVo) throws Exception {

    // 非空判断
    gysypmlQueryVo = gysypmlQueryVo != null ? gysypmlQueryVo
        : new GysypmlQueryVo();

    GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
    if (gysypmlCustom == null) {
      gysypmlCustom = new GysypmlCustom();
    }

    // 设置供货商id
    gysypmlCustom.setUsergysid(usergysId);

    gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);

    return gysypmlMapperCustom.findGysypmlList(gysypmlQueryVo);
  }

  @Override
  public int findGysypmlCount(String usergysId, GysypmlQueryVo gysypmlQueryVo) throws Exception {
    // 非空判断
    gysypmlQueryVo = gysypmlQueryVo != null ? gysypmlQueryVo
        : new GysypmlQueryVo();

    GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
    if (gysypmlCustom == null) {
      gysypmlCustom = new GysypmlCustom();
    }

    // 设置供货商id
    gysypmlCustom.setUsergysid(usergysId);

    gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
    return gysypmlMapperCustom.findGysypmlCount(gysypmlQueryVo);
  }

  @Override
  public List<GysypmlCustom> findAddGysypmlList(String usergysId, GysypmlQueryVo gysypmlQueryVo) throws Exception {
    // 非空判断
    gysypmlQueryVo = gysypmlQueryVo != null ? gysypmlQueryVo : new GysypmlQueryVo();

    GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
    if (gysypmlCustom == null) {
      gysypmlCustom = new GysypmlCustom();
    }

    // 设置供货商id
    gysypmlCustom.setUsergysid(usergysId);

    gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
    return gysypmlMapperCustom.findAddGysypmlList(gysypmlQueryVo);
  }

  @Override
  public int findAddGysypmlCount(String usergysId,GysypmlQueryVo gysypmlQueryVo) throws Exception {

    // 非空判断
    gysypmlQueryVo = gysypmlQueryVo != null ? gysypmlQueryVo
        : new GysypmlQueryVo();

    GysypmlCustom gysypmlCustom = gysypmlQueryVo.getGysypmlCustom();
    if (gysypmlCustom == null) {
      gysypmlCustom = new GysypmlCustom();
    }

    // 设置供货商id
    gysypmlCustom.setUsergysid(usergysId);

    gysypmlQueryVo.setGysypmlCustom(gysypmlCustom);
    return gysypmlMapperCustom.findAddGysypmlCount(gysypmlQueryVo);
  }


  // 根据供货商id和药品id查询供货商药品目录
  public Gysypml findGysypmlByUsergysidAndYpxxid(String usergysid,String ypxxid) throws Exception {

    GysypmlExample gysypmlExample = new GysypmlExample();
    GysypmlExample.Criteria criteria = gysypmlExample.createCriteria();
    // 设置查询条件
    criteria.andUsergysidEqualTo(usergysid);
    criteria.andYpxxidEqualTo(ypxxid);

    List<Gysypml> list = gysypmlMapper.selectByExample(gysypmlExample);
    if (list != null && list.size() == 1) {
      return list.get(0);
    }
    return null;

  }

  // 根据供货商id和药品id查询供货商药品目录控制表记录
  public GysypmlControl findGysypmlControlByUsergysidAndYpxxid(String usergysid,String ypxxid) throws Exception {

    GysypmlControlExample gysypmlControlExample = new GysypmlControlExample();
    GysypmlControlExample.Criteria criteria = gysypmlControlExample.createCriteria();
    // 设置查询条件
    criteria.andUsergysidEqualTo(usergysid);
    criteria.andYpxxidEqualTo(ypxxid);

    List<GysypmlControl> list = gysypmlControlMapper.selectByExample(gysypmlControlExample);
    if (list != null && list.size() == 1) {
      return list.get(0);
    }
    return null;

  }
  /**
   *@创建人  lijun
   *@创建时间  2018/8/27 0027 下午 1:14
   *@描述
   *@修改人和其它信息
   *@当前包名 yycg.business.service.impl
   *@本类名称 YpmlServiceImpl
   *@param  usergysid,
   *@param  ypxxid
   *@对像函数方法体的封装 function
   * TODO: 供货商药品目录 批量  添加提交 实现方法
   *@返回值  void
   */
  @Override
  public void insertGysypml(String usergysid, String ypxxid) throws Exception {

    // 只允许添加供货商药品目录中没有的药品
    // TODO: 1 校验方法：先根据供货商id和药品id查询供货商药品目录记录，如果查询到说明已存在
    Gysypml gysypml = this.findGysypmlByUsergysidAndYpxxid(usergysid,ypxxid);//调用本类上面写的方法
    if (gysypml != null) {
      // 说明已存在
      ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 401,null));
    }
    //TODO: 2 根据药品id查询药品信息 药品的交易状态为暂停不允许添加
    Ypxx ypxx = ypxxMapper.selectByPrimaryKey(ypxxid);
    if (ypxx == null) {
      // 系统中找不到系统信息
      // .....
    }
    // TODO: 3 获取 药品交易状态
    String jyzt = ypxx.getJyzt();
    if (jyzt.equals("2")) {
      // 药品状态为暂停不允许添加
      ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 403, new Object[] { ypxx.getBm(), ypxx.getMc()}));
    }
    // TODO: 4 向供货商药品目录表gysypml插入一条记录
    Gysypml gysypml_insert = new Gysypml();
    gysypml_insert.setId(UUIDBuild.getUUID());
    gysypml_insert.setUsergysid(usergysid);
    gysypml_insert.setYpxxid(ypxxid);
    gysypmlMapper.insert(gysypml_insert);//TODO:表gysypml插入一条记录

    // TODO:同时向供货商药品目录控制表gysypml_control插入一条记录
    // TODO: 5 如果控制表已存在供货商药品不用插入 根据供货商id和药品id查询
    GysypmlControl gysypmlControl = this.findGysypmlControlByUsergysidAndYpxxid(usergysid, ypxxid);//调用本类上面写的方法
    if(gysypmlControl==null){

      //TODO: 6 从系统参数配置表 (字典表) 获取控制状态的默认值
      String control = systemConfigService.findBasicinfoById("00101").getValue();

      //执行插入
      GysypmlControl gysypmlControl_insert = new GysypmlControl();
      gysypmlControl_insert.setId(UUIDBuild.getUUID());
      gysypmlControl_insert.setUsergysid(usergysid);
      gysypmlControl_insert.setYpxxid(ypxxid);
      gysypmlControl_insert.setControl(control);//控制状态，采用默认值，默认值从系统参数配置表中获取
      //TODO:7 gysypml_control插入一条记录
      gysypmlControlMapper.insert(gysypmlControl_insert);
    }

  }



}
