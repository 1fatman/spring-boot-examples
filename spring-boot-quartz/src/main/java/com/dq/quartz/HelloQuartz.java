package com.dq.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/5
 * @Description: TODO
 */
public class HelloQuartz implements Job {

    /**
     * DataTimeFormat
     */
    private static final ThreadLocal<DateTimeFormatter> df = new ThreadLocal<DateTimeFormatter>() {
        @Override
        protected DateTimeFormatter initialValue() {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * 输出Hello World Quartz
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello World Quartz!" + df.get().format(LocalDateTime.now()));
    }
}
