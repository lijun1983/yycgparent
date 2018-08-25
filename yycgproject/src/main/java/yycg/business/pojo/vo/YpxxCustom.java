package yycg.business.pojo.vo;

import yycg.business.pojo.po.Ypxx;
/**
 *@创建人  lijun
 *@创建时间  2018/8/26 0026 上午 12:18
 *@描述  TODO: 扩展类
 *@修改人和其它信息
 *@当前包名 yycg.business.pojo.vo
 *@本类名称 YpxxCustom
 *@param  
 *@对像函数方法体的封装 function
 * TODO:   
 *@返回值  
 */
public class YpxxCustom extends Ypxx
{
	
	//TODO:交易状态名称
	private String jyztmc;	 //yycg/business/dao/mapper/YpxxMapperCustom.xml:17  行

	public String getJyztmc() {
		return jyztmc;
	}

	public void setJyztmc(String jyztmc) {
		this.jyztmc = jyztmc;
	}
	
	
}
