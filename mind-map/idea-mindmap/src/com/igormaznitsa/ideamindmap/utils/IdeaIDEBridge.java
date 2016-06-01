package com.igormaznitsa.ideamindmap.utils;

import static com.intellij.openapi.ui.playback.PlaybackRunner.StatusCallback.Type.message;

import com.igormaznitsa.commons.version.Version;
import com.igormaznitsa.mindmap.model.logger.Logger;
import com.igormaznitsa.mindmap.model.logger.LoggerFactory;
import com.igormaznitsa.mindmap.swing.ide.IDEBridge;
import com.igormaznitsa.mindmap.swing.ide.NotificationType;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationInfo;
import com.intellij.openapi.application.ApplicationManager;
import org.apache.commons.lang.StringEscapeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.swing.Icon;

public class IdeaIDEBridge implements IDEBridge {

  private final Version ideVersion;
  private static final Logger LOGGER = LoggerFactory.getLogger(IdeaIDEBridge.class);
  private static final NotificationGroup MMD_GROUP = new NotificationGroup("IDEA MindMap",NotificationDisplayType.BALLOON,true);

  public IdeaIDEBridge() {
    final ApplicationInfo info = ApplicationInfo.getInstance();
    final long major = safeNumberExtraction(info.getMajorVersion());
    final long minor = safeNumberExtraction(info.getMinorVersion());
    final long micro = safeNumberExtraction(info.getMicroVersion());
    this.ideVersion = new Version("intellij", new long[] { major, minor, micro }, info.getVersionName());
  }

  private static long safeNumberExtraction(final String data) {
    if (data == null)
      return 0L;
    final StringBuilder buffer = new StringBuilder();
    for (final char c : data.toCharArray()) {
      if (Character.isDigit(c))
        buffer.append(c);
    }
    try {
      return Long.parseLong(buffer.toString());
    }
    catch (NumberFormatException ex) {
      return 0L;
    }
  }

  @Nonnull @Override public Version getIDEVersion() {
    return this.ideVersion;
  }

  @Override public void showIDENotification(@Nonnull final String title, @Nonnull final String text, @Nonnull final NotificationType type) {
    final com.intellij.notification.NotificationType ideType;
    switch (type) {
    case INFO: {
      ideType = com.intellij.notification.NotificationType.INFORMATION;
      LOGGER.info("{INFO}IDENotification : (" + title + ") " + message);
    }
    break;
    case WARNING: {
      ideType = com.intellij.notification.NotificationType.WARNING;
      LOGGER.warn("{WARN}IDENotification : (" + title + ") " + message);
    }
    break;
    case ERROR: {
      ideType = com.intellij.notification.NotificationType.ERROR;
      LOGGER.warn("{ERROR}IDENotification : (" + title + ") " + message);
    }
    break;
    default: {
      ideType = com.intellij.notification.NotificationType.WARNING;
      LOGGER.warn("{*****}IDENotification : (" + title + ") " + message);
    }
    break;
    }

    ApplicationManager.getApplication().invokeLater(new Runnable() {
      @Override public void run() {
        final long timestamp = System.currentTimeMillis();
        final Notification notification = new Notification(MMD_GROUP.getDisplayId(),StringEscapeUtils.escapeHtml(title), StringEscapeUtils.escapeHtml(text), ideType){
          @Nullable @Override public Icon getIcon() {
            return AllIcons.Logo.MINDMAP;
          }

          @Override public long getTimestamp() {
            return timestamp;
          }
        };
        Notifications.Bus.notify(notification);
      }
    });
  }
}
