package com.donnie.service.message;

import java.util.List;

import com.donnie.bean.Message;
import com.donnie.bean.RequestParams;

public interface IMessageService {
    
	/***
	 * 描述：(查找信息)
	 * 方法名：findMessages
	 * 创建人：Donnie 时间：2017年08月25日 13:41:35 
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
	 * 创建人：Donnie 时间：2017年08月25日 13:41:35 
	 * @param requestParams
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
    public int count(RequestParams requestParams);
    
    /***
	 * 描述：(查找信息)
	 * 方法名：get
	 * 创建人：Donnie 时间：2017年08月25日 13:41:35 
	 * @param requestParams
	 * @return List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
    public Message get(Integer id);
    
	/***
     * 描述：(保存信息)
     * 方法名：saveMessages
     * 创建人：Donnie 时间：2017年08月25日 13:41:35 
     * @param message
     * @return Message
     * @exception 
     * @since  1.0.0
     */
	public int save(Message message);
    
	/***
     * 描述：(保存信息)
     * 方法名：updateMessages
     * 创建人：Donnie 时间：2017年08月25日 13:41:35 
     * @param message
     * @return Message
     * @exception 
     * @since  1.0.0
     */
	public int update(Message message);

	/***
     * 描述：(删除信息)
     * 方法名：deleteMessages
     * 创建人：Donnie 时间：2017年08月25日 13:41:35 
     * @param message
     * @return Message
     * @exception 
     * @since  1.0.0
     */
	public int delete(Message message);
	
}
