package com.dq.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/5
 * @Description: TODO
 */
public class TestHelloQuartz {
    public static void main(String[] args) throws SchedulerException {
        // 1.创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 2.构建helloQuartz实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail helloQuartz = JobBuilder.newJob(HelloQuartz.class).withIdentity("helloQuartz", Scheduler.DEFAULT_GROUP).build();

        // 3.构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("helloTrigger", "helloTriggerGroup")
                //立即生效
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        //cronSchedule("0 0/2 8-17 * * ?") // 每天8:00-17:00，每隔2分钟执行一次
                        //每隔3s执行一次:withIntervalInSeconds(3)
                        //每小时执行一次withIntervalInHours(1)
                        //每1分钟执行一次
                        .withIntervalInMinutes(1)
                        //次数为10次:withRepeatCount(10)
                        //次数不限
                        .repeatForever()).build();
        // 构建Cron表达式Trigger实例
        // Trigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(
        //         CronScheduleBuilder.cronSchedule("放置cron表达式处")
        // ).withIdentity("cronTrigger", "cronTriggerGroup").startNow().build();
        // 4.执行
        scheduler.scheduleJob(helloQuartz, trigger);
        scheduler.start();
    }
}
