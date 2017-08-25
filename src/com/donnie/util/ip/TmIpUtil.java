package com.donnie.util.ip;

import javax.servlet.http.HttpServletRequest;

import com.donnie.util.TmStringUtils;

public class TmIpUtil {

	/**
	 * 判断ip是否在指定网段中
	 * 
	 * @param iparea
	 * @param ip
	 * @return boolean
	 */
	public static boolean ipIsInNet(String iparea, String ip) {
		if (iparea == null)
			throw new NullPointerException("IP段不能为空！");
		if (ip == null)
			throw new NullPointerException("IP不能为空！");
		iparea = iparea.trim();
		ip = ip.trim();
		final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
		final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
		if (!iparea.matches(REGX_IPB) || !ip.matches(REGX_IP))
			return false;
		int idx = iparea.indexOf('-');
		String[] sips = iparea.substring(0, idx).split("\\.");
		String[] sipe = iparea.substring(idx + 1).split("\\.");
		String[] sipt = ip.split("\\.");
		long ips = 0L, ipe = 0L, ipt = 0L;
		for (int i = 0; i < 4; ++i) {
			ips = ips << 8 | Integer.parseInt(sips[i]);
			ipe = ipe << 8 | Integer.parseInt(sipe[i]);
			ipt = ipt << 8 | Integer.parseInt(sipt[i]);
		}
		if (ips > ipe) {
			long t = ips;
			ips = ipe;
			ipe = t;
		}
		return ips <= ipt && ipt <= ipe;
	}

	// IP判断
	public static boolean ipJudge(String ipArea, String ip) {
		boolean i = false;
		ipArea = TmStringSubUtil.LastSubStr(ipArea, ",");
		String[] arrayOfString = ipArea.split(",");
		for (int j = 0; j < arrayOfString.length; ++j)
			if (arrayOfString[j].indexOf("*") != -1) {
				if (!(ipJudgment(arrayOfString[j].replaceAll("\\*", "0") + "-"
						+ arrayOfString[j].replaceAll("\\*", "255"), ip)))
					continue;
				i = true;
				break;
			} else if (arrayOfString[j].indexOf(45) != -1) {
				if (!(ipJudgment(arrayOfString[j], ip)))
					continue;
				i = true;
				break;
			} else {
				if (!(arrayOfString[j].equals(ip)))
					continue;
				i = true;
				break;
			}
		return i;
	}

	public static boolean ipJudgment(String ipArea, String ip) {
		if (ipArea == null)
			throw new NullPointerException("IPBound is Null");
		if (ip == null)
			throw new NullPointerException("IP is Null");
		ipArea = ipArea.trim();
		ip = ip.trim();
		String str1 = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
		String str2 = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\-((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
		if ((!(ipArea
				.matches("((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\-((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)")))
				|| (!(ip.matches("((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)"))))
			return false;
		int i = ipArea.indexOf(45);
		String[] arrayOfString1 = ipArea.substring(0, i).split("\\.");
		String[] arrayOfString2 = ipArea.substring(i + 1).split("\\.");
		String[] arrayOfString3 = ip.split("\\.");
		long l1 = 0L;
		long l2 = 0L;
		long l3 = 0L;
		for (int j = 0; j < 4; ++j) {
			l1 = l1 << 8 | Integer.parseInt(arrayOfString1[j]);
			l2 = l2 << 8 | Integer.parseInt(arrayOfString2[j]);
			l3 = l3 << 8 | Integer.parseInt(arrayOfString3[j]);
		}
		if (l1 > l2) {
			long l4 = l1;
			l1 = l2;
			l2 = l4;
		}
		return ((l1 <= l3) && (l3 <= l2));
	}

	public static String ipFormat(String paramString) {
		return paramString.substring(0, paramString.lastIndexOf(".") + 1) + "*";
	}


	/**
	 * 获取用户的IP地址
	 * com.tz.util.ip 
	 * 方法名：getIpAddr
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年9月15日-下午11:38:38 
	 * @param request
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1"))
			return "127.0.0.1";
		return ip;
	}

	// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
	// public static String getIpAddr(HttpServletRequest request) {
	// String clientIp = request.getHeader("x-forwarded-for");
	// // log.info("All the IP address string is: " + strClientIp);
	// if (clientIp == null || clientIp.length() == 0 ||
	// "unknown".equalsIgnoreCase(clientIp)) {
	// clientIp = request.getRemoteAddr();
	// } else {
	// String[] ips = {};
	// // BusiAcceptAction.SplitsString(strClientIp, ',' , ipList); //
	// // 拆分字符串，可直接用String.plit方法
	// ips = clientIp.split(",");
	// String ip = new String();
	// for (int index = 0; index < ips.length; index++) {
	// ip = (String) ips[index];
	// if (!("unknown".equalsIgnoreCase(ip))) {
	// clientIp = ip;
	// break;
	// }
	// }
	// }
	// return clientIp;
	// }
	
	/**
	 * 根据IP地址找到你对应城市和省份
	 * com.tz.util.ip 
	 * 方法名：ipLocation
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年9月15日-下午11:21:02 
	 * @param ip
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String ipLocation(String ip) {
		String ipLocation = "";
		TmIPSeeker ipSeeker = new TmIPSeeker("qqwry.dat","E:/Java Practice/TanZhou/Spring - KeKe/DonnieAdmin/WebRoot/ip");
		ipLocation = ipSeeker.getIPLocation(ip).getCountry() + " "+ ipSeeker.getIPLocation(ip).getArea();
		return ipLocation;
	}
	
	/**
	 * 找到省份
	 * com.tz.util.ip 
	 * 方法名：ipprovince
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年9月15日-下午11:21:14 
	 * @param ip
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String ipprovince(String ip) {
		String ipLocation = "";
		TmIPSeeker ipSeeker = new TmIPSeeker("qqwry.dat","D:/tzprojects/tz_desk/WebRoot/ip");
		ipLocation = ipSeeker.getIPLocation(ip).getCountry() ;
		return ipLocation;
	}

	/**
	 * 找到城市
	 * com.tz.util.ip 
	 * 方法名：ipcity
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年9月15日-下午11:21:19 
	 * @param ip
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String ipcity(String ip) {
		String ipLocation = "";
		TmIPSeeker ipSeeker = new TmIPSeeker("qqwry.dat","D:/tzprojects/tz_desk/WebRoot/ip");
		ipLocation =  ipSeeker.getIPLocation(ip).getArea();
		return ipLocation;
	}
	
	/**
	 * 获取省份和城市，传递水晶IP地址库的路径
	 * com.tz.util.ip 
	 * 方法名：ipLocation
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年9月15日-下午11:21:33 
	 * @param ip
	 * @param path
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String ipLocation(String ip, String path) {
		String ipLocation = "";
		TmIPSeeker ipSeeker = new TmIPSeeker("qqwry.dat", path);
		ipLocation = ipSeeker.getIPLocation(ip).getCountry() + " "
				+ ipSeeker.getIPLocation(ip).getArea();
		return ipLocation;
	}

	/**
	 *  获取省份和城市，传递水晶IP地址库的路径
	 * com.tz.util.ip 
	 * 方法名：ipLocation
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年9月15日-下午11:22:05 
	 * @param request
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String ipLocation(HttpServletRequest request) {
		if(request==null)return "";
		try{
			String ipLocation = "";
			String ip = getIpAddress(request);
			String path = request.getRealPath("/") + "/ip";
			if (TmStringUtils.isNotEmpty(path)) {
				path = TmStringUtils.conversionSpecialCharacters(path);
				TmIPSeeker ipSeeker = new TmIPSeeker("qqwry.dat", path);
				ipLocation = ipSeeker.getIPLocation(ip).getCountry() + " "
						+ ipSeeker.getIPLocation(ip).getArea();
			}
			return ipLocation;
		}catch (Exception e) {
			return "";
		}
	}

	public static void main(String[] args) {
		System.out.println(ipJudge("192.168.1.1", "192.168.1.1"));
		System.out.println(ipJudge("192.168.1.*", "192.168.1.255"));
		System.out.println(ipJudge("192.168.1.1-192.168.1.2", "192.168.1.1"));
		System.out.println(ipJudge("202.168.1.1-202.168.1.3", "202.168.1.2"));
		System.out.println(ipJudge("127.0.0.0-127.0.0.10", "127.0.0.0"));
		System.out.println(ipJudge("192.168.1.1", "192.168.1.1"));
		
		//统计，省份统计，城市统计，
//		System.out.println(ipLocation("116.23.24.118"));
//		System.out.println(ipLocation("123.152.123.63"));
//		System.out.println(ipLocation("59.172.165.66"));
//		System.out.println(ipLocation("111.132.13.74"));
//		System.out.println(ipprovince("114.252.129.17"));
		System.out.println(ipLocation("220.162.201.130"));
		System.out.println(ipLocation("106.39.192.54"));
		System.out.println(ipLocation("122.71.230.161"));
		System.out.println(ipLocation("123.57.209.52"));
		System.out.println(ipLocation("58.213.110.2"));
		System.out.println(ipLocation("14.130.153.128"));
		System.out.println(ipLocation("202.96.134.133"));
		
	}

}
