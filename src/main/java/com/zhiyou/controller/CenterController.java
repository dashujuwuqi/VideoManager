package com.zhiyou.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.User;
import com.zhiyou.service.center.CenterService;

@Controller
public class CenterController {
	@Autowired
	CenterService centerService;
//	//用户的前台登录功能临时使用
//    @RequestMapping("havelogin")
//    public String HaveLogin(String name,String password) throws Exception{
//   	     System.out.println(name);
//   	     System.out.println(password);
//   	     
// 	return "forward";  
//    }
    
    //前台修改密码方法
    @RequestMapping("updatePassword")
    public String updatePassword(String newPassword,HttpServletRequest req,HttpServletResponse resp) throws Exception{
 	    User user = (User) req.getSession().getAttribute("user");
         User u = new User();
         u.setId(user.getId());
         u.setPassword(newPassword);
 		 centerService.update(u);    
// 	   if(user!=null){
// 		   req.getSession().setAttribute("user", user);
// 		   return "forward:/index.jsp"; 
// 	   }	   
 	return "forward:/index.jsp";  
    }
    
    //前台验证密码是否重复
    @RequestMapping("/validataController")
    public void validataController(String Password,HttpServletRequest req,HttpServletResponse resp) throws IOException{
        User u = (User) req.getSession().getAttribute("user");
        if(!((u.getPassword()).equals(Password))){
     	   resp.getWriter().write("1"); 	   
     	   return;
        }
        resp.getWriter().write("2");
    }
    
    //前台进行图片的上传
    @RequestMapping("/uploadHead")
    public String uploadHead(MultipartFile file,HttpServletRequest req,HttpServletResponse resp) throws IOException{
        User u = (User) req.getSession().getAttribute("user");
        String name="d:/ssm/image/"+file.getOriginalFilename();
        String string=file.getOriginalFilename();
        String url ="http://localhost:8080/imageurl/";
        url=url+string ;
        try {
     	   u.setImgurl(url);
     	  centerService.update(u);
 	   } catch (Exception e) {
 		// TODO: handle exception
 	   }       
        req.getSession().setAttribute("user", u);
        
 		//自动获取了输入流输出流
 		file.transferTo(new File(name));
        return "redirect:/updateHead.jsp";
    }
}
