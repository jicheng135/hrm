package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.jdbc.SQL;
import org.apache.jasper.tagplugins.jstl.core.Set;
import org.fkit.hrm.domain.Dept;

import com.mysql.fabric.xmlrpc.base.Value;

import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;

/**   
 * @Description: 部门动态SQL语句提供类
 * @version V1.0   
 */
public class DeptDynaSqlProvider {
	// 分页动态查询
	public String selectWithParam(final Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(DEPTTABLE);
				if(params.get("dept")!=null){
					Dept dept = (Dept) params.get("dept");
					if(dept.getName()!=null && ! dept.getName().equals("")){
						WHERE(" name like concat ('%',#{dept.name},'%')");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel")!=null){
			sql += " limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
		}
		return sql;
	}
	
	// 动态查询总数量
	public String count(final Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("count(*)");
				FROM(DEPTTABLE);
				if(params.get("dept")!=null){
					Dept dept = (Dept) params.get("dept");
					if(dept.getName()!=null && ! dept.getName().equals("")){
						WHERE(" name like concat ('%',#{dept.name},'%')");
					}
				}
			}
		}.toString();
		return sql;
	}
	
	// 动态插入
	public String insertDept(final Dept dept){
		String sql = new SQL(){
			{
				INSERT_INTO(DEPTTABLE);
				if(dept.getName()!=null && !dept.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(dept.getRemark()!=null && !dept.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
		return sql;
	}
	// 动态更新
	public String updateDept(final Dept dept){
		String sql = new SQL(){
			{
				UPDATE(DEPTTABLE);
				if(dept.getName()!=null && !dept.getName().equals("")){
					SET("name = #{name}");
				}
				if(dept.getRemark()!=null && !dept.getRemark().equals("")){
					SET("remark = #{remark}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
		return sql;
	}

}
