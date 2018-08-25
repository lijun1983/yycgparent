package yycg.business.service;

import yycg.business.pojo.vo.YpxxCustom;
import yycg.business.pojo.vo.YpxxQueryVo;

import java.util.List;

public interface YpxxService
{
	/**
	 * 药品目录 查询
	 *@当前包名 yycg.business.service 
	 *@本类名称 YpxxService 
	 *@参数
	 * 
	 *@返回值   
	 */
	public List<YpxxCustom> findYpxxList(YpxxQueryVo ypxxQueryVo)throws Exception;

}
