package ua.uc.framework.holders.meta;

import ua.uc.framework.model.RequestMethod;
import ua.uc.framework.model.meta.URLMeta;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by kostya on 23.06.15.
 */
public class URLMetaHolder {
    private static final URLMetaHolder URL_META_HOLDER = new URLMetaHolder();

    public static URLMetaHolder get() {
        return URL_META_HOLDER;
    }

    private HashMap<String, Collection<URLMeta>> holder = new HashMap<>();

    private URLMetaHolder() {}

    public void put(String url, Collection<URLMeta> meta) {
        if (holder.containsKey(url)) {
            holder.get(url).addAll(meta);
        } else {
            holder.put(url, meta);
        }
    }

    public URLMeta get(String url, RequestMethod requestMethod) {
        return holder.get(url).stream().filter(m -> m.getRequestMethod().equals(requestMethod)).findFirst().get();
    }
}
