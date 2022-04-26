package com.chuck.common.app.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新事件的状态（已被发布、未发布等），对应数据库表
 *
 * @author Chuck
 * @since 2021年7月25日
 * @version 0.0.1
 * @apiNote
 */
@Getter
@Setter
@Entity
@Deprecated
public class PublishedMessageTracker {
  /** 对应eventId、messageId */
  private long mostRecentPublishedMessageId;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long trackerId;
  /** 对应topic、channel */
  private String type;

  public long mostRecentPublishedMessageId() {
    return this.getMostRecentPublishedMessageId();
  }
}
