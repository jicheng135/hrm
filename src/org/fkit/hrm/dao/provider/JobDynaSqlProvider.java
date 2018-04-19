package org.fkit.hrm.dao.provider;

import static org.fkit.hrm.util.common.HrmConstants.JOBTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Job;;

/**   
 * @Description: 职位动态SQL语句提供类
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @date 2016年7月11日 上午11:19:23 
 * @version V1.0   
 */
public class JobDynaSqlProvider {
	
	public String selectWithParam(final Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(JOBTABLE);
				if(params.get("job")!=null){
					Job job = (Job) params.get("job");
					if(job.getName()!=null && !job.getName().equals("")){
						WHERE(" name like concat('%',#{name},'%') ");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel")!=null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		return sql;
	}
	
	public String count(final Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("count(*)");
				FROM(JOBTABLE);
				if(params.get("job")!=null){
					Job job = (Job) params.get("job");
					if(job.getName()!=null && !job.getName().equals("")){
						WHERE(" name like concat('%',#{name},'%') ");
					}
				}
			}
		}.toString();
		
		return sql;
	}
	
	public String insertJob(final Job job){
		String sql = new SQL(){
			{
				INSERT_INTO(JOBTABLE);
				if(job.getName()!=null && !job.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(job.getRemark()!=null && !job.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
		return sql;
	}
	
	public String updateJob(final Job job){
		String sql = new SQL(){
			{
				UPDATE(JOBTABLE);
				if(job.getName()!=null && !job.getName().equals("")){
					SET("name=#{name}");
				}
				if(job.getRemark()!=null && !job.getRemark().equals("")){
					SET("remark=#{remark}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
		return sql;
	}
	
}
