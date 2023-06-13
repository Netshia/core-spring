//package com.ndivhuho.learnspring.springdata.servlet;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[] { MyWebAppInitializer.class };
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return null;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return null;
//    }
//
////    public static ExchangeFilterFunction errorHandler() {
////        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
////            if (clientResponse.statusCode().is5xxServerError()) {
////                return clientResponse.bodyToMono(String.class)
////                        .flatMap(errorBody -> Mono.error(new UserDefinedException1(errorBody)));
////            } else if (clientResponse.statusCode().is4xxClientError()) {
////                return clientResponse.bodyToMono(String.class)
////                        .flatMap(errorBody -> Mono.error(new UserDefinedException2(errorBody)));
////            } else {
////                return Mono.just(clientResponse);
////            }
////        });
////    }
////
////    try {
////        String response = webClient.get()
////                .retrieve()
////                .onStatus(httpStatus -> httpStatus.value() == <desired Status code>,
////                        error -> Mono.error(new UserDefinedException("error Body")))
////                .bodyToMono(String.class)
////                .block();
////    } catch(UserDefinedException userDefinedException) {
////        //exception handling logic
////    }
//}
//
