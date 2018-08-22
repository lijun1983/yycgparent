package yycg.base.service;

import yycg.base.pojo.po.Basicinfo;
import yycg.base.pojo.po.Dictinfo;

import java.util.List;
/**
 *@创建人  lijun
 *@创建时间  2018/8/22 0022 上午 11:41
 *@描述  系统级别service   数据字典
 *@修改人和其它信息
 *@当前包名 yycg.base.service
 *@本类名称 SystemConfigService
 *@参数  
 *@对像函数方法体的封装 function
 *@返回值  
 */
public interface SystemConfigService {

	/**
	 * 根据typecode获取数据字典的信息
	 *@当前包名 yycg.base.service 
	 *@本类名称 SystemConfigService 
	 *@参数  String typecode
	 * 
	 *@返回值    List
	 */
	public List findDictinfoByType(String typecode) throws Exception;
	/**
	 * 根据数据字典中的typecode，和dictcode获取一条信息
	 *@当前包名 yycg.base.service 
	 *@本类名称 SystemConfigService 
	 *@参数 String typecode, String dictcode
	 * 
	 *@返回值    Dictinfo
	 */
	public Dictinfo findDictinfoByDictcode(String typecode, String dictcode) throws Exception;
	/**
	 * 根据系统参数id获取系统参数表信息
	 *@当前包名 yycg.base.service 
	 *@本类名称 SystemConfigService 
	 *@参数 (String id
	 * 
	 *@返回值    Basicinfo
	 */
	public Basicinfo findBasicinfoById(String id)throws Exception;
}
