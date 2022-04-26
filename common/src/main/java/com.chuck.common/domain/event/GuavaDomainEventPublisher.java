package com.chuck.common.domain.event;

import com.chuck.base.client.dto.event.DomainEvent;
import com.chuck.base.domain.event.GuavaDomainEventSubscriber;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Chuck
 * @version 0.0.1
 * @apiNote
 * @since 8/2/2021
 */
@Getter
@Setter
public class GuavaDomainEventPublisher {

  private static final ExecutorService NEW_FIXED_THREAD_POOL =
      new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

  private static final ThreadPoolTaskExecutor CUSTOM_THREAD_POOL = new ThreadPoolTaskExecutor();
  private static GuavaDomainEventPublisher publisher = new GuavaDomainEventPublisher();

  static {
    CUSTOM_THREAD_POOL.setCorePoolSize(5);
    CUSTOM_THREAD_POOL.setMaxPoolSize(5);
    CUSTOM_THREAD_POOL.setQueueCapacity(10);
    CUSTOM_THREAD_POOL.setThreadNamePrefix("event-bus-task");
    CUSTOM_THREAD_POOL.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    CUSTOM_THREAD_POOL.initialize();
  }

  private final EventBus syncBus = new EventBus();
  private final EventBus asyncBus = new AsyncEventBus(CUSTOM_THREAD_POOL);
  private String identify;

  // ----------------------------------------Field

  private GuavaDomainEventPublisher() {}

  public GuavaDomainEventPublisher(String identify) {
    this.setIdentify(identify);
  }
  ;

  public static GuavaDomainEventPublisher instance() {
    return publisher;
  }

  // ----------------------------------------Method

  public void publish(final DomainEvent aDomainEvent) {
    syncBus.post(aDomainEvent);
  }

  public void asyncPublish(final DomainEvent aDomainEvent) {
    asyncBus.post(aDomainEvent);
  }

  public <T> void subscribe(GuavaDomainEventSubscriber<T> aSubscriber) {
    syncBus.register(aSubscriber);
    asyncBus.register(aSubscriber);
  }
}
