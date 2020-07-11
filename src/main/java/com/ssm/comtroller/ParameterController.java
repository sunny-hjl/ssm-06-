package com.ssm.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.Parameter;
import com.ssm.service.ParameterService;

@Controller
public class ParameterController {
	@Autowired
	private ParameterService parameterService;
	
	//查询所有
		@RequestMapping(value = "/parameterlist")
		public ModelAndView Parameterlist(){
			ModelAndView model = new ModelAndView("parameter/parameter");
			List<Parameter>list = parameterService.selectParameter();
			model.addObject("list",list);
			return model;
		}	
		//上移功能
		@RequestMapping("shiftup")
		public ModelAndView shiftUp(String SerialID){
			int I_ID=Integer.parseInt(SerialID);
				
			Parameter parameter= parameterService.selectParameterOne(I_ID);
			 //判断该数据前一条数据不为空（实现最顶端数据不可上移）
			if(parameterService.selectParameterOne(I_ID-1)!=null){

			Parameter parameter2 = parameterService.selectParameterOne(I_ID-1);
			Parameter parameter3 = new Parameter();
			parameter3.setName(parameter.getName());
			parameter3.setNumber(parameter.getNumber());
			
			
			parameter.setName(parameter2.getName());
			parameter.setNumber(parameter2.getNumber());
			
			parameter2.setName(parameter3.getName());
			parameter2.setNumber(parameter3.getNumber());
			
			
			parameterService.updateParameter(parameter2);
			parameterService.updateParameter(parameter);
			
			}
			//完成操作后返回物料排序单参数配置界面
			ModelAndView model = new ModelAndView("parameter/parameter");
			List<Parameter>list = parameterService.selectParameter();
			model.addObject("list",list);
			return model;
		}
		//下移功能
		@RequestMapping("movedown")
		public ModelAndView movedown(String SerialID){
			int I_ID=Integer.parseInt(SerialID);
			
			Parameter parameter= parameterService.selectParameterOne(I_ID);
			
			//判断该数据前一条数据不为空（实现最顶端数据不可上移）
			if(parameterService.selectParameterOne(I_ID+1)!=null){
			Parameter parameter2= parameterService.selectParameterOne(I_ID+1);
			
			Parameter parameter3 = new Parameter();
			parameter3.setName(parameter.getName());   //原始ID数据
			parameter3.setNumber(parameter.getNumber());
			
			
			parameter.setName(parameter2.getName());    //上一个节点数据
			parameter.setNumber(parameter2.getNumber());
			
			parameter2.setName(parameter3.getName());   //上一个ID的原始ID的名称和数量
			parameter2.setNumber(parameter3.getNumber());
			
			parameterService.updateParameter(parameter);
			parameterService.updateParameter(parameter2);
			}
			//完成操作后返回物料排序单参数配置界面
			ModelAndView model = new ModelAndView("parameter/parameter");
			List<Parameter>list = parameterService.selectParameter();
			model.addObject("list",list);
			return model;
	}
		//跳转到修改页
	@RequestMapping(value="/turnparameterupdate")
	public ModelAndView turnHandterminalUpdate(String serialID,String name,String number){
		ModelAndView model = new ModelAndView("parameter/parameteredit");
		int serial_ID=Integer.parseInt(serialID);
		Parameter parameter = new Parameter();
		parameter.setName(name);
		parameter.setNumber(number);
		parameter.setSerialID(serial_ID);
		model.addObject("parameter1",parameter);
	return model;
	}
	@RequestMapping(value="/parameterupdate")
	public ModelAndView handterminalupdate(String SerialID,String Name,String Number){
		
		System.out.println(SerialID+"+"+Name+"+"+Number);
		int serial_ID=Integer.parseInt(SerialID);
		Parameter parameter = new Parameter();
		parameter.setName(Name);
		parameter.setNumber(Number);
		parameter.setSerialID(serial_ID);
		System.out.println(parameter);
		parameterService.updateParameter(parameter);
		ModelAndView model = new ModelAndView("parameter/parameter");
		List<Parameter>list = parameterService.selectParameter();
		model.addObject("list",list);
		return model;
	}
}