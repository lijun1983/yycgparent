
供货商药品目录表：gysypml：供货商药品目录控制表：gysypml_control
--内链接查询
--gysypml表中的数据在gysypml_control表中都存在
--通过唯一约束关联查询（只能查询到一条）
--查询记录的条数等于gysypml表的查询记录条数
--因为gysypml表主查询表

--SELECT * FROM GYSYPML, GYSYPML_CONTROL WHERE GYSYPML.YPXXID = GYSYPML_CONTROL.YPXXID AND GYSYPML.USERGYSID = GYSYPML_CONTROL.USERGYSID

--通过子查询
--SELECT GYSYPML.*,(SELECT CONTROL FROM GYSYPML_CONTROL WHERE GYSYPML.YPXXID = GYSYPML_CONTROL.YPXXID AND GYSYPML.USERGYSID = GYSYPML_CONTROL.USERGYSID) CONTROL FROM GYSYPML


--关联查询表：供货商名称（usergys）、供货状态（gysypml_control），药品信息(ypxx)
--SELECT * FROM GYSYPML,USERGYS.MC USERGYSMC WHERE GYSYPML.USERGYSID = USERGYS.ID




--常用Sql查询
--内链接关联查询：
--================================================================================
--如果表A和表B有一个外键关联 ，可以通过外键进行内链接查询
--select dictinfo.*, dicttype.typename from dictinfo, dicttype where dictinfo.typecode = dicttype.typecode


   --不通过外键，通过groupid查询 用户类型的代码结果集，只能查询出一条记录，可以使用内链接
--select sysuser.*, dictinfo.info from sysuser,
--       (select dictcode, typecode, info from dictinfo where typecode = 's01') dictinfo where sysuser.groupid = dictinfo.dictcode



--内链接的错误的例子，通过关联查询出重复记录
--使用groupid从select dictcode, typecode, info from dictinfo可以找到多个记录，不能使用内链接，可能会出现重复记录

--select sysuser.* from sysuser, (select dictcode, typecode, info from dictinfo) dictinfo where sysuser.groupid = dictinfo.dictcode
--================================================================================

--外链接关联查询：
--================================================================================


--表A，表B中只有一部分数据和表A匹配，不能使用内链接。
--主查询是表A，只能使用外链接。

--查询用户所属单位,sysid对应三张表的id

--select sysuser.*,useryy.mc from sysuser left join useryy on sysuser.sysid = useryy.id

--select * from useryy right join sysuser on sysuser.sysid = useryy.id

--以上的需要不能使用内链接
--select sysuser.*,useryy.mc from sysuser, useryy where  sysuser.sysid = useryy.id

--小结：
--表A中从表B中只能关联查询一部分数据，只能使用外链接
