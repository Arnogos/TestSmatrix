package Try;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;

public interface Authentication extends Principal, Serializable {

    /**
     * Метод для получения прав пользователя,
     * не может возвращать null,
     * может вернуть пустой список, если пользователь
     * не аутентифицирован
     */
    Collection<? extends GrantedAuthority> getAuthorities();

    /**
     * Секретная информация для подтверждения подлинности
     * пользователя, например, пароль.
     */
    Object getCredentials();

    /**
     * Дополнительная информация о запросе (ip, серийный номер
     * сертификата и т.д.), может быть null, если не используется
     */
    Object getDetails();

    /**
     * Идентификатор пользователя в запросе аутентификации или
     * объект с данными об аутентифицированном пользователе
     */
    Object getPrincipal();

    /**
     * Является ли пользователь аутентифицированным
     */
    boolean isAuthenticated();

    /**
     * Изменение состояние аутентификации, может принимать только false
     */
    void setAuthenticated(boolean isAuthenticated)
            throws IllegalArgumentException;

}