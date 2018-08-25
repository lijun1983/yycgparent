package yycg.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yycg.base.dao.mapper.BasicinfoMapper;
import yycg.base.dao.mapper.DictinfoMapper;
import yycg.base.pojo.po.Basicinfo;
import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.po.DictinfoExample;
import yycg.base.service.SystemConfigService;

import java.util.List;
/**
 *@创建人  lijun
 *@创建时间  2018/8/24 0024 下午 6:36
 *@描述   数据字典
 *@修改人和其它信息
 *@当前包名 yycg.base.service.impl
 *@本类名称 SystemConfigServiceImpl
 *@参数  
 *@对像函数方法体的封装 function
 *@返回值  
 */

public class SystemConfigServiceImpl  implements SystemConfigService
{

	@Autowired
  DictinfoMapper dictinfoMapper;
	@Autowired
  BasicinfoMapper basicinfoMapper;
	//根据数据字典typecode获取字典明细信息
	@Override
	public List findDictinfoByType(String typecode) throws Exception {

		DictinfoExample dictinfoExample = new DictinfoExample();
		DictinfoExample.Criteria criteria = dictinfoExample.createCriteria();
		
		criteria.andTypecodeEqualTo(typecode);
		
		return dictinfoMapper.selectByExample(dictinfoExample);
		
	}
	//根据typeocde和dictcode获取单个字典明细
	public Dictinfo findDictinfoByDictcode(String typecode, String dictcode) throws Exception{
		DictinfoExample dictinfoExample = new DictinfoExample();
		DictinfoExample.Criteria criteria = dictinfoExample.createCriteria();
		criteria.andDictcodeEqualTo(dictcode);
		criteria.andTypecodeEqualTo(typecode);
		List<Dictinfo> list = dictinfoMapper.selectByExample(dictinfoExample);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
		
	}
	/**
	 * 根据id获取系统配置信息
	 */
	@Override
	public Basicinfo findBasicinfoById(String id) throws Exception {
		return basicinfoMapper.selectByPrimaryKey(id);
	}

}
