## 常用数据类型转换
SELECT str_to_date(NOW(),'%Y-%m-%d') AS A_DAY FROM DUAL;
SELECT date_format(NOW(),'%Y-%m-%d') AS TODAY FROM DUAL;
SELECT date_format(NOW(),'%Y-%m-%d %H:%i:%s:%f') AS TODAY FROM DUAL;
SELECT CURRENT_TIMESTAMP() FROM DUAL;
SELECT cast(REPLACE(date_format(NOW(),'%Y-%m-%d'),'-','')as unsigned int) int_date FROM DUAL;
## 常用函数
SELECT DEPTNO,CASE WHEN DEPTNO=10 THEN '部门1' WHEN DEPTNO=20 THEN '部门2' ELSE '部门3' END FROM EMP;
## 分组
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL) > 2000;
SELECT DEPTNO, AVG(SAL) FROM EMP WHERE SAL > 2000 GROUP BY DEPTNO HAVING AVG(SAL) > 3000;
SELECT DEPTNO, SUM(DEPTNO), AVG(SAL) FROM EMP GROUP BY DEPTNO;
## 集合查询操作
SELECT * FROM A;
SELECT * FROM B;
SELECT * FROM A WHERE NAME IN (SELECT NAME FROM B);
SELECT * FROM A WHERE NAME NOT IN (SELECT NAME FROM B);
SELECT * FROM B WHERE NAME NOT IN (SELECT NAME FROM A);
## 子查询
SELECT A.ENAME, A.SAL FROM EMP A WHERE A.DEPTNO= (SELECT B.DEPTNO FROM DEPT B WHERE B.LOC = 'NEW YORK');
SELECT A.DEPTNO, (SELECT B.LOC FROM DEPT B WHERE B.DEPTNO =A.DEPTNO) FROM EMP A;
SELECT * FROM EMP A WHERE EXISTS (SELECT 1 FROM EMP B WHERE B.MGR=A.EMPNO);
SELECT * FROM DEPT D WHERE NOT EXISTS (SELECT 1 FROM EMP E WHERE E.DEPTNO=D.DEPTNO);
## ROWNUM使用
SELECT * FROM EMP LIMIT 5;
SELECT * FROM EMP LIMIT 5,18446744073709551615;
SELECT * FROM (SELECT * FROM EMP ORDER BY SAL DESC) E LIMIT 3;
SELECT * FROM EMP LIMIT 5,5;
