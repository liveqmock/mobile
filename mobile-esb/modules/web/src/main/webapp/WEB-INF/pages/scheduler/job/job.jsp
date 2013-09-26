<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	<youi:grid id="grid_job" idKeys="schedName,triggerName,triggerGroup" dataFormId="form_job"
		src="/scheduler/job/getPagerSchedulerJobs.json" 
		editSrc="/scheduler/job/getSchedulerJob.json"
		removeSrc="/scheduler/job/removeSchedulerJob.json" panel="false"
		caption="调度列表">
		
		<youi:fieldLayout>
			<youi:fieldSelect  property="jobDetails.jobGroup" code="code" show="show" src="/scheduler/job/getJobProviders.json" caption="任务组"/>
			<youi:fieldText operator="LIKE" property="jobDetails.description" caption="任务描述"/>
		</youi:fieldLayout>
		
		<youi:gridCol property="jobDetails.jobGroup" width="160" caption="任务组"/>
		
		<youi:gridCol property="jobDetails.description" width="200" caption="任务描述"/>
		<youi:gridCol property="description" width="280" caption="调度描述"/>
		<youi:gridCol property="prevFireTime" type="date" width="130" caption="上次调度时间"/>
		<youi:gridCol property="nextFireTime" type="date" width="130" caption="下次调度时间"/>
		<youi:gridCol property="triggerState" width="60" convert="jobStauts" caption="调度状态" />
		
		<youi:button name="pause" caption="暂停"  submitAction="/scheduler/job/pause.json" active="1" order="201" icon="pause"/>
		<youi:button name="resume" caption="重启" submitAction="/scheduler/job/resume.json" active="1" order="202" icon="resume"/>
	</youi:grid>
	
	<youi:form dialog="true" id="form_job" caption="调度" 
		idKeys="schedName,triggerName,triggerGroup" action="/scheduler/job/saveSchedulerJob.json">
		<youi:fieldLayout prefix="record">
			
			<youi:fieldHidden property="schedName"/>
			<youi:fieldHidden property="cronTrigger.triggerName" caption="触发器"/>
			<youi:fieldHidden property="cronTrigger.triggerGroup" caption="触发器组"/>
			
			<youi:fieldSelect notNull="true" property="jobDetails.jobGroup" code="code" show="show" src="/scheduler/job/getJobProviders.json" caption="任务组"/>
			<youi:fieldText notNull="true" property="jobDetails.jobName" caption="任务名"/>
			
			<youi:fieldText notNull="true" column="2" width="602" property="jobDetails.description" caption="任务描述"/>
			<youi:fieldText notNull="true" column="2" width="602" property="description" caption="调度描述"/>
			
			<youi:fieldCalendar property="startTime" format="millis" caption="开始时间"/>
			<youi:fieldCalendar property="endTime" format="millis" caption="结束时间"/>
			
			<youi:fieldCustom custom="fieldCron" customOptions="{}" column="2" width="602" property="cronTrigger.cronExpression" caption="调度周期"/>
		</youi:fieldLayout>
	</youi:form>
	
	<!--**********************************页面内容********************************-->
		
		
	<!--**********************************页面函数********************************-->
	
	<!--**********************************页面函数********************************-->
</youi:page>