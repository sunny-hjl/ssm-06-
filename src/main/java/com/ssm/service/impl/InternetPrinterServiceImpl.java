package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.InternetPrinterDao;
import com.ssm.entity.InternetPrinter;
import com.ssm.service.InternetPrinterService;
@Service
public class InternetPrinterServiceImpl implements InternetPrinterService{

	@Autowired
	private InternetPrinterDao internetPrinterDao;
	
	@Override
	public List<InternetPrinter> selectInternetPrinter() {
		return internetPrinterDao.selectInternetPrinter();
	}

	@Override
	public void selectInternetPrinterOne(int IID) {
		internetPrinterDao.selectInternetPrinterOne(IID);
		
	}

	@Override
	public void insertInternetPrinter(InternetPrinter internetprinter) {
		internetPrinterDao.insertInternetPrinter(internetprinter);
		
	}

	@Override
	public void updateInternetPrinter(InternetPrinter internetprinter) {
		internetPrinterDao.updateInternetPrinter(internetprinter);
	}

	@Override
	public void deleteInternetPrinter(int IID) {
		internetPrinterDao.deleteInternetPrinter(IID);
		
	}

}
