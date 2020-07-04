package me.zhyd.oauth.enums.scope;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stackoverflow 平台 OAuth 授权范围
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum AuthStackoverflowScope implements AuthScope {

    /**
     * {@code scope} 含义，以{@code description} 为准
     */
    read_inbox("read_inbox", "access a user's global inbox", true),
    NO_EXPIRY("no_expiry", "access_token's with this scope do not expire", false),
    WRITE_ACCESS("write_access", "perform write operations as a user", false),
    PRIVATE_INFO("private_info", "access full history of a user's private actions on the site", false);

    private String scope;
    private String description;
    private boolean isDefault;

    public static List<AuthScope> getDefaultScopes() {
        AuthStackoverflowScope[] scopes = AuthStackoverflowScope.values();
        List<AuthScope> defaultScopes = new ArrayList<>();
        for (AuthStackoverflowScope scope : scopes) {
            if (scope.isDefault()) {
                defaultScopes.add(scope);
            }
        }
        return defaultScopes;
    }

    public static List<String> listScope() {
        return Arrays.stream(AuthStackoverflowScope.values()).map(AuthStackoverflowScope::getScope).collect(Collectors.toList());
    }
}