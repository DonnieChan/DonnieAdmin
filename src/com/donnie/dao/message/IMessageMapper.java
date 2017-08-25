package com.donnie.dao.message;

import java.util.List;

import com.donnie.bean.Message;
import com.donnie.bean.RequestParams;

/***
 * <b>类名称：</b>IMessageMapper<br/>
 * <b>类描述：</b>IMessageMapper<br/>
 * <b>创建人：</b>Donnie<br/>
 * <b>修改人：</b>Donnie<br/>
 * <b>修改时间：</b>2016年3月24日 下午4:25:51<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0
 *
 */
public interface IMessageMapper {
    
	/***
	 * 描述：(查找信息)
	 * 方法名：findMessages
	 * 创建人：Donnie 时间：2017年08月25日 13:38:42 
	 * com.donnie.dao.Message
	 * @param requestParams
	 * @return List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Message> findMessages(RequestParams requestParams);
    
    /***
	 * 描述：(求总数)
	 * com.donnie.dao.message
	 * 方法名：count
	 * 创建人：Donnie 时间：2017年08月25日 13:38:42 
	 * @param requestParams
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
    public int count(RequestParams requestParams);
    
    /***
	 * 描述：(查找单个信息)
	 * com.donnie.dao.message
	 * 方法名：getMessage
	 * 创建人：Donnie 时间：2017年08月25日 13:38:42 
	 * @param id
	 * @return Message
	 * @exception 
	 * @since  1.0.0
	 */
    public Message get(Integer id);
    
	/***
     * 描述：(保存信息)
     * 方法名：save
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:08 
     * com.donnie.dao.Message
     * @param message
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	public int save(Message message);
    
	/***
     * 描述：(保存信息)
     * 方法名：update
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:14 
     * com.donnie.dao.Message
     * @param message
     * @return Message
     * @exception 
     * @since  1.0.0
     */
	public int update(Message message);

	/***
     * 描述：(删除信息)
     * 方法名：delete
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:20 
     * com.donnie.dao.Message
     * @param message
     * @return Message
     * @exception 
     * @since  1.0.0
     */
	public int delete(Message message);
	
}
