<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:html i18n="i18n.index" title="i18n.index.title">
	<head>
		<%@ include file="/WEB-INF/pages/common/commonScriptAndCss.jsp"%>
		
		<script type="text/javascript">
			$(function(){
				
				$.extend($.youi,{
					
					/**
					 * 定时处理工具集合
					 */
					timerUtils:{
						
						/**
						 * 阻塞模式执行定时的操作
						 */
						blocktimer:function(options){
							//定时执行函数
							var timerExec = function (){
								return function(hooks){
									var timeout = setTimeout( internalTimer, options.time );
									if(!hooks.stop){//设置stop函数
										hooks.stop = function() {
											//清理timeout
											clearTimeout( timeout );
											//执行销毁操作
											this.destroy();
										};
									}
								};
							};
							//方法内的共享对象
							var hooks = {
								timerCount:0,
								stopFlag:false,
								/**
								 * 下一个
								 */
								next:function(){
									this.timerCount++;
									
									if(this.forceStop()==true){
										this.stop();
									}else{
										//普通模式
										if(options.url){
											$.youi.ajaxUtil.ajax({
												url:options.url,
												data:options.params,
												hook:this,
												success:function(result){
													//ajax模式执行回调函数
													this.hooks.run(result);
												}
											});
										}else{
											this.run({});
										}
									}
								},
								
								run:function(result){
									try{
										options.callback.apply(window,[this.timerCount,result]);
									}catch(err){
										//强制停止执行
										this.stopFlag = true;
									}
								},
								
								forceStop:function(){
									return this.stopFlag==true||options.forceStop.apply(window,[hooks.timerCount]);
								},
								destroy:function(){
									delete this.timerCount;
									delete this.stopFlag;
								}
							};
							
							timerExec()(hooks);
							//window.setTimeout 调用的内部函数
							function internalTimer(){
								hooks.next();
							}
						}
					}
				});
				$.youi.logLevel = 4;
				/**
				$.youi.timerUtils.blocktimer({
					time:1000,
					callback:function(count){
						$.youi.log.info(count);
					},
					forceStop:function(count){
						return count>10;
					}
				});*/
			});
		</script>
	</head>
	<youi:body>
		
	</youi:body>
</youi:html>