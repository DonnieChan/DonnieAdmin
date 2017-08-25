package com.donnie.service.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donnie.bean.Message;
import com.donnie.bean.RequestParams;
import com.donnie.dao.message.IMessageMapper;
import com.donnie.service.message.IMessageService;
import com.donnie.util.TmStringUtils;

@Service
public class MessageServiceImpl implements IMessageService{
    
	@Autowired
	IMessageMapper messageMapper;   //它相当于DAO类的职能
	
	/***
	 * 描述：(查找信息)
	 * 方法名：findMessages
	 * 创建人：Donnie 时间：2016年3月24日-下午7:04:54 
	 * @return List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public List<Message> findMessages(RequestParams requestParams){
		if(TmStringUtils.isEmpty(requestParams.getOrder())){
		  requestParams.setOrder("createTime desc");
		}
		return messageMapper.findMessages(requestParams);
	}
	
	/***
	 * 描述：(求总数)
	 * com.donnie.dao.message
	 * 方法名：count
	 * 创建人：Donnie 时间：2017年08月25日 17:49:33 
	 * @param requestParams
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
    public int count(RequestParams requestParams){
       return messageMapper.count(requestParams);
    }
	
	/***
	 * 描述：(查找单个信息)
	 * 方法名：get
	 * 创建人：Donnie 时间：2017年08月25日 17:49:33 
	 * @param requestParams
	 * @return List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
    public Message get(Integer id){
        return messageMapper.get(id);
    }

	/***
     * 描述：(保存信息)
     * 方法名：saveMessage
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:08 
     * @param message
     * @return Message
     * @exception 
     * @since  1.0.0
     */
	@Override
	public int save(Message message) {
		return messageMapper.save(message);
	}

	/***
     * 描述：(保存信息)
     * 方法名：updateMessage
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:14 
     * @param message
     * @return Message
     * @exception 
     * @since  1.0.0
     */
	@Override
	public int update(Message message) {
		return messageMapper.update(message);
	}
    
	/***
     * 描述：(删除信息)
     * 方法名：deleteMessage
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:20 
     * @param message
     * @return Message
     * @exception 
     * @since  1.0.0
     */
	@Override
	public int delete(Message message) {
		return messageMapper.delete(message);
	}
	
}
