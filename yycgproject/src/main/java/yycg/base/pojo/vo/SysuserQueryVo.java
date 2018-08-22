package yycg.base.pojo.vo;
/**
 *@创建人  lijun
 *@创建时间  2018/8/22 0022 下午 12:33
 *@描述  包装类，用于页面向action传递参数，将数据传到mybatis
 *@修改人和其它信息
 *@当前包名 yycg.base.pojo.vo
 *@本类名称 SysuserQueryVo
 *@参数   pageQuery, sysuserCustom
 *@对像函数方法体的封装 function
 *@返回值  
 */
public class SysuserQueryVo {
	
	//分页参数
	private PageQuery pageQuery;
	//用户的查询条件
	private SysuserCustom sysuserCustom;
	//可以扩展多个属性
	//....

	public SysuserCustom getSysuserCustom() {
		return sysuserCustom;
	}

	public void setSysuserCustom(SysuserCustom sysuserCustom) {
		this.sysuserCustom = sysuserCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}
	
	

}
