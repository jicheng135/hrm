package org.fkit.hrm.dao;

import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.DeptDynaSqlProvider;
import org.fkit.hrm.domain.Dept;

/**   
 * @Description: DeptMapper接口
 * @version V1.0   
 */
public interface DeptDao {

	// 动态查询
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWithParam")
	List<DeptDao> selectByPage(Map<String,Object> params);
	
	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	Integer count(Map<String,Object> params);
	
	@Select("select * from "+DEPTTABLE+" ")
	List<Dept> selectAllDept();
	
	@Select("select * from "+DEPTTABLE+" where id=#{id}")
	Dept selectById(Integer id);
	
	// 动态插入部门
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	void save(Dept dept);
	
	// 动态修改用户
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	void update(Dept dept);
}
