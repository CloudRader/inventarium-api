//package com.cloudrader.inventarium.config.security
//
//import com.cloudrader.inventarium.adapter.repository.PlatformAdminRepository
//import org.springframework.security.core.userdetails.ReactiveUserDetailsService
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import org.springframework.stereotype.Service
//import reactor.core.publisher.Mono
//import reactor.core.scheduler.Schedulers
//
//@Service
//class PlatformAdminService(
//    private val platformAdminRepository: PlatformAdminRepository
//) : ReactiveUserDetailsService {
//
//    override fun findByUsername(username: String): Mono<UserDetails> {
//        return Mono.fromCallable {
//            platformAdminRepository.findByUsername(username)
//                ?: throw UsernameNotFoundException("Admin not found")
//        }
//            .subscribeOn(Schedulers.boundedElastic())
//            .map { admin ->
//                PlatformAdminSecurity(admin)
//            }
//    }
//}
