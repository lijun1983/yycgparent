package yycg.base.pojo.vo;

import yycg.base.pojo.po.Sysuser;

/**
 * 
 * <p>Title: SysuserCustom  扩展类 </p>
 * <p>Description: 扩展类，用于提交信息、查询条件</p>
 * <p>Company: www.itcast.com</p> 
 * @author
 * @date	2014年11月26日上午10:38:43
 * @version 1.0
 */
/**
 *@创建人  lijun
 *@创建时间  2018/8/22 0022 下午 12:34
 *@描述 SysuserCustom  扩展类
 *@修改人和其它信息 扩展类，用于提交信息、查询条件
 *@当前包名 yycg.base.pojo.vo
 *@本类名称 SysuserCustom
 *@参数   TODO: 注意 ；这里的属性 sysmc groupname  是在 yycg/base/dao/mapper/SysuserMapperCustom.xml 定义的
 *@对像函数方法体的封装 function
 *@返回值  
 */
public class SysuserCustom extends Sysuser
{
	//
	//单位名称 
	private String sysmc;
	//用户类型名称
	private String groupname;



	public String getSysmc() {
		return sysmc;
	}

	public void setSysmc(String sysmc) {
		this.sysmc = sysmc;
	}

	public String getGroupname()
	{
		return groupname;
	}

	public void setGroupname(String groupname)
	{
		this.groupname = groupname;
	}
}
