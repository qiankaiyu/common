package com.chuck.common.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Chuck
 * @since 8/2/2021
 * @version 0.0.1
 * @apiNote
 **/
//@Configuration
//@EnableScheduling
//@EnableAsync(mode = AdviceMode.PROXY, proxyTargetClass = true, order = Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class AsyncAndScheduledConfig implements AsyncConfigurer, SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        TaskScheduler scheduler = this.taskScheduler();
        log.info("Configuring scheduled method executor {}.", scheduler);
        taskRegistrar.setTaskScheduler(scheduler);
    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        log.info("Setting up thread pool task scheduler with 20 threads.");
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(20);
        scheduler.setThreadNamePrefix("task-");
        scheduler.setAwaitTerminationSeconds(60);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setErrorHandler(t -> log.error("Unknown error occurred while executing task.", t));
        scheduler.setRejectedExecutionHandler(
                (r, e) -> log.error("Execution of task {} was rejected for unknown reasons.", r));
        return scheduler;
    }

    @Override
    public Executor getAsyncExecutor() {
        Executor executor = this.taskScheduler();
        log.info("Configuring asynchronous method executor {}.", executor);
        return executor;
    }

}
