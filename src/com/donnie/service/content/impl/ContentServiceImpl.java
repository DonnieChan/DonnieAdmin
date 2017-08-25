package com.donnie.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donnie.bean.Content;
import com.donnie.bean.RequestParams;
import com.donnie.dao.content.IContentMapper;
import com.donnie.service.content.IContentService;
import com.donnie.util.TmStringUtils;

@Service
public class ContentServiceImpl implements IContentService{
    
	@Autowired
	IContentMapper contentMapper;   //它相当于DAO类的职能
	
	/***
	 * 描述：(查找内容)
	 * 方法名：findContents
	 * 创建人：Donnie 时间：2016年3月24日-下午7:04:54 
	 * @return List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	@Override
	public List<Content> findContents(RequestParams requestParams){
		
		if(TmStringUtils.isEmpty(requestParams.getOrder())){
		  requestParams.setOrder("create_time desc");
		  //设置keyword，则可以根据keyword的内容进行查询
		  //requestParams.setKeyword("一路走来");
		}
		
		return contentMapper.findContents(requestParams);
		
	}
	
	@Override
	/***
	 * 描述：(求Content记录总数)
	 * 方法名：countContent
	 * 创建人：Donnie 时间：2016年4月30日-下午10:16:15 
	 * @param requestParams
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(RequestParams requestParams) {
		//测试条件查询
		requestParams.setChannel_id(2);
		return contentMapper.count(requestParams);
	}
	
	/***
	 * 描述：(查找内容)
	 * 方法名：get
	 * 创建人：Donnie 时间：2016年04月14日 00:15:27 
	 * @param requestParams
	 * @return List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
    public Content get(Content content){
        return contentMapper.get(content);
    }

	/***
     * 描述：(保存内容)
     * 方法名：saveContent
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:08 
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	@Override
	public int save(Content content) {
		return contentMapper.save(content);
	}

	/***
     * 描述：(保存内容)
     * 方法名：updateContent
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:14 
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	@Override
	public int update(Content content) {
		return contentMapper.update(content);
	}
    
	/***
     * 描述：(删除内容)
     * 方法名：deleteContent
     * 创建人：Donnie 时间：2016年4月10日-下午7:28:20 
     * @param content
     * @return Content
     * @exception 
     * @since  1.0.0
     */
	@Override
	public int delete(Content content) {
		return contentMapper.delete(content);
	}
}
