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
	//Alt+ lnsert 快键
	//TODO:开始价格，查询条件
	private Float price_start;

	//TODO:结束价格，查询条件
	private Float price_end;

	//TODO:交易状态名称
	private String jyztmc;	 //yycg/business/dao/mapper/YpxxMapperCustom.xml:17  行

	public String getJyztmc() {
		return jyztmc;
	}

	public void setJyztmc(String jyztmc) {
		this.jyztmc = jyztmc;
	}

	public Float getPrice_start()
	{
		return price_start;
	}

	public void setPrice_start(Float price_start)
	{
		this.price_start = price_start;
	}

	public Float getPrice_end()
	{
		return price_end;
	}

	public void setPrice_end(Float price_end)
	{
		this.price_end = price_end;
	}
}
