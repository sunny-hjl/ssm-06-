package com.ssm.comtroller;


import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.InternetPrinter;
import com.ssm.service.InternetPrinterService;
import com.ssm.util.PageData;
import com.ssm.util.PageUtil;


@Controller

public class InternetPrinterController {

	@Autowired
	private InternetPrinterService internetPrinterService;
	
	public ModelAndView pageList(InternetPrinter internetprinter,String page,String pageSize){
		ModelAndView model=new ModelAndView();
		try {
			//查询
			List<InternetPrinter> list=this.internetPrinterService.selectInternetPrinter();
			 	PageData pd=new PageData();
				int count=0;
				PageUtil  pageUtil=new PageUtil();
				
				if(page==null||page.equals(""))
				{
					page="1";
				}
				//pageSize定义一页显示几个
				if(pageSize==null||pageSize.equals(""))
				{
					pageSize="3";
				}
				List<InternetPrinter> list1=pageUtil.getList(list, Integer.parseInt(page), Integer.parseInt(pageSize));
				count=(int) Math.ceil(list.size()/Double.parseDouble(pageSize));
				pd.put("page", page);
				pd.put("pageSize", pageSize);
				pd.put("count", count);
				pd.put("url", "internetprinter");
				model.addObject("list",list1);
				model.addObject("pd",pd);
				model.setViewName("InternetPrinter/internetprinter"); 
		} catch (Exception e) {
			e.printStackTrace();
			model.addObject("msg","error");
		}
		return model;		
	}
	
	
	//网络配置的列表
		@RequestMapping(value = "/internetprinter")
		public ModelAndView subjectSelect(InternetPrinter internetprinter,String page,String pageSize)
		{
			return this.pageList(internetprinter, page, pageSize);		
		}
	
	
	
	
	/*//查询所有
	@RequestMapping(value = "/internetPrinterlist")
	public ModelAndView internetPrinterlist(){
		ModelAndView model = new ModelAndView("internetprinter/internetprinter");
		List<InternetPrinter>list = internetPrinterService.selectInternetPrinter();
		for (InternetPrinter internetPrinter : list) {
			System.out.println(internetPrinter);
		}
		model.addObject("list",list);
		return model;
	}*/
	//跳转到增加页
	@RequestMapping(value="/turninternetPrinterAdd")
	public ModelAndView turnInternetPrinterAdd(){
		ModelAndView model = new ModelAndView("InternetPrinter/internetprinter_add");
		return model;
	}
	//增加网络配置
	@RequestMapping(value="/internetPrinterAdd")
	public ModelAndView InternetPrinterAdd(String IID,String IName,String PrintIp,String IAddTiem,String role,String IRamark) throws ParseException{
		int I_ID=Integer.parseInt(IID);
		
		java.sql.Date iaddtiem=java.sql.Date.valueOf(IAddTiem);
		
		InternetPrinter internetprinter = new InternetPrinter();
		
		internetprinter.setIID(I_ID);
		internetprinter.setIName(IName);
		internetprinter.setPrintIP(PrintIp);
		internetprinter.setIAddTime(iaddtiem);
		internetprinter.setIRole(role);
		internetprinter.setIRamark(IRamark);
		internetPrinterService.insertInternetPrinter(internetprinter);
		String page=null;
		String pageSize=null;
		return this.pageList(internetprinter, page, pageSize);
		}
	
	//删除网络配置
		@RequestMapping(value="/internetprinterdelete")
		public ModelAndView deleteInternetPrinter(String IID){
			int I_ID=Integer.parseInt(IID);
			internetPrinterService.deleteInternetPrinter(I_ID);
			InternetPrinter internetprinter = new InternetPrinter();
			String page=null;
			String pageSize=null;
			return this.pageList(internetprinter, page, pageSize);
		}
		
	//跳转到修改页	
		@RequestMapping(value="/turnupdate")
		public ModelAndView turnHandterminalUpdate(String IID,String IName,String printIP,String IAddTime,String IRole,String IRamark){
			ModelAndView model = new ModelAndView("InternetPrinter/internetprinteredit");
			
			//复选框的选中状态
			String[] rolesnew={"前排坐垫面套","前排靠背面套","前排坐垫骨架","前排靠背骨架","插单物料排序单","前排线束","前排大背板","后40靠背面套","后60靠背面套","后坐垫坐垫面套","后60扶手","后60中头枕","后40侧头枕","后60侧头枕"};		
			Map<String,Object> map=new HashMap<String, Object>();
			for (int i = 0; i < rolesnew.length; i++) {
				map.put(rolesnew[i], IRole.contains(rolesnew[i])?"checked='checked'":"");
			}
			model.addObject("status",map);
			
			
			java.sql.Date iaddtiem=java.sql.Date.valueOf(IAddTime);
			int I_ID=Integer.parseInt(IID);
			
			InternetPrinter internetprinter = new InternetPrinter();
			internetprinter.setIID(I_ID);
			internetprinter.setIName(IName);
			internetprinter.setPrintIP(printIP);
			internetprinter.setIAddTime(iaddtiem);
			internetprinter.setIRole(IRole);
			internetprinter.setIRamark(IRamark);
			model.addObject("internetprinter1",internetprinter);
			System.out.println(internetprinter);
			model.addObject("IID",IID);
			model.addObject("IAddTime",iaddtiem);
		return model;
		}
		
		//修改网络配置
		@RequestMapping(value="/internetPrinterupdate")
		public ModelAndView internetPrinterupdate(String IID,String IName,String PrintIp,String IAddTiem,String role,String IRamark)throws ParseException{
			int I_ID=Integer.parseInt(IID);
			
			java.sql.Date iaddtiem=java.sql.Date.valueOf(IAddTiem);
			
			InternetPrinter internetprinter = new InternetPrinter();
			
			internetprinter.setIID(I_ID);
			internetprinter.setIName(IName);
			internetprinter.setPrintIP(PrintIp);
			internetprinter.setIAddTime(iaddtiem);
			internetprinter.setIRole(role);
			internetprinter.setIRamark(IRamark);
			internetPrinterService.updateInternetPrinter(internetprinter);
			String page=null;
			String pageSize=null;
			return this.pageList(internetprinter, page, pageSize);
		}
}
