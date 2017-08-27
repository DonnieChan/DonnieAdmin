package com.donnie.auto;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.donnie.util.TmFileUtil;
import com.donnie.util.TmStringUtils;
import com.donnie.auto.SqlFileExecutor;

/**
 * <b>类名称：</b>TzAutoProject<br/>
 * <b>类描述：</b>根据自定义的bean的名字，创建其MVC三层架构中锁涉及到的各种java,jsp文件<br/>
 * <b>创建人：</b>donnie<br/>
 * <b>修改人：</b>donnie<br/>
 * <b>修改时间：</b>2016年4月4日 下午2:27:09<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0
 *
 */
public class TzAutoProject {

	//bean
	//service
	//web/bean
	//pages/bean
	
	//类名
	private static String beanName = "Message";
	
	//小写beanName
	private static String lowerCaseBeanName = beanName.toLowerCase();
	
	//即将创建的磁盘中的目录结构
	private static String srcPath = "src/";
	private static String beanPath = "com/donnie/bean/";
	private static String daoPath = "com/donnie/dao/";
	private static String servicePath = "com/donnie/service/";
	private static String serviceImplPath = "com/donnie/service/"+lowerCaseBeanName+"/impl";
	private static String webPath = "com/donnie/web/";
	private static String pagePath = "WebRoot/Web-INF/pages/" + lowerCaseBeanName +"/";  //各个domain的list.jsp，template.jsp的文件父级目录
			
	//bean模版资源文件的目录
	private static String beanTemplatePath = "template/bean.txt";
	//beanDao模版资源文件的目录
	private static String daoTemplatePath = "template/mapper.txt";
    //SQLXML模版资源文件的目录
	private static String sqlXmlTemplatePath = "template/sqlxml.txt";
	//service模版资源文件的目录
	private static String serviceTemplatePath = "template/service.txt";
	//serviceImpl模版资源文件的目录
	private static String serviceImplTemplatePath = "template/serviceImpl.txt";
	//web模版资源文件的目录
	private static String webTemplatePath = "template/web.txt";
	//数据库表table模版资源文件的目录
	private static String tableTemplate = "template/table.sql";
	//list模版资源文件的目录
	private static String pageTemplatePath = "template/list.txt";
	//template模版目录
	private static String templateTemplatePath = "template/template.txt";
	
	//bean包名
	private static String beanPackage = "com.donnie.bean";
	//beanDao包名
	private static String daoPackage = "com.donnie.dao";
	//service包名
	private static String servicePackage = "com.donnie.service";
	//serviceImpl包名
	private static String serviceImplPackage = "com.donnie.service."+lowerCaseBeanName+".impl";
	//web包名
	private static String webPackage = "com.donnie.web";
	
	//注释
	private static String author = "Donnie";
	private static String date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
	private static String description = "信息";
	private static String qq = "461560867";
	
	/***
	 * 描述：(获取项目的磁盘根目录)
	 * 方法名：getRoot
	 * 创建人：Donnie 时间：2016年4月11日-下午11:42:36 
	 * @param path
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getRoot(String path){
		//System.getProperty("user.dir")：打印项目所在的磁盘路径
		return new File(System.getProperty("user.dir"),path).getAbsolutePath();
	}
	
	/***
	 * 
	 * 描述：(替换模版中的部分内容)
	 * 方法名：replaceTemplate
	 * 创建人：Donnie 时间：2016年4月5日-下午11:44:05 
	 * @param content
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String replaceTemplate(String content){
		
	  if(TmStringUtils.isNotEmpty(content)){
	 return content.replaceAll("\\[beanPackage\\]", beanPackage)
			 	   .replaceAll("\\[author\\]", author)
			 	   .replaceAll("\\[date\\]", date)
			 	   .replaceAll("\\[description\\]", description)
			 	   .replaceAll("\\[qq\\]", qq)
			 	   .replaceAll("\\[beanName\\]", beanName)     //替换实体名字(首字母大写)
			 	   .replaceAll("\\[daoPackage\\]", daoPackage)       //替换实体的Dao的包路径
			 	   .replaceAll("\\[lowerCaseBeanName\\]", lowerCaseBeanName)
	               .replaceAll("\\[servicePackage\\]", servicePackage) //替换实体的service的包路径
	               .replaceAll("\\[serviceImplPackage\\]", serviceImplPackage)  //替换实体的serviceImpl的包路径
 	               .replaceAll("\\[webPackage\\]", webPackage);  //替换实体的Controller的包路径
		}else{
			return "";
		}
		
	}
	
    /***
     * 描述：(创建bean)
     * 方法名：createBean
     * 创建人：Donnie 时间：2016年4月10日-下午6:37:45 
     * @throws IOException void
     * @exception 
     * @since  1.0.0
     */
	public static void createBean() throws IOException{

		//获取bean模版的内容
		String template = getRoot(beanTemplatePath);

		//创建bean目录
		File beanFolder = new File(getRoot(srcPath + beanPath));
		if(!beanFolder.exists())
			beanFolder.mkdirs();
		
		//包括类文件本身的目录
        File templateFile = new File(beanFolder,beanName+".java");
        
        //读取模版中的文本内容
        String content = TmFileUtil.readFileByLines(template);		

        if(!templateFile.exists()){        
        
        //按要求替换模版中的部分文本内容
		content = replaceTemplate(content);
		System.out.println("【自动构建Bean：】：" + templateFile);
        //将模版的文本内容写入到类文件中
		FileUtils.writeStringToFile(templateFile, content, "UTF-8");
       }else{
    	   System.out.println("该文件已存在，是否要进行覆盖？输入y，进行覆盖，输入其他按键则不覆盖");
    	   Scanner scan = new Scanner(System.in);
    	   if(scan.nextLine().equals("y")){
         	   //按要求替换模版中的部分文本内容
    			content = replaceTemplate(content);
    			System.out.println("【自动构建Bean：】：" + templateFile);
    		   //将模版的文本内容写入到类文件中
    		   FileUtils.writeStringToFile(templateFile, content, "UTF-8");
    		   System.out.println("文件覆盖成功！");
    	   }
    	   else{
    	System.out.println("您要创建的bean已经存在了，请检查过后，再确定是否需要覆盖原文件！");   
           }
       } 
	}
	
	/***
	 * 描述：(创建beanMapper)
	 * 方法名：createBeanDao
	 * 创建人：Donnie 时间：2016年4月10日-下午7:05:44 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createDao() throws IOException{
		
		//获取beanDao模版的内容
		String template = getRoot(daoTemplatePath);
		
		//创建bean目录
		File beanFolder = new File(getRoot(srcPath + daoPath + lowerCaseBeanName));
		if(!beanFolder.exists())
			beanFolder.mkdirs();
		
		//包括类文件本身的目录
		File templateFile = new File(beanFolder,"I"+beanName+"Mapper.java");
		
		//读取模版中的文本内容
        String content = TmFileUtil.readFileByLines(template);
		
        if(!templateFile.exists()){        
            
        //按要求替换模版中的部分文本内容
		content = replaceTemplate(content);
		System.out.println("【自动构建Mapper：】：" + templateFile);
        //将模版的文本内容写入到类文件中
		FileUtils.writeStringToFile(templateFile, content, "UTF-8");
       }else{
    	   System.out.println("该文件已存在，是否要进行覆盖？输入y，进行覆盖，输入其他按键则不覆盖");
    	   Scanner scan = new Scanner(System.in);
    	   if(scan.nextLine().equals("y")){
         	   //按要求替换模版中的部分文本内容
    			content = replaceTemplate(content);
    			System.out.println("【自动构建Mapper：】：" + templateFile);
    		   //将模版的文本内容写入到类文件中
    		   FileUtils.writeStringToFile(templateFile, content, "UTF-8");
    		   System.out.println("文件覆盖成功！");
    	   }
    	   else{
    	System.out.println("您要创建的bean已经存在了，请检查过后，再确定是否需要覆盖原文件！");   
           }
       } 
		
	}
	
	/***
	 * 描述：(创建SQLXML)
	 * 方法名：createSQLXml
	 * 创建人：Donnie 时间：2016年4月10日-下午11:55:56 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createSQLXml() throws IOException{
		
		
		//创建SQLXML目录
		File beanFolder = new File(getRoot(srcPath + daoPath + lowerCaseBeanName));
		if(!beanFolder.exists())
			beanFolder.mkdirs();
		
		//包括SQLXML文件本身的目录
		File templateFile = new File(beanFolder,beanName+".xml");

		//获取SQLXML模版的内容
		String template = getRoot(sqlXmlTemplatePath);
		
		//读取模版中的文本内容
        String content = TmFileUtil.readFileByLines(template);
		
        if(!templateFile.exists()){        
            
        //按要求替换模版中的部分文本内容
		content = replaceTemplate(content);
		System.out.println("【自动构建SQLXML：】：" + templateFile);
        //将模版的文本内容写入到类文件中
		FileUtils.writeStringToFile(templateFile, content, "UTF-8");
       }else{
    	   System.out.println("该文件已存在，是否要进行覆盖？输入y，进行覆盖，输入其他按键则不覆盖");
    	   Scanner scan = new Scanner(System.in);
    	   if(scan.nextLine().equals("y")){
         	   //按要求替换模版中的部分文本内容
    			content = replaceTemplate(content);
    			System.out.println("【自动构建SQLXML：】：" + templateFile);
    		   //将模版的文本内容写入到类文件中
    		   FileUtils.writeStringToFile(templateFile, content, "UTF-8");
    		   System.out.println("文件覆盖成功！");
    	   }
    	   else{
    	System.out.println("您要创建的bean已经存在了，请检查过后，再确定是否需要覆盖原文件！");   
           }
       } 
		
	}

	/***
	 * 描述：(创建service)
	 * 方法名：createDao
	 * 创建人：Donnie 时间：2016年4月11日-下午11:24:41 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
    public static void createService() throws IOException{
	
	//创建bean目录
	File beanFolder = new File(getRoot(srcPath + servicePath + lowerCaseBeanName));
	if(!beanFolder.exists())
		beanFolder.mkdirs();
	
	//包括类文件本身的目录
	File templateFile = new File(beanFolder,"I"+beanName+"Service.java");

	//获取beanDao模版的内容
	String template = getRoot(serviceTemplatePath);
	
	//读取模版中的文本内容
    String content = TmFileUtil.readFileByLines(template);
	
    if(!templateFile.exists()){        
        
    //按要求替换模版中的部分文本内容
	content = replaceTemplate(content);
	System.out.println("【自动构建Service：】：" + templateFile);
    //将模版的文本内容写入到类文件中
	FileUtils.writeStringToFile(templateFile, content, "UTF-8");
   }else{
	   System.out.println("该文件已存在，是否要进行覆盖？输入y，进行覆盖，输入其他按键则不覆盖");
	   Scanner scan = new Scanner(System.in);
	   if(scan.nextLine().equals("y")){
     	   //按要求替换模版中的部分文本内容
			content = replaceTemplate(content);
			System.out.println("【自动构建Mapper：】：" + templateFile);
		   //将模版的文本内容写入到类文件中
		   FileUtils.writeStringToFile(templateFile, content, "UTF-8");
		   System.out.println("文件覆盖成功！");
	   }
	   else{
	System.out.println("您要创建的bean已经存在了，请检查过后，再确定是否需要覆盖原文件！");   
       }
   } 
	
  }
 
  /***
   * 描述：(创建serviceImpl)
   * 方法名：createDao
   * 创建人：Donnie 时间：2016年4月11日-下午11:24:11 
   * @throws IOException void
   * @exception 
   * @since  1.0.0
   */
  public static void createServiceImpl() throws IOException{	
	
	//创建bean目录
	File beanFolder = new File(getRoot(srcPath + serviceImplPath));
	if(!beanFolder.exists())
		beanFolder.mkdirs();
	
	//包括类文件本身的目录
	File templateFile = new File(beanFolder,beanName+"ServiceImpl.java");
	
	//获取beanDao模版的内容
	String template = getRoot(serviceImplTemplatePath);
	
	//读取模版中的文本内容
    String content = TmFileUtil.readFileByLines(template);
	
    if(!templateFile.exists()){        
        
    //按要求替换模版中的部分文本内容
	content = replaceTemplate(content);
	System.out.println("【自动构建ServiceImpl：】：" + templateFile);
    //将模版的文本内容写入到类文件中
	FileUtils.writeStringToFile(templateFile, content, "UTF-8");
   }else{
	   System.out.println("该文件已存在，是否要进行覆盖？输入y，进行覆盖，输入其他按键则不覆盖");
	   Scanner scan = new Scanner(System.in);
	   if(scan.nextLine().equals("y")){
     	   //按要求替换模版中的部分文本内容
			content = replaceTemplate(content);
			System.out.println("【自动构建ServiceImpl：】：" + templateFile);
		   //将模版的文本内容写入到类文件中
		   FileUtils.writeStringToFile(templateFile, content, "UTF-8");
		   System.out.println("文件覆盖成功！");
	   }
	   else{
	System.out.println("您要创建的bean已经存在了，请检查过后，再确定是否需要覆盖原文件！");   
       }
   } 
	
  }
  
  /***
   * 描述：(创建WebController)
   * 方法名：createDao
   * 创建人：Donnie 时间：2016年4月11日-下午11:23:44 
   * @throws IOException void
   * @exception 
   * @since  1.0.0
   */
  public static void createWebController() throws IOException{
	
	
	//创建bean目录
	File beanFolder = new File(getRoot(srcPath + webPath + lowerCaseBeanName));
	if(!beanFolder.exists())
		beanFolder.mkdirs();
	
	//包括类文件本身的目录
	File templateFile = new File(beanFolder,beanName+"Controller.java");

	//获取beanDao模版的内容
	String template = getRoot(webTemplatePath);
	
	//读取模版中的文本内容
    String content = TmFileUtil.readFileByLines(template);
	
    if(!templateFile.exists()){        
        
    //按要求替换模版中的部分文本内容
	content = replaceTemplate(content);
	System.out.println("【自动构建Controller：】：" + templateFile);
    //将模版的文本内容写入到类文件中
	FileUtils.writeStringToFile(templateFile, content, "UTF-8");
   }else{
	   System.out.println("该文件已存在，是否要进行覆盖？输入y，进行覆盖，输入其他按键则不覆盖");
	   Scanner scan = new Scanner(System.in);
	   if(scan.nextLine().equals("y")){
     	   //按要求替换模版中的部分文本内容
			content = replaceTemplate(content);
			System.out.println("【自动构建Controller：】：" + templateFile);
		   //将模版的文本内容写入到类文件中
		   FileUtils.writeStringToFile(templateFile, content, "UTF-8");
		   System.out.println("文件覆盖成功！");
	   }
	   else{
	System.out.println("您要创建的bean已经存在了，请检查过后，再确定是否需要覆盖原文件！");   
       }
   } 
	
  }
  
  /***
   * 
   * 描述：(创建数据库表)
   * 方法名：createTable
   * 创建人：Donnie 时间：2017年8月25日-上午11:27:54  void
   * @exception 
   * @since  1.0.0
   */
  public static void createTable(){
		try {
			//获取模板页面路径
			String template = getRoot(tableTemplate);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kekeblog2?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "root", "root");
			new SqlFileExecutor().execute(connection, template,"\\[smallBeanName\\]",lowerCaseBeanName);
	        System.out.println("【自动构建提示Table: 】生成表keke_"+lowerCaseBeanName+"表成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("【自动构建提示Table: 】生成表keke_"+lowerCaseBeanName+"表失败!");
		} 
	}
  
  /***
   * 
   * 描述：(创建各个domain的list.jsp)
   * 方法名：createWebController
   * 创建人：Donnie 时间：2017年8月22日-下午11:58:08 
   * @throws IOException void
   * @exception 
   * @since  1.0.0
   */
  public static void createPage() throws IOException{
  
    //创建page目录
	File beanFolder = new File(getRoot(pagePath));
	if(!beanFolder.exists())
		beanFolder.mkdirs();
	
	//包括list.jsp本身的目录
	File templateFile = new File(pagePath,"list.jsp");
	
	//获取list.txt模版的内容
	String template = getRoot(pageTemplatePath);
	
	//读取模版中的文本内容
    String content = TmFileUtil.readFileByLines(template);

    if(!templateFile.exists()){        
        
    //按要求替换模版中的部分文本内容
	content = replaceTemplate(content);
	System.out.println("【自动构建list：】：" + templateFile);
    //将模版的文本内容写入到类文件中
	FileUtils.writeStringToFile(templateFile, content, "UTF-8");
   }else{
	   System.out.println("该文件已存在，是否要进行覆盖？输入y，进行覆盖，输入其他按键则不覆盖");
	   Scanner scan = new Scanner(System.in);
	   if(scan.nextLine().equals("y")){
     	   //按要求替换模版中的部分文本内容
			content = replaceTemplate(content);
			System.out.println("【自动构建list：】：" + templateFile);
		   //将模版的文本内容写入到类文件中
		   FileUtils.writeStringToFile(templateFile, content, "UTF-8");
		   System.out.println("文件覆盖成功！");
	   }
	   else{
	System.out.println("您要创建的list已经存在了，请检查过后，再确定是否需要覆盖原文件！");   
       }
   }
    
 }
  
  /***
   * 
   * 描述：(创建各个domain的template.jsp)
   * 方法名：createTemplate
   * 创建人：Donnie 时间：2017年8月23日-上午12:02:00 
   * @throws IOException void
   * @exception 
   * @since  1.0.0
   */
  public static void createTemplate() throws IOException{
	  
	    //创建template目录
		File beanFolder = new File(getRoot(pagePath));
		if(!beanFolder.exists())
			beanFolder.mkdirs();
		
		//包括template文件本身的目录
		File templateFile = new File(beanFolder,"template.jsp");
		
		//获取template.txt模版的内容
		String template = getRoot(templateTemplatePath);
		
		//读取模版中的文本内容
	    String content = TmFileUtil.readFileByLines(template);
		
	    if(!templateFile.exists()){        
	        
	    //按要求替换模版中的部分文本内容
		content = replaceTemplate(content);
		System.out.println("【自动构建list：】：" + templateFile);
	    //将模版的文本内容写入到类文件中
		FileUtils.writeStringToFile(templateFile, content, "UTF-8");
	   }else{
		   System.out.println("该文件已存在，是否要进行覆盖？输入y，进行覆盖，输入其他按键则不覆盖");
		   Scanner scan = new Scanner(System.in);
		   if(scan.nextLine().equals("y")){
	     	   //按要求替换模版中的部分文本内容
				content = replaceTemplate(content);
				System.out.println("【自动构建list：】：" + templateFile);
			   //将模版的文本内容写入到类文件中
			   FileUtils.writeStringToFile(templateFile, content, "UTF-8");
			   System.out.println("文件覆盖成功！");
		   }
		   else{
		System.out.println("您要创建的list已经存在了，请检查过后，再确定是否需要覆盖原文件！");   
	       }
	   }
	    
	 }
 
  /***
   * 描述：(测试主方法)
   * 方法名：main
   * 创建人：Donnie 时间：2016年4月11日-下午11:28:53 
   * @param args
   * @throws IOException void
   * @exception 
   * @since  1.0.0
   */
  public static void main(String[] args) throws IOException {
	  
	  /*Start System获取操作系统，JVM，JDK，当前项目路径等信息*/
//		System.out.println(getRoot("test"));
//		Properties properties = System.getProperties();
//		Enumeration<Object> keys = properties.keys();
//		
//		while(keys.hasMoreElements()){
//			Object object = keys.nextElement();
//			System.out.println("当前属性为：" + object + " ，前属性值为： " + properties.get(object));
//		}
	  /*End System获取操作系统，JVM，JDK，当前项目路径等信息*/

	  
//以Message相关的bean,dao,service,controller,mapper作为例子
      //测试getRoot方法	  
	  //getRoot(pageTemplatePath);
	  
	  //创建bean
	  //createBean();
		
	  //创建beanDao
	  //createDao();
	
	  //创建SQLXML
	  //createSQLXml();

	  //创建Service
	  //createService();
	  
	  //创建ServiceImpl
	  //createServiceImpl();

	  //创建WebController
	  //createWebController();
	  
	  //创建table数据库表
	  createTable();
	  
	  //创建page
	  //createPage();
	  
	  //创建template
	  //createTemplate();
	}
	
}
