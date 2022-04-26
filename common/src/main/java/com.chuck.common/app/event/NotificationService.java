package com.chuck.common.app.event;

import com.chuck.base.app.deprecated.MessageParameters;
import com.chuck.base.app.deprecated.MessageProducer;
import com.chuck.base.app.deprecated.Notification;
import com.chuck.base.app.deprecated.NotificationLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Chuck
 * @since 7/25/2021
 * @version 0.0.1
 * @apiNote
 */
@Deprecated
public class NotificationService {
  /**
   * 可用于支持以REST资源方式发布，1：如果存储的是事件，从EventStore中获取。如果存储的是消息，从Repository获取。2：每次获取后，要及时更新当前的Notification的下标。支持按ID范围返回区间内的Notification
   *
   * @return
   */
  @Transactional(readOnly = true)
  public NotificationLog currentNotificationLog() {
    return null;
  }

  /**
   * 可用于支持以REST资源方式发布
   *
   * @return
   */
  @Transactional(readOnly = true)
  public NotificationLog notificationLog(String anId) {
    return null;
  }

  private ObjectMapper objectMapper;

  private PublishedMessageTracker publishedMessageTracker;

  private MessageProducer messageProducer;

  /** 投递消息到中间件 */
  @Transactional
  public void publishNotifications() {
    PublishedMessageTracker publishedMessageTracker = this.publishedMessageTracker;
    List<Notification> notifications =
        this.listUnpublishedNotifications(publishedMessageTracker.mostRecentPublishedMessageId());
    // MessageProducer messageProducer = this.messageProducer;

    try (MessageProducer messageProducer = this.messageProducer) {
      for (Notification notification : notifications) {
        this.publish(notification, messageProducer);
      }
      this.trackMostRecentPublishedMessage(publishedMessageTracker, notifications);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private void trackMostRecentPublishedMessage(
      PublishedMessageTracker publishedMessageTracker, List<Notification> notifications) {}

  private void publish(Notification notification, MessageProducer messageProducer)
      throws JsonProcessingException {
    MessageParameters parameters =
        MessageParameters.durableTextParameters(
            notification.type(),
            Long.toString(notification.notificationId(), notification.occurredOn()));
    String notificationStr = objectMapper.writeValueAsString(notification);
    messageProducer.send(notificationStr, parameters);
  }

  private List<Notification> listUnpublishedNotifications(long mostRecentPublishedMessageId) {
    // return repository.findByIdSince();
    return null;
  }
}
