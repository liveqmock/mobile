package com.gsoft.mobile.manager.service.impl;


import java.text.DecimalFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.TerminatedRetryException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.mobile.core.entity.AccInf;
import com.gsoft.mobile.core.entity.ClientInf;
import com.gsoft.mobile.core.entity.DayTraInf;
import com.gsoft.mobile.core.entity.MerInf;
import com.gsoft.mobile.core.entity.ParamInf;
import com.gsoft.mobile.core.entity.SignInf;
import com.gsoft.mobile.core.service.AccInfManager;
import com.gsoft.mobile.core.service.ClientInfManager;
import com.gsoft.mobile.core.service.DayTraInfManager;
import com.gsoft.mobile.core.service.HisTraInfManager;
import com.gsoft.mobile.core.service.MerInfManager;
import com.gsoft.mobile.core.service.SignInfManager;
import com.gsoft.mobile.manager.dao.DayTemInfDao;
import com.gsoft.mobile.manager.entity.DayTemInf;
import com.gsoft.mobile.manager.entity.QrCodePayInf;
import com.gsoft.mobile.manager.entity.TerInf;
import com.gsoft.mobile.manager.service.LoginManager;
import com.gsoft.mobile.manager.service.QrCodePayManager;
import com.gsoft.mobile.manager.service.TerInfManager;
@Service("qrCodePayManager")
@Transactional
public class QrCodePayManagerImpl extends BaseManagerImpl implements QrCodePayManager {
	@Autowired
	private AccInfManager accInfManager;
	@Autowired
	private MerInfManager merInfManager;
	
	@Autowired
	private SignInfManager signInfManager;
	@Autowired
	private  DayTraInfManager dayTraInfManager;
	@Autowired
	private  TerInfManager terInfManager;

	@Autowired
	private  HisTraInfManager hisTraInfmanager;
	@Autowired
	private LoginManager loginManager;
	@Autowired
	private DayTemInfDao<DayTemInf, String> dayTemInfDao;
	
	

	/**
	 * 单方面    客户付款 更新帳戶表
	 */
	@Override
	@EsbServiceMapping
	public boolean pay(@ServiceParam(name="payCard") String payCard,
			@ServiceParam(name="payAmount") String payAmount,
			@ServiceParam(name="pwd") String pwd) throws BusException {
		return false;
	}
   /**
     * 商户    
   */
	@Override
	@EsbServiceMapping
	public Message receive(DayTemInf dayTemInf) throws BusException {
		if (!checkValide(dayTemInf)) {
			return new Message("999999", "未上送必输字段");
		} else {
			// 是否违反签约协议
			// 验证商户=收款方 的正确性
			try {
				boolean receiveValide = checkCard(dayTemInf.getReceiveCard(), 0,dayTemInf.getTerminalNo())
						&& checkSignInf(dayTemInf.getReceiveCard(),dayTemInf.getTradeAmo(), 0);
			} catch (Exception e) {
				return new Message("999999", "商户账户信息不正确或者违反签约协议");
			}
		
		}
		long size = dayTemInfDao.getAll().size();//获取数据库记录数
	    if(size >= 999999999){//如果记录数超过10位数  就重置为0
			size = size - size/999999999 * 999999999;
		}
		String serialNo = String.format("%010d", size+1);
		dayTemInf.setTranNo(serialNo);
		dayTemInf.setTranState("00");
		dayTemInfDao.save(dayTemInf);
		return new Message("000000", serialNo);
	}
	
	/**
	 * 收款信息查询
	 * */
	@EsbServiceMapping
	public Message qryPayDayTemInf(DayTemInf dayTemInf) throws BusException {
		DayTemInf info = (DayTemInf) dayTemInfDao.getObjectByUniqueProperty(
				"tranNo", dayTemInf.getTranNo());
		if(info!=null){
		if(info.getTranState().equals("01")){
			return new Message("000000", "已付款");
		}else{
			return new Message("999999", "未付款付款");
		}
		}else{
			return new Message("999999", "出错啦");
		}
	}
	
	/**
	 * 付款
	 * */
	@EsbServiceMapping
	public Message savePayDayTemInf(DayTemInf dayTemInf) throws BusException {
		DayTemInf info = (DayTemInf) dayTemInfDao.getObjectByUniqueProperty("tranNo", dayTemInf.getTranNo());
		QrCodePayInf QrCodePay = new QrCodePayInf();
		
		QrCodePay.setPayCard(dayTemInf.getPayCard()); // 付款账号
		QrCodePay.setPassword(dayTemInf.getPayPassword()); // 支付密码
		QrCodePay.setPayTerminalNo(dayTemInf.getTerminalNo()); // 终端编号 付款方
		QrCodePay.setReceiveTerminalNo(info.getTerminalNo()); // 终端编号 收款方
		QrCodePay.setTranPosition(dayTemInf.getTranPosition());// 交易位置
		QrCodePay.setCurrType(dayTemInf.getCurrType());// 货币类型
		QrCodePay.setBelongInst(dayTemInf.getBelongInst());// 所属机构
		QrCodePay.setTermSeq(dayTemInf.getTermSeq()); // 终端流水号
		if (info != null) {
			//防止第二次收款方不是第一次的收款方即有人改包，将收款方账号改包
			QrCodePay.setReceiveCard(info.getReceiveCard()); // 收款账号
			QrCodePay.setTradeAmount(info.getTradeAmo()); // 交易金额
			QrCodePay.setTranReason(info.getTranReason()); // 交易事由
			if (info.getTranState().equals("00")) {//00未付款  01已付款 02 取消
				Message messageCode = trade(QrCodePay);
				if (messageCode.getCode().equals("000000")) {
					
					info.setTranState("01");
					info.setPayCard(dayTemInf.getPayCard());
					dayTemInfDao.save(info);
					return new Message("000000", "亲，钱已经付完啦 ");
				} else {
					String messageinfo = "[" + messageCode.info + "]";
					return new Message(messageCode.code, messageinfo);

				}

			} else if(info.getTranState().equals("01")) {
				return new Message("999999", "亲，已经付款了用再麻烦了");
			}else{
				return new Message("999999", "亲，该交易已取消");
			}
		} else {
			return new Message("999999", "亲，我没有找到待付款信息，请你确认下");
		}
	}
    /**
     *付款交易 
     */
	
	private Message trade(QrCodePayInf qrCodePayInf) {
		//  检验数据有效性、必输条件
		if(!checkValide(qrCodePayInf)){
			return new Message("999999", "未上送必输字段");
		}else{
			
			//  是否违反签约协议
			//验证客户=付款方 的正确性
			boolean payValide;
			try{
				payValide = checkCard(qrCodePayInf.getPayCard(),1,qrCodePayInf.getPayTerminalNo())&&checkSignInf(qrCodePayInf.getPayCard(),qrCodePayInf.getTradeAmount(),1);
			}catch (Exception e) {
				return new Message("999999", "客户账户信息不正确或者违反签约协议    ");
			}
			boolean receiveValide;
			//验证商户=收款方 的正确性
			try {
				receiveValide = checkCard(qrCodePayInf.getReceiveCard(),0,qrCodePayInf.getReceiveTerminalNo())&&checkSignInf(qrCodePayInf.getReceiveCard(),qrCodePayInf.getTradeAmount(),0);
			} catch (Exception e) {
				return new Message("999999", "商户账户信息不正确或者违反签约协议");
			}
			if(payValide&&receiveValide){
				try {
					// 调用银行接口  验证密码  完成收付款交易
					Record result = tradeInBank(qrCodePayInf);
					//  往交易明细表里插入记录 
					if((Boolean)result.get("result")){//交易成功
						//  更新账户信息表余额数据
						updateAmount(qrCodePayInf.getPayCard(),qrCodePayInf.getReceiveCard(),qrCodePayInf.getTradeAmount(),result.get("payBalance").toString(),result.get("receiveBalance").toString());
						qrCodePayInf.setRespCode("000000");
						qrCodePayInf.setTranState(ParamInf.tranState.get("normal"));
						
					}else{
						qrCodePayInf.setRespCode("999999");
						qrCodePayInf.setTranState(ParamInf.tranState.get("fail"));
					}
					qrCodePayInf.setRemark(result.get("remark").toString());//银行返回的备注
					qrCodePayInf.setSysSeqno(result.get("sysSeqno").toString());//银行返回的系统流水号
					insertTradeDetail(qrCodePayInf);//明细表里加入记录
					return new Message(qrCodePayInf.getRespCode(), qrCodePayInf.getRemark());
				} catch (BusException e) {
					return new Message("999999","交易失败，请联系管理员");
				}
			}
			
		}
		return new Message("999999","交易失败，请联系管理员");
	}
	/**
	 * 往交易明细表里插入记录 
	 */
	public void insertTradeDetail(QrCodePayInf qrCodePayInf){
		DecimalFormat df =new DecimalFormat("0.00");
		DayTraInf o =new DayTraInf();
		//计算商户应付手续费
		double  serviceCharge = 0.0;//手续费  存入当日流水表
		MerInf merInf = merInfManager.getMerInfByCardNum(qrCodePayInf.getReceiveCard());
		if(merInf.getServiceChargeType().trim().equals(ParamInf.serviceChargeType.get("month"))){//按月份收费
			//和交易无关  每月从账户减钱
			//receiveMoney = getAmount(tradeAmount);
		}else if(merInf.getServiceChargeType().trim().equals(ParamInf.serviceChargeType.get("tranrate"))){//按交易率
			
			serviceCharge = getAmount(qrCodePayInf.getTradeAmount())*getAmount(merInf.getServiceChargeRate())/100;//数据库里存的是百分比的
		}else {//暂不收费
			//receiveMoney = getAmount(tradeAmount);
		}
		
		//需要后台生成的
		o.setTranDate(DateUtils.getToday("yyyyMMdd"));//交易日期
		o.setTranTime(DateUtils.getToday("HHmmss"));//交易时间
		o.setPlatSeq(generateSeq());//平台流水号  = 时间戳13位+序列号6位
		o.setServiceCharge(df.format(serviceCharge));//手续费 变成以分为单位
		
		//后台赋值的
		o.setRespCode(qrCodePayInf.getRespCode());//响应吗
		o.setTranState(qrCodePayInf.getTranState());//交易状态
		o.setRemark(qrCodePayInf.getRemark());//备注
		o.setSysSeqno(qrCodePayInf.getSysSeqno());//系统流水号
		
		//需要前端传入的
		o.setTradeAmount(qrCodePayInf.getTradeAmount().toString());
		o.setPayCard(qrCodePayInf.getPayCard());
		o.setReceiveCard(qrCodePayInf.getReceiveCard());
		o.setTranReason(qrCodePayInf.getTranReason());
		o.setTermSeq(qrCodePayInf.getTermSeq());
		o.setCurrType(qrCodePayInf.getCurrType());
		o.setTranPosition(qrCodePayInf.getTranPosition());
		o.setTerminalNo(qrCodePayInf.getPayTerminalNo());
		
		dayTraInfManager.saveDayTraInf(o);
	}
	/**
	 * 更新账户余额
	 * @param payCard
	 * @param receiveCard
	 * @param tradeAmount paybalance receiveBalance 从前台和银行传来的金额   以元为单位
	 * @throws BusException
	 */
	private void updateAmount(String payCard, String receiveCard ,String tradeAmount,String paybalance ,String receiveBalance) throws BusException{
		//更新客户的账户信息
		AccInf payAccInf = accInfManager.getAccInf(payCard);
		if(payAccInf !=null){
			//在这不用从银行取最新的余额
			//Record payRecord = getBalanceInBank(payCard);
			
			double balance = getAmount(paybalance)- getAmount(tradeAmount);//账户余额减去应付金额
			payAccInf.setBalance(Double.toString(balance));
			accInfManager.saveAccInf(payAccInf); 
		}
		
		//更新商户的账户信息
		//更新帳戶表
		AccInf merAccInf = accInfManager.getAccInf(receiveCard);
		if(merAccInf !=null){
			//Record receiveRecord = getBalanceInBank(receiveCard);
			double balance = getAmount(paybalance) + getAmount(tradeAmount);//账户余额加上本次交易金额
			merAccInf.setBalance(Double.toString(balance));
			accInfManager.saveAccInf(merAccInf); 
		}
		
		//更新商户每日收单余额 dailyProcBala
		MerInf merInf = merInfManager.getMerInfByCardNum(receiveCard);
		double dayProcAmount = dayTraInfManager.getDayTraAmountByDate(receiveCard, null, DateUtils.getToday("yyyyMMdd"));//商户今天已收单金额
		double dailyProcBala = getAmount(merInf.getDailyProcLimit()) - dayProcAmount - getAmount(tradeAmount);//商户每日收单余额
		merInf.setDailyProcBala(Double.toString(dailyProcBala));
		merInfManager.saveMerInf(merInf);
	}
	
	/**
	 * 检验是否违反协议
	 * 	  flag商户、客户标识(0:商户，1：客户)
	 */
	public boolean checkSignInf(String cardNum,String tradeAmount ,int flag) throws BusException{
		//获取账号
		AccInf accInf = accInfManager.getAccInf(cardNum);
	    Assert.notNull(accInf, "账户不存在！");
		//获取有效交易金额
		double amount = getAmount(tradeAmount);
		//获取当天日期
		String trandate = DateUtils.getToday("yyyyMMdd");
		if(flag==0){//商户
			MerInf merInf = merInfManager.getMerInfByCardNum(cardNum);
			//判断商户签约信息的金额限制
			double daliyAmount = amount + dayTraInfManager.getDayTraAmountByDate(cardNum, null, trandate);//该卡今天已经成功消费额度
			if(amount > getAmount(merInf.getSingleProcLim())||daliyAmount > getAmount(merInf.getDailyPayLimit()) ){//交易额不能超单笔签约收单限额  、每日交易限额
				throw new BusException("商户交易额度超限！");
			}
			return true;
		}else if(flag==1){//客户 付款
			//判断客户账户余额
			//ClientInf clientInf = clientInfManager.getClientInfByBankcardNum(cardNum);
			//从银行查余额 或者不判断余额    在核心系统做交易时 失败 返回失败信息
			Record record= getBalanceInBank(cardNum);
			if(amount > getAmount((record.get("balance").toString()))){
				throw new BusException("账户余额不足！");
			}
			//判断客户签约信息的金额限制
			SignInf signInf = signInfManager.getSignInfByCardNo(cardNum, ParamInf.signBusiness.get("payTreaty"));//根据卡号和签约业务查出唯一的签约记录
			Assert.notNull(signInf, "未找到签约记录");
			double singlePayLimit =getAmount(signInf.getSinglePayLimit());//单笔交易限额
			double dailyPayLimit =getAmount(signInf.getDailyPayLimit());//每日交易限额
			double daliyAmount = amount + dayTraInfManager.getDayTraAmountByDate(null, cardNum, trandate);//查当日交易表  该卡今天已经消费额度
			if(amount > singlePayLimit||daliyAmount >dailyPayLimit){//交易额不能超单笔签约交易限额  、每日交易限额
				throw new BusException("客户交易额度超限！");
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 判断账户和商户、客户、终端状态是否存在且状态是否正常 
	 * flag商户、客户标识(0:商户，1：客户)
	 * @param cardNum卡号
	 * @return
	 */
	public boolean checkCard(String cardNum,int flag,String terminalNo) throws BusException{
		// 判断账户
		AccInf accInf = accInfManager.getAccInf(cardNum);
		// AccountState 账户状态 00 正常 01 取消
		if (accInf != null && ParamInf.accountState.get("normal").equals(accInf.getAccountState())) {// 如果账户状态正常
			// 判断账户所属的商户或者客户的有效性
			if(flag==0){//商户  还要判断终端状态
				MerInf merInf = merInfManager.getMerInfByCardNum(cardNum);
				TerInf terInf = terInfManager.getTerInf(terminalNo);
				//如果商户存在且终端存在而且状态都正常
				if (merInf != null && ParamInf.merState.get("normal").equals(merInf.getMerState())&&terInf!=null&&ParamInf.terminalState.get("normal").equals(terInf.getTerminalState())){
					return true;
				}else{
					throw new BusException("商户不存在或状态不正常");
				}
			}else if(flag==1){//客户
				ClientInf clientInf = null;
				Object object = loginManager.getObjectInfByBankcardNum(cardNum);
				if(object instanceof ClientInf) {
					clientInf =(ClientInf)object;
				}
				//客户不为空、客户状态正常、客户使用终端状态正常
				if(clientInf != null && ParamInf.clientState.get("normal").equals(clientInf.getClientState())
						&&ParamInf.terminalState.get("normal").equals(clientInf.getTerminalState())){
					return true;
				}else{
					throw new BusException("客户不存在或状态不正常");
				}
			}
		}else{
			throw new BusException("账户不存在或状态异常");
		}
		return false;
	}
	/**
	 *判断做支付交易时移动端必送字段的  非空性 
	 */
	private boolean checkValide(QrCodePayInf qrCodePayInf){
		boolean isEmpty = StringUtils.isEmpty(qrCodePayInf.getPayCard())||StringUtils.isEmpty(qrCodePayInf.getPassword())
		                  ||StringUtils.isEmpty(qrCodePayInf.getReceiveCard())||StringUtils.isEmpty(qrCodePayInf.getTradeAmount())
		                  ||StringUtils.isEmpty(qrCodePayInf.getTranReason())||StringUtils.isEmpty(qrCodePayInf.getPayTerminalNo())||StringUtils.isEmpty(qrCodePayInf.getReceiveTerminalNo());
		if(!isEmpty){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证生成key时必须上送的字段
	 * */
	private boolean checkValide(DayTemInf dayTemInf){
		if(dayTemInf!=null){
			boolean isEmpty = StringUtils.isEmpty(dayTemInf.getReceiveCard())
            ||StringUtils.isEmpty(dayTemInf.getTradeAmo())
            ||StringUtils.isEmpty(dayTemInf.getTranReason())
            ||StringUtils.isEmpty(dayTemInf.getTerminalNo());
			if(!isEmpty){
				return true;
			}
			return false;
			
		}else{
			
			return false;
		}
		
	}
	
	
	
	/**
	 * 将金额转换成数字，顺便判断是否位数字
	 */
	public  double getAmount(String tradeAmount){
		double amount ;
		DecimalFormat df=new DecimalFormat("0.00");
		try {
		 double amount1 = Double.parseDouble(tradeAmount.trim());
		 amount = new Double(df.format(amount1));
			if(amount<0){
				throw new BusException("交易金额小于0");
			}
		} catch (Exception e) {
			throw new BusException("交易金额数字不正确");
		}
		return amount;
	}

	/**
	 * 调用银行接口    验证密码 完成收付款交易
	 * 
	 */
	private Record tradeInBank(QrCodePayInf qrCodePayInf) {
		Record record = new Record();
		//调用银行接口  将返回字段封装在record里
		
		if (PasswordUtils.md5Password(qrCodePayInf.getPassword()).equals("e10adc3949ba59abbe56e057f20f883e")) {
			record.put("payBalance", "9999.09");//两个余额必须回送
			record.put("receiveBalance", "9999.09");
            record.put("remark", "交易成功");
            record.put("sysSeqno", "1234567890");//系统流水号
			record.put("result", true);
		}else{
			record.put("payBalance", "9999.09");
			record.put("receiveBalance", "9999.09");
			record.put("remark", "密码不正确");
			record.put("sysSeqno", "9876543210");//系统流水号
			record.put("result", false);
		}
		return record;
	}
	/**
	 * 调用银行接口   查询账户余额
	 * 
	 */
	private Record getBalanceInBank(String bankCardNo) {
		Record record = new Record();
		//调用银行接口  将返回字段封装在record里
		record.put("balance", "9999.09");
		return record;
	}
	/**
	 * 生成流水序列号
	 */
	private String generateSeq(){
		String s = Long.toString(Calendar.getInstance().getTimeInMillis());
		long size = hisTraInfmanager.getHisTraInfs().size()+dayTraInfManager.getDayTraInfs().size();//获取数据库记录数
	    if(size >= 999999){//如果记录数超过6位数  就重置为0
			size = size - size/999999 * 999999;
		}
		String serialNo = String.format("%06d", size+1);
		return s+serialNo;
	}
	
//	public static void main(String[] args) {
//		QrCodePayInf qrCodePayInf = new QrCodePayInf();
//		qrCodePayInf.setPassword("123");
//		
//		QrCodePayManagerImpl q=new QrCodePayManagerImpl();
//		Record record = q.tradeInBank(qrCodePayInf);
//		
//		System.out.println(record.get("result"));
//	}
}
