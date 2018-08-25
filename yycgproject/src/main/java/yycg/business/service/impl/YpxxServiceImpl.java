package yycg.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yycg.business.dao.mapper.YpxxMapperCustom;
import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YpxxQueryVo;
import yycg.business.service.YpxxService;

import java.util.List;

public class YpxxServiceImpl implements YpxxService
{
	
	@Autowired
	private YpxxMapperCustom ypxxMapperCustom;
/**
 *@创建人  lijun
 *@创建时间  2018/8/26 0026 上午 12:22
 *@描述
 *@修改人和其它信息
 *@当前包名 yycg.business.service.impl
 *@本类名称 YpxxServiceImpl
 *@param  
 *@对像函数方法体的封装 function
 * TODO: 药品 导出 类
 *@返回值  
 */
	@Override
	public List<YpxxCustom> findYpxxList(YpxxQueryVo ypxxQueryVo)
			throws Exception {
		return ypxxMapperCustom.findYpxxList(ypxxQueryVo);
	}

}
