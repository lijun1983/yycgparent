package yycg.business.dao.mapper;

import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YpxxQueryVo;

import java.util.List;
/**
 *@创建人  lijun
 *@创建时间  2018/8/26 0026 上午 12:26
 *@描述
 *@修改人和其它信息
 *@当前包名 yycg.business.dao.mapper
 *@本类名称 YpxxMapperCustom
 *@param  
 *@对像函数方法体的封装 function
 * TODO:   自定义 Mapper
 *@返回值  
 */
public interface YpxxMapperCustom
{
    //药品目录 查询
  
	public List<YpxxCustom> findYpxxList(YpxxQueryVo ypxxQueryVo) throws Exception;
}