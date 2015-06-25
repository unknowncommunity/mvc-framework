package ua.uc.framework.holders.processors;

import ua.uc.framework.model.meta.URLMeta;
import ua.uc.framework.processors.request.RequestProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kostya on 25.06.15.
 */
public class ProcessorsHolder {
    private static final ProcessorsHolder PROCESSORS_HOLDER = new ProcessorsHolder();

    public static ProcessorsHolder get() {
        return PROCESSORS_HOLDER;
    }

    private ProcessorsHolder() {

    }

    private final Map<URLMeta, RequestProcessor> holder = new HashMap<>();

    public void put(URLMeta key, RequestProcessor value) {
        holder.put(key, value);
    }

    public RequestProcessor get(URLMeta key) {
        return holder.get(key);
    }
}
