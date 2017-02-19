package x3.benjamin.playground.apiserver.utils;

import org.springframework.context.support.MessageSourceAccessor;

/**
 * Created by benjamin on 2017. 2. 20..
 */
public class MessageBundleUtil {
    private MessageSourceAccessor accessor = null;

    /**
     * Gets the message.
     *
     * @param key the key
     * @return the message
     */
    public String getMessage(String key) {
        return accessor.getMessage(key);
    }

    /**
     * Gets the message with param.
     *
     * @param key the key
     * @param params the params
     * @return the message with param
     */
    public String getMessageWithParam(String key, String[] params) {
        return accessor.getMessage(key, params);
    }

    /**
     * Sets the message source accessor.
     *
     * @param msAcc the new message source accessor
     */
    public void setMessageSourceAccessor(MessageSourceAccessor accessor) {
        this.accessor = accessor;
    }
}
