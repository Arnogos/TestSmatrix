/*
package Try;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

class AuthFilter extends OncePerRequestFilter {

    SecurityContextHolderStrategy secCtxHldStr;

    SecurityContextRepository secCtxRep;

    AuthenticationManager authMan;

    AuthenticationEntryPoint authEntPt;

    boolean ignoreFailure;

    public void doFilterInternal(HttpServletRequest req,
                                 HttpServletResponse resp,
                                 FilterChain chain)
            throws ServletException, IOException {
        // Создать запрос аутентификации
        var authReq = this.buildAuthReq(req);
        // Если запрос содержит данные аутентификации, то попытаться обработать их
        if (authReq != null) {
            try {
                // Попытаться аутентифицировать
                var authRes = this.authMan.authenticate(authReq);
                // Создать новый контекст безопасности
                var secCtx = this.secCtxHldStr.createEmptyContext();
                // Сохранить результат аутентификации в контексте безопасности
                secCtx.setAuthentication(authRes);
                // Сохранить контекст
                this.secCtxHldStr.setContext(secCtx);
                this.secCtxRep.saveContext(secCtx, req, resp);
            } catch (AuthenticationException e) {
                // В случае ошибки очистить контекст безопасности
                this.secCtxHldStr.clearContext();
                if (!this.ignoreFailure) {
                    // Если ошибки аутентификации не игнорируются,
                    // то запросить у пользователя данные для аутентификации
                    // при помощи точки входа
                    this.authEntPt.commence(req, resp, e);
                    // И прервать обработку запроса
                    return;
                }
            }
        }

        // И продолжить обработку запроса
        chain.doFilter(req, resp);
    }
}*/
