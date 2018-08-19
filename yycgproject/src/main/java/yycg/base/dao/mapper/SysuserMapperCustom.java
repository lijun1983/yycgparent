package yycg.base.dao.mapper;

import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;

import java.util.List;

/**
 * @Version : 1.0
 * @ClassName :本类名称 SysuserMapperCustom
 * @Auther : 创建人 Lijun
 * @Date : 创建时间 2018/8/19 0019 18:51
 * @Description: 描述 null
 * @TODO : 标注注释 null
 * Created by IntelliJ IDEA
 */
public interface SysuserMapperCustom
{
  //查询用户列表

  public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception;




  //查询总数
}
