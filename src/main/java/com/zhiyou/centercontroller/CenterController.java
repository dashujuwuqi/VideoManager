package com.zhiyou.centercontroller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.centerservice.CenterService;
import com.zhiyou.centerutils.FtpUtil;
import com.zhiyou.model.User;

@Controller
public class CenterController {
	@Autowired
	CenterService centerService;

	//跳转至个人中心页面
	@RequestMapping("foreground/PersonalCenter.do")
	public String PersonalCenter() {
		return "foreground/PersonalCenter";		
	}
	//跳转至修改密码页面
	@RequestMapping("foreground/PasswordUpdate.do")
	public String PasswordUpdate() {
		return "foreground/PasswordUpdate";		
	}
	//跳转至更改头像页面
	@RequestMapping("foreground/AvatarUpload.do")
	public String AvatarUpload() {
		return "foreground/AvatarUpload";		
	}
	//跳转至更改资料页面
	@RequestMapping("foreground/UserUpadte.do")
	public String UserUpadte() {
		return "foreground/UserUpdate";		
	}
	//前台修改密码方法
	@RequestMapping("passwordUpdate.do")
	public String updatePassword(String newPassword,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		System.out.println("修改密码的controller页面");
		User user = (User) req.getSession().getAttribute("user");
		newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
		User u = new User();
		u.setId(user.getId());
		u.setPassword(newPassword);
		centerService.update(u);      
		return "index";  
	}

	//前台验证密码是否重复rePasswordCheck
	@RequestMapping("/originalPasswordCheck.do")
	public void originalPasswordCheck(String originalPassword,HttpServletRequest req,HttpServletResponse resp) throws IOException{
//		System.out.println("验证密码的controller");
		User u = (User) req.getSession().getAttribute("user");
	    String password = DigestUtils.md5DigestAsHex(originalPassword.getBytes());
		boolean isExist;
		if(!((u.getPassword()).equals(password))){
            isExist=false;   
		}else {
			isExist=true;
		}
		//  因为在双引号里面，所以/"相当于一个"，或者使用'代替
		try {
			resp.getWriter().append("{\"isSuccess\":"+isExist+"}");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//前台验证密码是否重复
		@RequestMapping("/rePasswordCheck.do")
		public void rePasswordCheck(String newPassword,String rePassword,HttpServletRequest req,HttpServletResponse resp) throws IOException{
			System.out.println("验证两次输入密码是否一致的controller");
		    newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
		    rePassword = DigestUtils.md5DigestAsHex(rePassword.getBytes());
			boolean isExist;
			if(!(rePassword).equals(newPassword)){
	            isExist=false;   
			}else {
				isExist=true;
			}
			//  因为在双引号里面，所以/"相当于一个"，或者使用'代替
			try {
				resp.getWriter().append("{\"isSuccess\":"+isExist+"}");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	//前台进行图片的上传
	@RequestMapping(value="/uploadAvatar.do",method=RequestMethod.POST)
	public String uploadHead(@RequestParam("imageFile")MultipartFile imageFile,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		User user = (User) req.getSession().getAttribute("user");
		//生成新的文件名
		//取原始文件名
		String oldName  = imageFile.getOriginalFilename();
		//http://192.168.203.128/image/2019/08/18/1566095878886429.jpg
		System.out.println(user.getImgurl());
		String[] split = user.getImgurl().split("/");
		
		System.out.println(456);
		System.out.println(split[split.length-1]);
		//生成新文件名
		String newName = genImageName();
		newName = newName+oldName.substring(oldName.lastIndexOf("."));
		//图片上传
		String imagePath = new DateTime().toString("/yyyy/MM/dd");
		boolean result=FtpUtil.uploadFile("192.168.203.128", 21, "fandaozhuang", "250", "/home/fandaozhuang/image", 
				imagePath, newName, imageFile.getInputStream());
//		http://192.168.203.128/image/2019/08/17/1566038667689310.jpg
		String url="http://192.168.203.128/image"+imagePath+"/"+newName;	
		User u2 = new User();
		u2.setId(user.getId());
		u2.setImgurl(url);
		deleteFile(split[split.length-1], req, resp);
		centerService.update(u2); 
		req.getSession().setAttribute("user",u2);
		return "redirect:/foreground/PersonalCenter.do";
	}
	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	//删除文件
	public boolean deleteFile(String FileName,HttpServletRequest req,HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect("192.168.203.128", 21);// 连接FTP服务器
            ftp.login("fandaozhuang", "250");// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            System.out.println(123);
            System.out.println(user.getImgurl());
            ftp.makeDirectory(user.getImgurl());
            ftp.changeWorkingDirectory(user.getImgurl());
            success = ftp.deleteFile(FileName);
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }
	
	//修改个人资料
	   @RequestMapping("/userUpadte.do")
	   public ModelAndView updateFile(String nickname,String sex,String birthday, HttpServletRequest req,HttpServletResponse resp){	
		   ModelAndView mv = new ModelAndView();
	       User u = (User) req.getSession().getAttribute("user");
		   User user = new User();
		   user.setId(u.getId());
		   user.setNickname(nickname);
		   user.setSex(sex);
		   user.setBirthday(birthday);
		   user.setAccounts(u.getAccounts());
		   user.setAddress(u.getAddress());
		   centerService.update(user); 
		   req.getSession().setAttribute("user", user);
		   mv.setViewName("redirect:foreground/PersonalCenter.do");
		   return mv;	   
	   }
}
