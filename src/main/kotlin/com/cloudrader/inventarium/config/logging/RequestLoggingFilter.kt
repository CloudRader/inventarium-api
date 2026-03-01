package com.cloudrader.inventarium.config.logging

import org.jboss.logging.MDC
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono
import java.util.UUID

@Component
class RequestLoggingFilter : WebFilter {

    override fun filter(
        exchange: ServerWebExchange,
        chain: WebFilterChain
    ): Mono<Void> {
        val requestId = UUID.randomUUID().toString()
        val request = exchange.request
        val response = exchange.response

        MDC.put("requestId", requestId)
        response.headers.add("X-Request-Id", requestId)

        val start = System.currentTimeMillis()

        return chain.filter(exchange)
            .doFinally {
                val duration = System.currentTimeMillis() - start

                log.info(
                    "HTTP {} {} -> {} ({} ms), requestId={}",
                    request.method,
                    request.path.value(),
                    response.statusCode?.value() ?: HttpStatus.OK.value(),
                    duration,
                    requestId
                )

                MDC.clear()
            }
    }
}
