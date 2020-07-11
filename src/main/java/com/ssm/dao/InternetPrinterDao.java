package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.entity.InternetPrinter;
@Repository("InternetPrinterDao")
public interface InternetPrinterDao {
		//查询所有
		public List<InternetPrinter> selectInternetPrinter(); 
		//查询单个
		public void selectInternetPrinterOne(int IID);
		//增加
		public void insertInternetPrinter(InternetPrinter internetprinter);
		//更新
		public void updateInternetPrinter(InternetPrinter internetprinter);
		//删除
		public void deleteInternetPrinter(int IID);
}
