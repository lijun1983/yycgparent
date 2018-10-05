package yycg.business.pojo.vo;

import yycg.base.pojo.vo.PageQuery;

import java.util.List;

/**
 * @Version : 1.0
 * @ClassName :本类名称 GysypmlQueryVo
 * @Auther : 创建人 Lijun
 * @Date : 创建时间 2018/8/26 0026 14:46
 * @Description: 描述 null
 * @TODO : 标注注释 null
 * Created by IntelliJ IDEA
 */
public class GysypmlQueryVo
{
  //添加页面批量提交
  private List<YpxxCustom> ypxxCustoms;
  private PageQuery pageQuery;
  //药品查询条件
  private YpxxCustom ypxxCustom; //TODO:注意这里  yycg/business/dao/mapper/GysypmlMapperCustom.xml  <include refid="yycg.business.dao.mapper.YpxxMapperCustom.query_ypxx_where" />
  private GysypmlCustom gysypmlCustom;

  public List<YpxxCustom> getYpxxCustoms()
  {
    return ypxxCustoms;
  }

  public void setYpxxCustoms(List<YpxxCustom> ypxxCustoms)
  {
    this.ypxxCustoms = ypxxCustoms;
  }

  public PageQuery getPageQuery()
  {
    return pageQuery;
  }

  public void setPageQuery(PageQuery pageQuery)
  {
    this.pageQuery = pageQuery;
  }

  public YpxxCustom getYpxxCustom()
  {
    return ypxxCustom;
  }

  public void setYpxxCustom(YpxxCustom ypxxCustom)
  {
    this.ypxxCustom = ypxxCustom;
  }

  public GysypmlCustom getGysypmlCustom()
  {
    return gysypmlCustom;
  }

  public void setGysypmlCustom(GysypmlCustom gysypmlCustom)
  {
    this.gysypmlCustom = gysypmlCustom;
  }
}
