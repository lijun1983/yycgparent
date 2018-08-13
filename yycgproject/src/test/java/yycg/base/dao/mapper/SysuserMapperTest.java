package yycg.base.dao.mapper;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.po.SysuserExample;
import yycg.util.UUIDBuild;

import java.util.List;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public class SysuserMapperTest extends TestCase
{
  private ApplicationContext applicationContext;
  private SysuserMapper sysuserMapper;




  public void setUp() throws Exception
  {
    applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml","spring/applicationContext-base-dao.xml"});
    sysuserMapper = (SysuserMapper) applicationContext.getBean("sysuserMapper");
  }



  public void testInsert() throws Exception
  {
    //1.TODO:插入信息
      Sysuser sysuser = new Sysuser();
      sysuser.setId(UUIDBuild.getUUID());
      sysuser.setUserid("");
      sysuser.setUsername("");
      sysuserMapper.insert(sysuser);
  }



  public void testSelectByExample() throws Exception
  {
    SysuserExample sysuserExample = new SysuserExample();
    SysuserExample.Criteria criteria = sysuserExample.createCriteria();
    //2.TODO:自定义字段(关键字)查询条件
    criteria.andUsernameEqualTo("城关乡西史村卫生室");
    criteria.andGroupidEqualTo("3");
    List<Sysuser> list = sysuserMapper.selectByExample(sysuserExample);
    System.out.println(list.get(0));
  }

  public void testSelectByPrimaryKey() throws Exception
  {
    Sysuser sysuser = sysuserMapper.selectByPrimaryKey("92");//3.TODO:依主键查记录
    System.out.println(sysuser);

  }


   //4.TODO:依据主键更新  传入po类的属性不为空，才更新；
  public void testUpdateByPrimaryKeySelective() throws Exception
  {
    Sysuser sysuser = new Sysuser();
    sysuser.setId("92");
    sysuser.setUsername("009999999999");
     sysuserMapper.updateByPrimaryKeySelective(sysuser);
  }
  //5.TODO:依据主键更新    不管传入po类的属性是否为空，都更新；
  public void testUpdateByPrimaryKey() throws Exception
  {
    Sysuser sysuser = sysuserMapper.selectByPrimaryKey("92");
    sysuser.setUsername("不管传入po类的属性是否为空，都更新");
    sysuserMapper.updateByPrimaryKey(sysuser);

  }

}