关联查询
SELECT  ID,BM,MC,JX,GG,ZHXS,SCQYMC,SPMC,ZBJG,JYZT, (SELECT INFO FROM DICTINFO WHERE YPXX.JYZT = DICTCODE AND TYPECODE='003') jyztmc FROM YPXX