package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Notice;
import static org.fkit.hrm.util.common.HrmConstants.NOTICETABLE;

public class NoticeDynaSqlProvider {
	public String selectWhitParam(final Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(NOTICETABLE);
				if(params.get("notice")!=null){
					Notice notice = (Notice) params.get("notice");
					if(notice.getTitle()!=null && !notice.getTitle().equals("")){
						WHERE(" title like concat('%',#{notice.title},'%') ");
					}
					if(notice.getContent()!=null && !notice.getContent().equals("")){
						WHERE(" content like concat('%',#{notice.content},'%') ");
					}
				}
			}
		}.toString();
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		return sql;
	}
	
	public String count(final Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("count(*)");
				FROM(NOTICETABLE);
				if(params.get("notice")!=null){
					Notice notice = (Notice) params.get("notice");
					if(notice.getTitle()!=null && !notice.getTitle().equals("")){
						WHERE(" title like concat('%',#{notice.title},'%') ");
					}
					if(notice.getContent()!=null && !notice.getContent().equals("")){
						WHERE(" content like concat('%',#{notice.content},'%') ");
					}
				}
			}
		}.toString();
		return sql;
	}
	
	public String insertNotice(final Notice notice){
		String sql = new SQL(){
			{
				INSERT_INTO(NOTICETABLE);
				if(notice.getTitle()!=null && !notice.getTitle().equals("")){
					VALUES("title", "#{title}");
				}
				if (notice.getContent()!=null && !notice.getContent().equals("")) {
					VALUES("content", "#{content}");
				}
				if(notice.getUser()!=null && notice.getUser().getId()!=null){
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
		return sql;
	}
	public String updateNotice(final Notice notice){
		String sql = new SQL(){
			{
				UPDATE(NOTICETABLE);
				if(notice.getTitle()!=null && !notice.getTitle().equals("")){
					SET(" title = #{title} ");
				}
				if (notice.getContent()!=null && !notice.getContent().equals("")) {
					SET(" content = #{content} ");
				}
				if(notice.getUser()!=null && notice.getUser().getId()!=null){
					SET(" user_id = #{user.id} ");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
		return sql;
	}
}
