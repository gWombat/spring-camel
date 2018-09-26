package fr.gwombat.springcamel.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gfabbi
 **/
abstract class AbstractComponentBuilder {

    private String              routeName;
    private Map<String, Object> params;

    AbstractComponentBuilder(String routeName) {
        this.params = new HashMap<>(0);
        this.routeName = routeName;
    }

    protected void addParameter(String key, Object value) {
        this.params.put(key, value);
    }

    private String buildParameters() {
        return params
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue().toString())
                .collect(Collectors.joining("&"));
    }

    protected abstract String getPrefix();

    public String build() {
        final StringBuilder stringBuilder = new StringBuilder(getPrefix()).append(routeName);
        if (params.isEmpty())
            return stringBuilder.toString();

        String paramsAsString = buildParameters();
        if (paramsAsString != null && !"".equals(paramsAsString))
            stringBuilder.append("?").append(paramsAsString);

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return build();
    }
}
