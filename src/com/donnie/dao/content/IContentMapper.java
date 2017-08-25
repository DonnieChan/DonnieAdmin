package com.donnie.dao.content;

import java.util.List;

import com.donnie.bean.Content;
import com.donnie.bean.RequestParams;

/***
 * <b>类名称：</b>IContentMapper<br/>
 * <b>类描述：</b>IContentMapper<br/>
 * <b>创建人：</b>Donnie<br/>
 * <b>修改人：</b>Donnie<br/>
 * <b>修改时间：</b>2016年3月24日 下午4:25:51<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0
 *
 */
public interface IContentMapper {
    
	/***
	 * 描述：(查找内容)
	 * 方法名：findContents
	 * 创建人：Donnie 时间：2016年04月13日 23:19:21 
	 * com.donnie.dao.Content
	 * @param requestParams
	 * @return List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Content> findContents(RequestParams requestParams);
    
	/***
	 * 描述：(求Content记录总数)
	 * 方法名：count
	 * 创建人：Donnie 时间：2016年4月30日-下午10:16:15 
	 * @param requestParams
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(RequestParams requestParams);
	
    /***
	 * 描述：(查找内容)
	 * 方法名：get
	 * 创建人：Donnie 时间：2016年04月13日 23:19:21 
	 * @param requestParams
	 * @return List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
    public Content get(Content content);
    
	/***
     * 描述：(保存内容)
     * 方法名：save
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:08 
     * com.donnie.dao.Content
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	public int save(Content content);
    
	/***
     * 描述：(保存内容)
     * 方法名：update
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:14 
     * com.donnie.dao.Content
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	public int update(Content content);

	/***
     * 描述：(删除内容)
     * 方法名：delete
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:20 
     * com.donnie.dao.Content
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	public int delete(Content content);
	
}
