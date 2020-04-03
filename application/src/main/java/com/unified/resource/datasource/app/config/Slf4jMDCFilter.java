package com.unified.resource.datasource.app.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class Slf4jMDCFilter extends OncePerRequestFilter {

  private static final String REQUEST_HEADER = "X-Transaction-Id";
  private static final String RESPONSE_HEADER = "X-Transaction-Id";
  private static final String MDC_TOKEN_KEY = "transactionId";
  private static final String MDC_CLIENT_IP_KEY = "clientIp";
  private static final String FORWARDED_FOR = "X-Forwarded-For";

  @Override
  protected void doFilterInternal(final HttpServletRequest request,
                                  final HttpServletResponse response, final FilterChain chain)
      throws java.io.IOException, ServletException {
    try {
      String token = extractToken(request);

      MDC.put(MDC_CLIENT_IP_KEY, getClientIp(request));
      MDC.put(MDC_TOKEN_KEY, token);

      if (!StringUtils.isEmpty(RESPONSE_HEADER)) {
        response.addHeader(RESPONSE_HEADER, token);
      }
      chain.doFilter(request, response);
    } finally {
      MDC.remove(MDC_TOKEN_KEY);
      MDC.remove(MDC_CLIENT_IP_KEY);
    }
  }

  private String extractToken(final HttpServletRequest request) {
    if (!StringUtils.isEmpty(REQUEST_HEADER) && !StringUtils
        .isEmpty(request.getHeader(REQUEST_HEADER))) {
      return request.getHeader(REQUEST_HEADER);
    }
    return UUID.randomUUID().toString().toUpperCase().replace("-", "");
  }

  private String getClientIp(final HttpServletRequest request) {
    if (request.getHeader(FORWARDED_FOR) != null) {
      return request.getHeader(FORWARDED_FOR).split(",")[0];
    }
    return request.getRemoteAddr();
  }

  @Override
  protected boolean isAsyncDispatch(final HttpServletRequest request) {
    return false;
  }

  @Override
  protected boolean shouldNotFilterErrorDispatch() {
    return false;
  }
}
