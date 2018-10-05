package yycg.business.dao.mapper;

import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;

import java.util.List;

public interface GysypmlMapperCustom
{
    //供货商药品目录查询列表
    public List<GysypmlCustom> findGysypmlList(GysypmlQueryVo gysypmlQueryVo) throws Exception;
    public int findGysypmlCount(GysypmlQueryVo gysypmlQueryVo) throws Exception;
    //供货商添加药品目录查询列表
   public List<GysypmlCustom> findAddGysypmlList(GysypmlQueryVo gysypmlQueryVo) throws Exception;
    public int findAddGysypmlCount(GysypmlQueryVo gysypmlQueryVo) throws Exception;
}