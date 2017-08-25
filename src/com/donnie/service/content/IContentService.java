package com.donnie.service.content;

import java.util.List;

import com.donnie.bean.Content;
import com.donnie.bean.RequestParams;

public interface IContentService {
    
	/***
	 * 描述：(查找内容)
	 * 方法名：findContents
	 * 创建人：Donnie 时间：2016年04月13日 23:19:21 
	 * @param requestParams
	 * @return List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Content> findContents(RequestParams requestParams);
    
	/***
	 * 描述：(求Content记录总数)
	 * 方法名：countContent
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
     * 方法名：saveContents
     * 创建人：Donnie 时间：2016年04月13日 23:19:21 
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	public int save(Content content);
    
	/***
     * 描述：(保存内容)
     * 方法名：updateContents
     * 创建人：Donnie 时间：2016年04月13日 23:19:21 
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	public int update(Content content);

	/***
     * 描述：(删除内容)
     * 方法名：deleteContents
     * 创建人：Donnie 时间：2016年04月13日 23:19:21 
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	public int delete(Content content);
	
}
